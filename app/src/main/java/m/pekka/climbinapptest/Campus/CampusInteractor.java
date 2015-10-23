package m.pekka.climbinapptest.Campus;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by Pekka Melgin on 22.10.2015.
 */
public class CampusInteractor {

    private CampusEntity campusEntity;
    private CampusMapper mapper;
    private Cursor cursor;

    public CampusInteractor(Context context) {
        this.mapper = new DBMapper(context);
    }

    public long addCampus(int steps) throws Exception {
        this.campusEntity = new CampusEntity();
        this.campusEntity.setSteps(steps);
        return mapper.insertCampus(this.campusEntity);
    }

    public long getCampusCount() {
        this.cursor = this.mapper.fetchAll();
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
        Cursor cursor = this.mapper.fetchAll();
        if (cursor.moveToFirst()) {
            do {
                totalSteps += cursor.getInt(0);
            } while (cursor.moveToNext());
        }
        return totalSteps;
    }
}
