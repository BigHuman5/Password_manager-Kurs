package com.example.Password_manager.DataBase;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.Password_manager.MainActivity;

public class StandartAddDB {

    private String masterKey = "123";

    public StandartAddDB(SQLiteDatabase db) {

        ContentValues contentValues = new ContentValues(); // Для удобной работы с бд

        contentValues.put(DBHelper.KEY_ID,0);
        contentValues.put(DBHelper.KEY_TYPE,0);
        contentValues.put(DBHelper.KEY_NAME,"Secret key");
        contentValues.put(DBHelper.KEY_FAVORITE,false);

        Log.d("mLog2","ID = "+contentValues.get(DBHelper.KEY_ID)
                +"| Type = "+contentValues.get(DBHelper.KEY_TYPE)
                +"| Name = "+contentValues.get(DBHelper.KEY_FAVORITE));
        db.insert(DBHelper.TABLE_INFORMATION,null,contentValues);

    }
}
