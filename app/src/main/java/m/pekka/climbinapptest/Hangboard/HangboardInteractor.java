package m.pekka.climbinapptest.Hangboard;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by Pekka Melgin on 22.10.2015.
 */
public class HangboardInteractor {

    private HangboardEntity hangboardEntity;
    private HangboardMapper hangboardMapper;

    public HangboardInteractor(Context context) {
        this.hangboardMapper = new HangboardMapper(context);
    }

    public long addHang(int time) {
        hangboardEntity = new HangboardEntity();
        hangboardEntity.setTime(time);
        return hangboardMapper.insertHang(hangboardEntity);
    }

    public long getTotalHang() {
        long totalHang = 0;
        Cursor cursor = this.hangboardMapper.fetchAll();
        if (cursor.moveToFirst()) {
            do {
                totalHang += cursor.getInt(0);
            } while (cursor.moveToNext());
        }
        return totalHang;
    }
}
