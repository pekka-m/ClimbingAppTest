package m.pekka.climbinapptest.Campus;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by Pekka Melgin on 22.10.2015.
 */
public class CampusInteractor {

    private CampusEntity campusEntity;
    private CampusMapper campusMapper;
    private Cursor cursor;

    public CampusInteractor(Context context) {
        this.campusMapper = new CampusMapper(context);
    }

    public long addCampus(int steps) {
        this.campusEntity = new CampusEntity();
        this.campusEntity.setSteps(steps);
        return campusMapper.insertCampus(this.campusEntity);
    }

    public long getCampusCount() {
        this.cursor = this.campusMapper.fetchAll();
        long campusCount = 0;
        if (cursor.moveToFirst()) {
            do {
                campusCount++;
            } while (cursor.moveToNext());
        }
        return campusCount;
    }

    public long getTotalSteps() {
        long totalSteps = 0;
        Cursor cursor = this.campusMapper.fetchAll();
        if (cursor.moveToFirst()) {
            do {
                totalSteps += cursor.getInt(0);
            } while (cursor.moveToNext());
        }
        return totalSteps;
    }
}
