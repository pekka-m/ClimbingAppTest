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
    public long insertHang(HangboardEntity hangboardEntity) {
        ContentValues values = new ContentValues();
        values.put("Time", hangboardEntity.getTime());
        return this.db.insert("Hangboard", null, values);
    }

    @Override
    public Cursor fetchAll() {
        return this.db.rawQuery("SELECT Time FROM Hangboard", null);
    }
}
