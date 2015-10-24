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
    private GradeConverter converter;
    private Cursor cursor;

    public ClimbInteractor(Context context) {
        this.mapper = new DBMapper(context);
        this.converter = new GradeConverter();
    }

    public long addClimb(String[] grade) throws Exception {
        climbEntity = new ClimbEntity();
        if (grade[1].equals("")) {
            grade[1] = "-";
        }
        climbEntity.setGrade(this.converter.gradeToInt(grade[0] + grade[1].toUpperCase() + "-"));
        if (climbEntity.getGrade() == -1) {
            throw new Exception();
        }
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

    public String getAvgGrade() {
        int totalGrade = 0;
        int gradeCount = 0;
        this.cursor = this.mapper.fetchAll();
        if (cursor.moveToFirst()) {
            do {
                totalGrade += cursor.getInt(0);
                gradeCount++;
            } while (cursor.moveToNext());
            return converter.intToGrade(totalGrade / gradeCount);
        }
        return "";
    }
}
