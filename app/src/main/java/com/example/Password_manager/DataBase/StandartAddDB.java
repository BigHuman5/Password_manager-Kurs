package com.example.Password_manager.DataBase;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.Password_manager.MainActivity;

public class StandartAddDB {

    private String masterKey = "123";

    public StandartAddDB(SQLiteDatabase db) {

        ContentValues contentValues = new ContentValues(); // Для удобной работы с бд

        contentValues.put(DBHelper.getKeyId(),0);
        contentValues.put(DBHelper.getKeyType(),0);
        contentValues.put(DBHelper.getKEY_1ArgValue(),"Secret key");
        contentValues.put(DBHelper.getKeyFavorite(),false);

        Log.d("mLog2","ID = "+contentValues.get(DBHelper.getKeyId())
                +"| Type = "+contentValues.get(DBHelper.getKeyType())
                +"| Name = "+contentValues.get(DBHelper.getKEY_1ArgValue()));
        db.insert(DBHelper.getTableName(),null,contentValues);

    }
}
