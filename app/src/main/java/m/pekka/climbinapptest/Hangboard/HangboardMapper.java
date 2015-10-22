package m.pekka.climbinapptest.Hangboard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import m.pekka.climbinapptest.SQLiteHelper;

/**
 * Created by Pekka Melgin on 23.10.2015.
 */
public class HangboardMapper {

    private SQLiteDatabase db;
    private Cursor cursor;

    public HangboardMapper(Context context) {
        this.db = new SQLiteHelper(context).getWritableDatabase();
    }

    public long insertHang(HangboardEntity hangboardEntity) {
        ContentValues values = new ContentValues();
        values.put("Time", hangboardEntity.getTime());
        return this.db.insert("Hangboard", null, values);
    }

    public Cursor fetchAll() {
        return this.db.rawQuery("SELECT Time FROM Hangboard", null);
    }
}
