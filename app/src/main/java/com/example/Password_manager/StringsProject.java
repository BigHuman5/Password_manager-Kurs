package com.example.Password_manager;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.Password_manager.DataBase.DBHelper;
import com.example.Password_manager.model.Category;
import com.example.Password_manager.model.MainInfo;
import com.example.Password_manager.model.MainInformation;

import java.util.ArrayList;
import java.util.List;

public class StringsProject {

    private static final int HowType = 10;
    private final int howTextsInMainActivity = 4;
    private String[] categoryFilterTitle;
    private String[] categoryForAddNewNote;
    private static String[][] informationTitle = new String[HowType][];
    private String[] textInMainActivity = new String[howTextsInMainActivity];

    private DBHelper dbHelper;
    private SQLiteDatabase database;
    private ContentValues contentValues;

    public StringsProject(int language) {
        definitionCategoryFilterTitle(language);
        definitionInformationTitle(language);
        definitionTextInMainActivity(language);
        definitionCategoryForAddNewNote(language);
    }

    public List<Category> getListCategoryFilterTitle()
    {
        List<Category> categoryList = new ArrayList<>();
        for(int i=0;i<categoryFilterTitle.length;i++)
            categoryList.add(new Category(i,categoryFilterTitle[i]));
        return categoryList;
    }


    public List<Category> getListCategoryAddNewNotes()
    {
        List<Category> categoryList = new ArrayList<>();
        for(int i=0;i<categoryForAddNewNote.length;i++)
            categoryList.add(new Category(i,categoryForAddNewNote[i]));
        return categoryList;
    }

    public List<MainInfo> getListMainInfo()
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
                    mainInfoList.add(new MainInfo(cursor.getInt(typeIndex),cursor.getInt(positionIndex),cursor.getString(nameIndex),cursor.getString(arg1ValueIndex),cursor.getExtras().getBoolean(cursor.getString(favoriteIndex))));
                }
                Log.d("mLog","ID = "+cursor.getInt(idIndex)
                        +" Type = "+cursor.getInt(typeIndex)
                        +" 1 Arg = "+cursor.getString(nameIndex));
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
            do {
                if(position == cursor.getInt(idIndex))
                {
                    Log.d("renderingMainInformation","ID: "+cursor.getInt(idIndex)
                            +"| Type: "+cursor.getInt(typeIndex)
                            +"| Number_Title: "+cursor.getInt(typeIndex)
                            +"| Position: "+position
                            +"| idIndex: "+cursor.getInt(idIndex)
                            +"| name_Title1: "+ informationTitle[cursor.getInt(typeIndex)][0]
                            +"| arg 1: "+cursor.getString(arg1ValueIndex)
                            +"| name_Title2: "+ informationTitle[cursor.getInt(typeIndex)][1]
                            +"| arg 2: "+cursor.getString(arg2ValueIndex)
                            +"| name_Title3: "+ informationTitle[cursor.getInt(typeIndex)][2]
                            +"| arg 3: "+cursor.getString(arg3ValueIndex)
                            +"| name_Title4: "+ informationTitle[cursor.getInt(typeIndex)][3]
                            +"| arg 4: "+cursor.getString(arg4ValueIndex)
                            +"| name_Title5: "+ informationTitle[cursor.getInt(typeIndex)][4]
                            +"| arg 5: "+cursor.getString(arg5ValueIndex)
                            +"| name_Title6: "+ informationTitle[cursor.getInt(typeIndex)][5]
                            +"| arg 6: "+cursor.getString(arg6ValueIndex)
                            +"| name_Title7: "+ informationTitle[cursor.getInt(typeIndex)][6]
                            +"| arg 7: "+cursor.getString(arg7ValueIndex)
                            +"| name_Title8: "+ informationTitle[cursor.getInt(typeIndex)][7]
                            +"| arg 8: "+cursor.getString(arg8ValueIndex)
                            +"| name_Title9: "+ informationTitle[cursor.getInt(typeIndex)][8]
                            +"| arg 9: "+cursor.getString(arg9ValueIndex)
                            +"| name_Title10: "+ informationTitle[cursor.getInt(typeIndex)][9]
                            +"| arg 10: "+cursor.getString(arg10ValueIndex));

                    mainInformationList.add(0,new MainInformation(cursor.getInt(typeIndex),
                            informationTitle[cursor.getInt(typeIndex)][0],
                            informationTitle[cursor.getInt(typeIndex)][1],
                            informationTitle[cursor.getInt(typeIndex)][2],
                            informationTitle[cursor.getInt(typeIndex)][3],
                            informationTitle[cursor.getInt(typeIndex)][4],
                            informationTitle[cursor.getInt(typeIndex)][5],
                            informationTitle[cursor.getInt(typeIndex)][6],
                            informationTitle[cursor.getInt(typeIndex)][7],
                            informationTitle[cursor.getInt(typeIndex)][8],
                            informationTitle[cursor.getInt(typeIndex)][9],
                            cursor.getString(arg1ValueIndex),
                            cursor.getString(arg2ValueIndex),
                            cursor.getString(arg3ValueIndex),
                            cursor.getString(arg4ValueIndex),
                            cursor.getString(arg5ValueIndex),
                            cursor.getString(arg6ValueIndex),
                            cursor.getString(arg7ValueIndex),
                            cursor.getString(arg8ValueIndex),
                            cursor.getString(arg9ValueIndex),
                            cursor.getString(arg10ValueIndex)));
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
                        "Всё",
                        "Избранное",
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

    public void definitionCategoryForAddNewNote(int language) {
        switch (language) {
            case 0: //Russian
            {
                categoryForAddNewNote = new String[]{
                        "Добавить веб-сайт",
                        "Добавить банковскую карту",
                        "Добавить прочую информацию",
                };
                break;
            }
            case 1: //English
            {
                categoryForAddNewNote = new String[]{
                        "Websites",
                        "Bank cards",
                        "Other",
                };
                break;
            }
            default: System.exit(3);
        }
    }

    private void definitionInformationTitle(int language) {
        informationTitle[0] = new String[3];
        informationTitle[1] = new String[6];
        informationTitle[2] = new String[6];
        switch (language) {
            case 0: //Russian
            { //Website
                informationTitle[0][0] = "Логин";
                informationTitle[0][1] = "Пароль";
                informationTitle[0][2] = "Комментарий";
                //Card
                informationTitle[1][0] = "Номер карты";
                informationTitle[1][1] = "Дата окончания";
                informationTitle[1][2] = "Код безопасности/CVV";
                informationTitle[1][3] = "Имя владельца карты";
                informationTitle[1][4] = "Пин код";
                informationTitle[1][5] = "Комментарий";
                break;
            }
            case 1: //English
            {
                //Website
                informationTitle[1][0] = "Login";
                informationTitle[1][1] = "Password";
                informationTitle[1][2] = "Comment";
                break;
            }
            default: System.exit(3);
        }
    }

    private void definitionTextInMainActivity(int language) {
        switch (language) {
            /*
            0 - Title
             */
            case 0: {
                textInMainActivity[0] = "Главная!!!";
                break;
            }
            case 1: {
                textInMainActivity[0] = "Main";
                break;
            }
            default: break;
        }
    }

    public void setCategoryFilterTitle(String[] categoryFilterTitle) {
        this.categoryFilterTitle = categoryFilterTitle;
    }

    public String[] getTextInMainActivity() {
        return textInMainActivity;
    }

    public void setTextInMainActivity(String[] textInMainActivity) {
        this.textInMainActivity = textInMainActivity;
    }

    public static int getInformationTitleLength(int element)
    {
        return informationTitle[element].length;
    }

    public static String[] getInformationTitle(int element) {
        return informationTitle[element];
    }

    public static int getHowType() {
        return HowType;
    }
}
