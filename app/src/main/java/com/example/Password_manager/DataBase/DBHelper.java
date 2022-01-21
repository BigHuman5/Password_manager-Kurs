package com.example.Password_manager.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.Password_manager.MainActivity;

public class DBHelper extends SQLiteOpenHelper {

    private DBHelper dbHelper;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Password_manager";
    public static final String TABLE_INFORMATION = "information";

    public static final String KEY_ID = "_id";
    public static final String KEY_POSITION = "Position";
    public static final String KEY_TYPE = "type_info";
    public static final String KEY_NAME = "Name";
    public static final String KEY_FAVORITE = "Favorite";

    public static final String KEY_1ArgValue = "Arg1Value";
    public static final String KEY_1ArgSecure = "Arg1Secure";

    public static final String KEY_2ArgValue = "Arg2Value";
    public static final String KEY_2ArgSecure = "Arg2Secure";

    public static final String KEY_3ArgValue = "Arg3Value";
    public static final String KEY_3ArgSecure = "Arg3Secure";

    public static final String KEY_4ArgValue = "Arg4Value";
    public static final String KEY_4ArgSecure = "Arg4Secure";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_INFORMATION+ "(" +
                KEY_ID + " INTEGER primary key autoincrement NOT NULL," +
                KEY_POSITION + " INTEGER," +
                KEY_TYPE + " INTEGER NOT NULL," +
                KEY_NAME + " TEXT NOT NULL," +
                KEY_FAVORITE + " BOOLEAN CHECK ("+KEY_FAVORITE+" IN (0, 1))," +

                KEY_1ArgValue + " TEXT," +
                KEY_1ArgSecure + " BOOLEAN CHECK ("+KEY_1ArgSecure+" IN (0, 1))," +

                KEY_2ArgValue + " TEXT," +
                KEY_2ArgSecure + " BOOLEAN CHECK ("+KEY_2ArgSecure+" IN (0, 1))," +

                KEY_3ArgValue + " TEXT," +
                KEY_3ArgSecure + " BOOLEAN CHECK ("+KEY_3ArgSecure+" IN (0, 1))," +

                KEY_4ArgValue + " TEXT," +
                KEY_4ArgSecure + " BOOLEAN CHECK ("+KEY_4ArgSecure+" IN (0, 1)))");

        new StandartAddDB(db);
        //setDefaultLabel(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void setDefaultLabel(SQLiteDatabase db) {
        // create default label
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.KEY_ID,0);
        contentValues.put(DBHelper.KEY_TYPE,0);
        contentValues.put(DBHelper.KEY_NAME,"Secret key");
        contentValues.put(DBHelper.KEY_FAVORITE,false);

        db.insert(DBHelper.TABLE_INFORMATION,null,contentValues);
    }

}
