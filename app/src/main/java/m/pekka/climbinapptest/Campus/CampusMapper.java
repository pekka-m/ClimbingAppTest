package m.pekka.climbinapptest.Campus;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import m.pekka.climbinapptest.SQLiteHelper;

/**
 * Created by Pekka Melgin on 22.10.2015.
 */
public class CampusMapper {

    private SQLiteDatabase db;

    public CampusMapper(Context context) {
        this.db = new SQLiteHelper(context).getWritableDatabase();
    }

    public long insertCampus(CampusEntity campusEntity) {
        ContentValues values = new ContentValues();
        values.put("Steps", campusEntity.getSteps());
        return this.db.insert("Campus", null, values);
    }

    public Cursor fetchAll() {
        return this.db.rawQuery("SELECT Steps FROM Campus", null);
    }
}
