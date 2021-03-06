package m.pekka.climbinapptest.Hangboard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import m.pekka.climbinapptest.SQLiteHelper;

/**
 * Created by Pekka Melgin on 23.10.2015.
 */
public class DBMapper implements HangboardMapper {

    private SQLiteDatabase db;

    public DBMapper(Context context) {
        this.db = new SQLiteHelper(context).getWritableDatabase();
    }

    @Override
    public long insertHang(HangboardEntity hangboardEntity) throws Exception {
        ContentValues values = new ContentValues();
        values.put("Time", hangboardEntity.getTime());
        long id = this.db.insert("Hangboard", null, values);
        if (id == -1) {
            throw new Exception();
        }
        return id;
    }

    @Override
    public Cursor fetchAll() {
        return this.db.rawQuery("SELECT Time FROM Hangboard", null);
    }
}
