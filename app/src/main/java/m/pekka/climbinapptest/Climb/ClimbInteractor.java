package m.pekka.climbinapptest.Climb;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by Pekka Melgin on 22.10.2015.
 */
public class ClimbInteractor {

    private ClimbEntity climbEntity;
    private ClimbMapper climbMapper;
    private Cursor cursor;

    public ClimbInteractor(Context context) {
        this.climbMapper = new ClimbMapper(context);
    }

    public long addClimb(String grade) {
        climbEntity = new ClimbEntity();
        climbEntity.setGrade(grade);
        return climbMapper.insertClimb(climbEntity);
    }

    public long getClimbCount() {
        this.cursor = this.climbMapper.fetchAll();
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
        this.cursor = this.climbMapper.fetchAll();
        if (cursor.moveToFirst()) {
            do {
                totalGrade += cursor.getInt(0);
                gradeCount++;
            } while (cursor.moveToNext());
        }
        return totalGrade / gradeCount;
    }
}
