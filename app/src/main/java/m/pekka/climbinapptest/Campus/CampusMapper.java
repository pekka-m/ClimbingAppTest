package m.pekka.climbinapptest.Campus;

import android.database.Cursor;

/**
 * Created by Pekka Melgin on 23.10.2015.
 */
public interface CampusMapper {
    long insertCampus(CampusEntity campusEntity) throws Exception;

    Cursor fetchAll();
}
