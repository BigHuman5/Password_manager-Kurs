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

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Password_manager";
    private static final String TABLE_NAME = "information";

    private static final String KEY_ID = "_id";
    private static final String KEY_POSITION = "Position";
    private static final String KEY_TYPE = "type_info";
    private static final String KEY_NAME = "name";
    private static final String KEY_FAVORITE = "favorite";

    private static final String KEY_1ArgValue = "arg1Value";
    private static final String KEY_2ArgValue = "arg2Value";
    private static final String KEY_3ArgValue = "arg3Value";
    private static final String KEY_4ArgValue = "arg4Value";
    private static final String KEY_5ArgValue = "arg5Value";
    private static final String KEY_6ArgValue = "arg6Value";
    private static final String KEY_7ArgValue = "arg7Value";
    private static final String KEY_8ArgValue = "arg8Value";
    private static final String KEY_9ArgValue = "arg9Value";
    private static final String KEY_10ArgValue = "arg10Value";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME+ "(" +
                KEY_ID + " INTEGER primary key autoincrement NOT NULL," +
                KEY_POSITION + " INTEGER," +
                KEY_TYPE + " INTEGER NOT NULL," +
                KEY_NAME + " TEXT," +
                KEY_FAVORITE + " BOOLEAN CHECK ("+KEY_FAVORITE+" IN (0, 1))," +

                KEY_1ArgValue + " TEXT," +
                KEY_2ArgValue + " TEXT," +
                KEY_3ArgValue + " TEXT," +
                KEY_4ArgValue + " TEXT," +
                KEY_5ArgValue + " TEXT," +
                KEY_6ArgValue + " TEXT," +
                KEY_7ArgValue + " TEXT," +
                KEY_8ArgValue + " TEXT," +
                KEY_9ArgValue + " TEXT," +
                KEY_10ArgValue + " TEXT)");

        new StandartAddDB(db);
        //setDefaultLabel(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public static int getDatabaseVersion() {
        return DATABASE_VERSION;
    }

    @Override
    public String getDatabaseName() {
        return DATABASE_NAME;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getKeyId() {
        return KEY_ID;
    }

    public static String getKeyPosition() {
        return KEY_POSITION;
    }

    public static String getKeyType() {
        return KEY_TYPE;
    }

    public static String getKeyFavorite() {
        return KEY_FAVORITE;
    }

    public static String getKeyName() {
        return KEY_NAME;
    }

    public static String getKEY_1ArgValue() {
        return KEY_1ArgValue;
    }

    public static String getKEY_2ArgValue() {
        return KEY_2ArgValue;
    }

    public static String getKEY_3ArgValue() {
        return KEY_3ArgValue;
    }

    public static String getKEY_4ArgValue() {
        return KEY_4ArgValue;
    }

    public static String getKEY_5ArgValue() {
        return KEY_5ArgValue;
    }

    public static String getKEY_6ArgValue() {
        return KEY_6ArgValue;
    }

    public static String getKEY_7ArgValue() {
        return KEY_7ArgValue;
    }

    public static String getKEY_8ArgValue() {
        return KEY_8ArgValue;
    }

    public static String getKEY_9ArgValue() {
        return KEY_9ArgValue;
    }

    public static String getKEY_10ArgValue() {
        return KEY_10ArgValue;
    }

}
