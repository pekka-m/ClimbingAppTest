package m.pekka.climbinapptest.Climb;

import android.database.Cursor;

/**
 * Created by Pekka Melgin on 23.10.2015.
 */
public interface ClimbMapper {
    long insertClimb(ClimbEntity climbEntity) throws Exception;
    Cursor fetchAll();
}
