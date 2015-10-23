package m.pekka.climbinapptest.Climb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import m.pekka.climbinapptest.SQLiteHelper;

/**
 * Created by Pekka Melgin on 22.10.2015.
 */
public class DBMapper implements ClimbMapper {

    private SQLiteDatabase db;

    public DBMapper(Context context) {
        this.db = new SQLiteHelper(context).getWritableDatabase();
    }

    @Override
    public long insertClimb(ClimbEntity climbEntity) throws Exception {
        ContentValues values = new ContentValues();
        values.put("Grade", climbEntity.getGrade());
        long id = this.db.insert("Climb", null, values);
        if (id == -1) {
            throw new Exception();
        }
        return id;
    }

    @Override
    public Cursor fetchAll() {
        return this.db.rawQuery("SELECT Grade FROM Climb", null);
    }
}
