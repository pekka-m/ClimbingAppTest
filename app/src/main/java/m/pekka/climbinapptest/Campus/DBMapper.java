package m.pekka.climbinapptest.Campus;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import m.pekka.climbinapptest.SQLiteHelper;

/**
 * Created by Pekka Melgin on 22.10.2015.
 */
public class DBMapper implements CampusMapper {

    private SQLiteDatabase db;

    public DBMapper(Context context) {
        this.db = new SQLiteHelper(context).getWritableDatabase();
    }

    @Override
    public long insertCampus(CampusEntity campusEntity) throws Exception {
        ContentValues values = new ContentValues();
        values.put("Steps", campusEntity.getSteps());
        long id = this.db.insert("Campus", null, values);
        if (id == -1) {
            throw new Exception();
        }
        return id;
    }

    @Override
    public Cursor fetchAll() {
        return this.db.rawQuery("SELECT Steps FROM Campus", null);
    }
}
