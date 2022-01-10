package com.example.Password_manager.DataBase;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Password_manager";
    public static final String TABLE_INFORMATION = "information";

    public static final String KEY_ID = "_id";
    public static final String KEY_TYPE = "type_info";
    public static final String KEY_1Arg = "Arg1";
    public static final String KEY_2Arg = "Arg2";
    public static final String KEY_3Arg = "Arg3";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_INFORMATION+ "(" +
                KEY_ID + " INTEGER primary key autoincrement NOT NULL," +
                KEY_TYPE + " INTEGER NOT NULL," +
                KEY_1Arg + " TEXT NOT NULL," +
                KEY_2Arg + " TEXT," +
                KEY_3Arg + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
