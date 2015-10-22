package m.pekka.climbinapptest.Climb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import m.pekka.climbinapptest.SQLiteHelper;

/**
 * Created by Pekka Melgin on 22.10.2015.
 */
public class ClimbMapper {

    private SQLiteDatabase db;

    public ClimbMapper(Context context) {
        this.db = new SQLiteHelper(context).getWritableDatabase();
    }

    public long insertClimb(ClimbEntity climbEntity) {
        ContentValues values = new ContentValues();
        values.put("Grade", climbEntity.getGrade());
        return this.db.insert("Climb", null, values);
    }

    public Cursor fetchAll() {
        return this.db.rawQuery("SELECT Grade FROM Climb", null);
    }
}
