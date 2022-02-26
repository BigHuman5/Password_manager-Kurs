package com.example.Password_manager.DataBase;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.Password_manager.MainActivity;
import com.example.Password_manager.Notes.NewNoteActivity;
import com.example.Password_manager.Notes.NewNoteAdapter;
import com.example.Password_manager.Notes.model.Fields;
import com.example.Password_manager.Notes.typesNotes;

import java.util.ArrayList;

public class ActionsWithBD {

    private static DBHelper dbHelper;

    public static void addNewItem(ArrayList<Fields> fields) {
        dbHelper = new DBHelper(NewNoteActivity.getContext());
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues(); // Для удобной работы с бд
        contentValues.put(DBHelper.getKeyId(), MainActivity.getMainInfoList().size()+1); // Ручной ввод id
        contentValues.put(DBHelper.getKeyPosition(),MainActivity.getMainInfoList().size()+1); // Определение позиции
        contentValues.put(DBHelper.getKeyType(), NewNoteActivity.getCategory()); // Определение категории
        if(NewNoteActivity.getCategory().equals("0"))
        {
            contentValues.put(DBHelper.getKeyName(), typesNotes.getmAutoCompleteAddressSite().getText().toString()); // Определение названия сайта.
            contentValues.put(DBHelper.getKeyFavorite(), false); // Определение избранного

            contentValues.put(DBHelper.getKEY_1ArgValue(), fields.get(1).getInputText().getText().toString());
            contentValues.put(DBHelper.getKEY_2ArgValue(), fields.get(2).getInputText().getText().toString());
            contentValues.put(DBHelper.getKEY_3ArgValue(), fields.get(3).getInputText().getText().toString());


        /*contentValues.put(DBHelper.getKeyType(),2);
        contentValues.put(DBHelper.getKeyName(),"Master Card");
        contentValues.put(DBHelper.getKeyFavorite(),false);

        contentValues.put(DBHelper.getKEY_1ArgValue(),"3521654597545487");
        contentValues.put(DBHelper.getKEY_2ArgValue(),"02/24");
        contentValues.put(DBHelper.getKEY_3ArgValue(),"5412");
        contentValues.put(DBHelper.getKEY_4ArgValue(),"Evgef Erfdf");
        contentValues.put(DBHelper.getKEY_5ArgValue(),"54874");
        contentValues.put(DBHelper.getKEY_6ArgValue(),"Nice jock");*/


            Log.d("addNewItem", "ID = " + contentValues.get(DBHelper.getKeyId())
                    + "| Position = " + contentValues.get(DBHelper.getKeyPosition())
                    + "| Type = " + contentValues.get(DBHelper.getKeyType())
                    + "| Name = " + contentValues.get(DBHelper.getKeyName())
                    + "| Favorite = " + contentValues.get(DBHelper.getKeyFavorite())
                    + "| 1 ARG = " + contentValues.get(DBHelper.getKEY_1ArgValue())
                    + "| 2 ARG = " + contentValues.get(DBHelper.getKEY_2ArgValue())
                    + "| 3 ARG = " + contentValues.get(DBHelper.getKEY_3ArgValue()));
            database.insert(DBHelper.getTableName(),null,contentValues);
        }
        else {
            System.out.println("ERROR ADDBD");
        }
    }
}
