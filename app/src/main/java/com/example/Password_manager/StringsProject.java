package com.example.Password_manager;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.util.Log;

import com.example.Password_manager.DataBase.DBHelper;
import com.example.Password_manager.model.Category;
import com.example.Password_manager.model.MainInfo;
import com.example.Password_manager.model.MainInformation;

import java.util.ArrayList;
import java.util.List;

public class StringsProject {

    private int HowType = 4;
    private String[] categoryFilterTitle;
    private String[][] InformationTitle= new String[HowType][];
    private DBHelper dbHelper;
    private SQLiteDatabase database;
    private ContentValues contentValues;

    public StringsProject(int language) {
        definitionCategoryFilterTitle(language);
        definitionInformationTitle(language);
    }

    public List<Category> getListCategoryFilterTitle()
    {
        List<Category> categoryList = new ArrayList<>();
        for(int i=0;i<categoryFilterTitle.length;i++)
            categoryList.add(new Category(i,categoryFilterTitle[i]));
        return categoryList;
    }

    public List<MainInfo> getListMainInfo()
    {
        List<MainInfo> mainInfoList = new ArrayList<>();
        dbHelper = MainActivity.getDbHelper();
        database = dbHelper.getWritableDatabase();
        contentValues = new ContentValues(); // Для удобной работы с бд

        Cursor cursor = database.query(DBHelper.TABLE_INFORMATION,null,null,null,null,null,null);
        if(cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
            int typeIndex = cursor.getColumnIndex(DBHelper.KEY_TYPE);
            int positionIndex = cursor.getColumnIndex(DBHelper.KEY_POSITION);
            int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
            int favoriteIndex = cursor.getColumnIndex(DBHelper.KEY_FAVORITE);

            int arg1ValueIndex = cursor.getColumnIndex(DBHelper.KEY_1ArgValue);


            do {
                if(cursor.getInt(idIndex) == 0) ;
                else
                {
                    mainInfoList.add(new MainInfo(cursor.getInt(typeIndex),cursor.getInt(positionIndex),cursor.getString(nameIndex),cursor.getString(arg1ValueIndex),cursor.getExtras().getBoolean(cursor.getString(favoriteIndex))));
                }
                Log.d("mLog","ID = "+cursor.getInt(idIndex)
                        +" Type = "+cursor.getInt(typeIndex)
                        +" 1 Arg = "+cursor.getString(arg1ValueIndex));
            } while (cursor.moveToNext());
        }else Log.d("mLog","0 rows");

        cursor.close();
        dbHelper.close();

        //mainInfoList.add(new MainInfo(1,"mail.ru","l",false));
        return mainInfoList;
    }

    public List<MainInformation> getListMainInformation(int position) // Функция по получению информации об определённой строчке
    {
        position++;
        List<MainInformation> mainInformationList = new ArrayList<>();

        dbHelper = MainActivity.getDbHelper();
        database = dbHelper.getWritableDatabase();
        contentValues = new ContentValues(); // Для удобной работы с бд



        Cursor cursor = database.query(DBHelper.TABLE_INFORMATION,null,null,null,null,null,null);
        if(cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
            int typeIndex = cursor.getColumnIndex(DBHelper.KEY_TYPE);

            int arg1ValueIndex = cursor.getColumnIndex(DBHelper.KEY_1ArgValue);
            int arg1SecureIndex = cursor.getColumnIndex(DBHelper.KEY_1ArgSecure);

            int arg2ValueIndex = cursor.getColumnIndex(DBHelper.KEY_2ArgValue);
            int arg2SecureIndex = cursor.getColumnIndex(DBHelper.KEY_2ArgSecure);

            int arg3ValueIndex = cursor.getColumnIndex(DBHelper.KEY_3ArgValue);
            int arg3SecureIndex = cursor.getColumnIndex(DBHelper.KEY_3ArgSecure);

            int arg4ValueIndex = cursor.getColumnIndex(DBHelper.KEY_4ArgValue);
            int arg4SecureIndex = cursor.getColumnIndex(DBHelper.KEY_4ArgSecure);
            do {
                if(position == cursor.getInt(idIndex))
                {
                    Log.d("renderingMainInformation","ID: "+cursor.getInt(idIndex)
                            +"| Type: "+cursor.getInt(typeIndex)
                            +"| Number_Title: "+cursor.getInt(typeIndex)
                            +"| Position: "+position
                            +"| idIndex: "+cursor.getInt(idIndex)
                            +"| name_Title1: "+InformationTitle[cursor.getInt(typeIndex)][0]
                            +"| arg 1: "+cursor.getString(arg1ValueIndex)
                            +"| secure1: "+cursor.getInt(arg1SecureIndex)
                            +"| name_Title2: "+InformationTitle[cursor.getInt(typeIndex)][1]
                            +"| arg2: "+cursor.getString(arg2ValueIndex)
                            +"| secure2: "+cursor.getInt(arg2SecureIndex)
                            +"| name_Title3: "+InformationTitle[cursor.getInt(typeIndex)][2]
                            +"| arg 3: "+cursor.getString(arg3ValueIndex)
                            +"| secure3: "+cursor.getInt(arg3SecureIndex)
                            +"| name_Title4: "+InformationTitle[cursor.getInt(typeIndex)][3]
                            +"| arg 4: "+cursor.getString(arg4ValueIndex)
                            +"| secure4: "+cursor.getInt(arg4SecureIndex));

                    mainInformationList.add(0,new MainInformation(cursor.getInt(typeIndex),

                            InformationTitle[cursor.getInt(typeIndex)][0],
                            cursor.getString(arg1ValueIndex),
                            cursor.getInt(arg1SecureIndex),

                            InformationTitle[cursor.getInt(typeIndex)][1],
                            cursor.getString(arg2ValueIndex),
                            cursor.getInt(arg2SecureIndex),

                            InformationTitle[cursor.getInt(typeIndex)][2],
                            cursor.getString(arg3ValueIndex),
                            cursor.getInt(arg3SecureIndex),

                            InformationTitle[cursor.getInt(typeIndex)][3],
                            cursor.getString(arg4ValueIndex),
                            cursor.getInt(arg4SecureIndex)));
                }
            } while (cursor.moveToNext());
        }else Log.d("mLog","0 rows");

        return mainInformationList;
    }

    public void definitionCategoryFilterTitle(int language) {
        switch (language) {
            case 0: //Russian
            {
                categoryFilterTitle = new String[]{
                        "Веб-сайты",
                        "Банковские карты",
                        "Прочее",
                };
                break;
            }
            case 1: //English
            {
                categoryFilterTitle = new String[]{
                        "Websites",
                        "Bank cards",
                        "Other",
                };
                break;
            }
            default: System.exit(3);
        }
    }

    public void definitionInformationTitle(int language) {
        switch (language) {
            case 0: //Russian
            { //Website
                InformationTitle[1] = new String[]{
                        "Логин",
                        "Пароль",
                        "Комментарий",
                        "null"};
                break;
            }
            case 1: //English
            {
                //Website
                InformationTitle[1] = new String[]{
                        "Login",
                        "Password",
                        "Comment",
                        "null"};
                break;
            }
            default: System.exit(3);
        }
    }

    public void setCategoryFilterTitle(String[] categoryFilterTitle) {
        this.categoryFilterTitle = categoryFilterTitle;
    }

}
