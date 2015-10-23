package m.pekka.climbinapptest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Pekka Melgin on 23.10.2015.
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ClimbDB";

    private static final String TABLE_CLIMB = "Climb";
    private static final String TABLE_CAMPUS = "Campus";
    private static final String TABLE_HANGBOARD = "Hangboard";

    private static final String KEY_ID = "_id";
    private static final String KEY_GRADE = "Grade";
    private static final String KEY_STEPS = "Steps";
    private static final String KEY_TIME = "Time";

    private static final String CREATE_TABLE_CLIMB = "CREATE TABLE " + TABLE_CLIMB + " (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_GRADE + " TEXT);";
    private static final String CREATE_TABLE_CAMPUS = "CREATE TABLE " + TABLE_CAMPUS + " (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_STEPS + " INTEGER);";
    private static final String CREATE_TABLE_HANGBOARD = "CREATE TABLE " + TABLE_HANGBOARD + " (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_TIME + " INTEGER);";

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CLIMB);
        db.execSQL(CREATE_TABLE_CAMPUS);
        db.execSQL(CREATE_TABLE_HANGBOARD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLIMB);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CAMPUS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HANGBOARD);
    }
}
