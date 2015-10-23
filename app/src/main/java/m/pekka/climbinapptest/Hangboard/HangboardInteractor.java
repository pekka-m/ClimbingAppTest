package m.pekka.climbinapptest.Hangboard;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by Pekka Melgin on 22.10.2015.
 */
public class HangboardInteractor {

    private HangboardEntity hangboardEntity;
    private HangboardMapper mapper;
    private Cursor cursor;

    public HangboardInteractor(Context context) {
        this.mapper = new DBMapper(context);
    }

    public long addHang(int time) throws Exception {
        hangboardEntity = new HangboardEntity();
        hangboardEntity.setTime(time);
        return mapper.insertHang(hangboardEntity);
    }

    public long getHangboardCount() {
        this.cursor = this.mapper.fetchAll();
        long hangboardCount = 0;
        if (cursor.moveToFirst()) {
            do {
                hangboardCount++;
            } while (cursor.moveToNext());
        }
        return hangboardCount;
    }

    public long getTotalHang() {
        long totalHang = 0;
        this.cursor = this.mapper.fetchAll();
        if (cursor.moveToFirst()) {
            do {
                totalHang += cursor.getInt(0);
            } while (cursor.moveToNext());
        }
        return totalHang;
    }
}
