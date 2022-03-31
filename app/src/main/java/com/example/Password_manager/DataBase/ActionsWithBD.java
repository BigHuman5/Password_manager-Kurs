package com.example.Password_manager.DataBase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.Password_manager.MainActivity;
import com.example.Password_manager.Notes.NewNoteActivity;
import com.example.Password_manager.Notes.NewNoteAdapter;
import com.example.Password_manager.Notes.model.Fields;
import com.example.Password_manager.Notes.typesNotes;
import com.example.Password_manager.SecurityActivity;
import com.example.Password_manager.SecurityInformation;
import com.example.Password_manager.StringsProject;
import com.example.Password_manager.model.MainInfo;
import com.example.Password_manager.model.MainInformation;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ActionsWithBD {


    private static DBHelper dbHelper;
    private static SQLiteDatabase database;
    private static ContentValues contentValues;

    public static void addNewItem(ArrayList<Fields> fields) {
        dbHelper = new DBHelper(NewNoteActivity.getContext());
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues(); // Для удобной работы с бд
        contentValues.put(DBHelper.getKeyId(), MainActivity.getMainInfoList().size() + 1); // Ручной ввод id
        contentValues.put(DBHelper.getKeyPosition(), MainActivity.getMainInfoList().size() + 1); // Определение позиции
        contentValues.put(DBHelper.getKeyType(), NewNoteActivity.getCategory()); // Определение категории
        if (NewNoteActivity.getCategory().equals("0")) {
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
            database.insert(DBHelper.getTableName(), null, contentValues);
        } else {
            System.out.println("ERROR ADDBD");
        }
    }

    public static boolean checkSecretKey() {
        boolean isSecretKeyNotNull = false;
        dbHelper = new DBHelper(SecurityActivity.getContext());
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        Cursor cursor = database.query(DBHelper.getTableName(), null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            int arg1ValueIndex = cursor.getColumnIndex(DBHelper.getKEY_1ArgValue());

            do {
                System.out.println(arg1ValueIndex + " checkSecretKey " + cursor.getString(arg1ValueIndex));
                if (cursor.getString(arg1ValueIndex) != null) {
                    isSecretKeyNotNull = true;
                }
            } while (cursor.moveToNext());
        } else {
            System.out.println("ERROR CHECK");
        }
        return isSecretKeyNotNull;
    }

    public static boolean addNewSecretKey(String secretKey) throws SQLException {
        secretKey = SecurityInformation.encryption(secretKey);
        try {
            dbHelper = new DBHelper(SecurityActivity.getContext());
            SQLiteDatabase database = dbHelper.getWritableDatabase();

            database.execSQL("UPDATE " + DBHelper.getTableName() + " SET " + DBHelper.getKEY_1ArgValue() + " = '" + secretKey + "' WHERE " + DBHelper.getKeyType() + " = 0");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static String getSecretKey() throws SQLException
    {
        try
        {
            dbHelper = new DBHelper(SecurityActivity.getContext());
            SQLiteDatabase database = dbHelper.getWritableDatabase();
            String[] columns = new String[]{DBHelper.getKeyType(), DBHelper.getKEY_1ArgValue()};
            Cursor cursor = database.query(DBHelper.getTableName(), columns, null, null, null, null, null);
            if (cursor.moveToFirst()) {
                int typeIndex = cursor.getColumnIndex(DBHelper.getKeyType());
                int arg1ValueIndex = cursor.getColumnIndex(DBHelper.getKEY_1ArgValue());
                if (cursor.getInt(typeIndex) == 0)
                {
                    return cursor.getString(arg1ValueIndex);
                }
                return null;
            } else Log.d("mLog", "0 rows");
            cursor.close();
            dbHelper.close();
        } catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }

    public static List<MainInfo> getListMainInfo()
    {
        List<MainInfo> mainInfoList = new ArrayList<>();
        dbHelper = MainActivity.getDbHelper();
        database = dbHelper.getWritableDatabase();
        contentValues = new ContentValues(); // Для удобной работы с бд

        Cursor cursor = database.query(DBHelper.getTableName(),null,null,null,null,null,null);
        if(cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(DBHelper.getKeyId());
            int typeIndex = cursor.getColumnIndex(DBHelper.getKeyType());
            int positionIndex = cursor.getColumnIndex(DBHelper.getKeyPosition());
            int nameIndex = cursor.getColumnIndex(DBHelper.getKeyName());
            int favoriteIndex = cursor.getColumnIndex(DBHelper.getKeyFavorite());

            int arg1ValueIndex = cursor.getColumnIndex(DBHelper.getKEY_1ArgValue());


            do {
                if(cursor.getInt(idIndex) == 0) ;
                else
                {
                    String encNameIndex = SecurityInformation.decryption(cursor.getString(nameIndex));
                    String encArg1 = SecurityInformation.decryption(cursor.getString(arg1ValueIndex));
                    mainInfoList.add(new MainInfo(cursor.getInt(typeIndex),cursor.getInt(positionIndex),encNameIndex,encArg1,cursor.getExtras().getBoolean(cursor.getString(favoriteIndex))));
                }
                Log.d("mLog","ID = "+cursor.getInt(idIndex)
                        +" Type = "+cursor.getInt(typeIndex)
                        +" 1 Arg = "+cursor.getString(nameIndex));
            } while (cursor.moveToNext());
        }else Log.d("mLog","0 rows");

        cursor.close();
        dbHelper.close();
        return mainInfoList;
    }

    public static List<MainInformation> getListMainInformation(int position) // Функция по получению информации об определённой строчке
    {
        position++;

        List<MainInformation> mainInformationList = new ArrayList<>();

        dbHelper = MainActivity.getDbHelper();
        database = dbHelper.getWritableDatabase();
        contentValues = new ContentValues(); // Для удобной работы с бд

        Cursor cursor = database.query(DBHelper.getTableName(),null,null,null,null,null,null);
        if(cursor.moveToFirst()) {

            int idIndex = cursor.getColumnIndex(DBHelper.getKeyId());
            int typeIndex = cursor.getColumnIndex(DBHelper.getKeyType());

            int arg1ValueIndex = cursor.getColumnIndex(DBHelper.getKEY_1ArgValue());
            int arg2ValueIndex = cursor.getColumnIndex(DBHelper.getKEY_2ArgValue());
            int arg3ValueIndex = cursor.getColumnIndex(DBHelper.getKEY_3ArgValue());
            int arg4ValueIndex = cursor.getColumnIndex(DBHelper.getKEY_4ArgValue());
            int arg5ValueIndex = cursor.getColumnIndex(DBHelper.getKEY_5ArgValue());
            int arg6ValueIndex = cursor.getColumnIndex(DBHelper.getKEY_6ArgValue());
            int arg7ValueIndex = cursor.getColumnIndex(DBHelper.getKEY_7ArgValue());
            int arg8ValueIndex = cursor.getColumnIndex(DBHelper.getKEY_8ArgValue());
            int arg9ValueIndex = cursor.getColumnIndex(DBHelper.getKEY_9ArgValue());
            int arg10ValueIndex = cursor.getColumnIndex(DBHelper.getKEY_10ArgValue());
            System.out.println(arg4ValueIndex);
            do {
                if(position == cursor.getInt(idIndex))
                {
                    String[] informationTitle=StringsProject.getInformationTitle(cursor.getInt(typeIndex));

                    String logString = "ID: "+cursor.getInt(idIndex)
                            +"| Type: "+cursor.getInt(typeIndex)
                            +"| Number_Title: "+cursor.getInt(typeIndex)
                            +"| Position: "+position
                            +"| idIndex: "+cursor.getInt(idIndex);

                    for(int i=0;i>=informationTitle.length;i++)
                    {
                        int p=0;
                        switch (i){
                            case 0: { p=arg1ValueIndex; break; }
                            case 1: { p=arg2ValueIndex; break; }
                            case 2: { p=arg3ValueIndex; break; }
                            case 3: { p=arg4ValueIndex; break; }
                            case 4: { p=arg5ValueIndex; break; }
                            case 5: { p=arg6ValueIndex; break; }
                            case 6: { p=arg7ValueIndex; break; }
                            case 7: { p=arg8ValueIndex; break; }
                            case 8: { p=arg9ValueIndex; break; }
                            case 9: { p=arg10ValueIndex; break; }
                            default: { p=arg1ValueIndex; break; }
                        }
                        logString += " | name_Title"+i+": "+informationTitle[i]
                                +"| arg"+i+": "+cursor.getString(p);
                    }

                    Log.d("getListMainInformation",logString);

                    for(int i=0;i>=StringsProject.getInformationTitleLength();i++) {
                        try{
                            System.out.println(informationTitle[i]);
                        }
                        catch (Exception e)
                        {
                            informationTitle[i] = "0";
                        }
                    }

                    mainInformationList.add(0,new MainInformation(cursor.getInt(typeIndex),
                            informationTitle[0],
                            informationTitle[1],
                            informationTitle[2],
                            informationTitle[3],
                            informationTitle[4],
                            informationTitle[5],
                            informationTitle[6],
                            informationTitle[7],
                            informationTitle[8],
                            informationTitle[9],
                            SecurityInformation.decryption(cursor.getString(arg1ValueIndex)),
                            SecurityInformation.decryption(cursor.getString(arg2ValueIndex)),
                            SecurityInformation.decryption(cursor.getString(arg3ValueIndex)),
                            SecurityInformation.decryption(cursor.getString(arg4ValueIndex)),
                            SecurityInformation.decryption(cursor.getString(arg5ValueIndex)),
                            SecurityInformation.decryption(cursor.getString(arg6ValueIndex)),
                            SecurityInformation.decryption(cursor.getString(arg7ValueIndex)),
                            SecurityInformation.decryption(cursor.getString(arg8ValueIndex)),
                            SecurityInformation.decryption(cursor.getString(arg9ValueIndex)),
                            SecurityInformation.decryption(cursor.getString(arg10ValueIndex))));
                }
            } while (cursor.moveToNext());
        }else Log.d("mLog","0 rows");

        return mainInformationList;
    }
}
