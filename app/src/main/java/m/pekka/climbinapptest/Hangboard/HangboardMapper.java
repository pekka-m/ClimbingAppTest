package m.pekka.climbinapptest.Hangboard;

import android.database.Cursor;

/**
 * Created by Pekka Melgin on 23.10.2015.
 */
public interface HangboardMapper {
    long insertHang(HangboardEntity entity) throws Exception;
    Cursor fetchAll();
}
