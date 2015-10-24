package m.pekka.climbinapptest.Climb;

import android.content.Context;
import android.database.Cursor;

import m.pekka.climbinapptest.Hangboard.HangboardMapper;

/**
 * Created by Pekka Melgin on 22.10.2015.
 */
public class ClimbInteractor {

    private ClimbEntity climbEntity;
    private ClimbMapper mapper;
    private Cursor cursor;

    public ClimbInteractor(Context context) {
        this.mapper = new DBMapper(context);
    }

    public long addClimb(String[] grade) throws Exception {
        climbEntity = new ClimbEntity();
        climbEntity.setGrade(grade[0] + grade[1]);
        return mapper.insertClimb(climbEntity);
    }

    public long getClimbCount() {
        this.cursor = this.mapper.fetchAll();
        long climbCount = 0;
        if (cursor.moveToFirst()) {
            do {
                climbCount++;
            } while (cursor.moveToNext());
        }
        return climbCount;
    }

    public long getAvgGrade() {
        long totalGrade = 0;
        long gradeCount = 0;
        String grade;
        this.cursor = this.mapper.fetchAll();
        if (cursor.moveToFirst()) {
            do {
                grade = cursor.getString(0); //grade = 9A
                grade = grade.replaceAll("[^0-9]+", ""); //grade = 9
                totalGrade += Integer.parseInt(grade); //grade to int
                gradeCount++;
            } while (cursor.moveToNext());
            return totalGrade / gradeCount;
        }
        return 0;
    }
}
