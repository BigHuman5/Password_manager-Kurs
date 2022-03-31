package com.example.Password_manager;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.Password_manager.DataBase.DBHelper;
import com.example.Password_manager.category.imageType;
import com.example.Password_manager.model.Category;
import com.example.Password_manager.model.MainInfo;
import com.example.Password_manager.model.MainInformation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringsProject {

    private static final int HowType = 10;
    private final int howTextsInMainActivity = 4;
    private String[] categoryFilterTitle;
    private String[] categoryForAddNewNote;
    private static String[][] informationTitle = new String[HowType][];
    private static String[][] addNewItem = new String[HowType][];
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
        return mainInfoList;
    }

    public List<MainInformation> getListMainInformation(int position) // Функция по получению информации об определённой строчке
    {
        position++;
        List<MainInformation> mainInformationList = new ArrayList<>();

        dbHelper = MainActivity.getDbHelper();
        database = dbHelper.getWritableDatabase();
        contentValues = new ContentValues(); // Для удобной работы с бд

        String title = new String();



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
                        logString += " | name_Title"+i+": "+informationTitle[cursor.getInt(typeIndex)][i]
                                +"| arg"+i+": "+cursor.getString(p);
                    }

                    Log.d("getListMainInformation",logString);

                    for(int i=0;i>=informationTitle.length;i++) {
                        try{
                            System.out.println(informationTitle[cursor.getInt(typeIndex)][i]);
                        }
                        catch (Exception e)
                        {
                            informationTitle[cursor.getInt(typeIndex)][i] = "0";
                        }
                    }

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

    public static List<imageType> getListNamedAddItems(int numberCategory)
    {
        List<imageType> ListNamedAddItems = new ArrayList<>();
        if(numberCategory == 0) {
            ListNamedAddItems.add(new imageType(R.drawable.vk, "vk.com"));
            ListNamedAddItems.add(new imageType(R.drawable.facebook, "facebook.com"));
        }
        else if(numberCategory == 1)
        {
            ListNamedAddItems.add(new imageType(R.drawable.mastercard,"MasterCard"));
            ListNamedAddItems.add(new imageType(R.drawable.mastercard,"Visa"));
        }
        else
        {
            System.out.println("StringsProject getListNamedAddItems");
            System.exit(3);
        }
        return ListNamedAddItems;
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
            default:
            {
                System.out.println("StringsProject definitionCategoryFilterTitle");
                System.exit(3);
            }
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

    private static void definitionInformationTitle(int language) {
        List<String> informationTitleList = new ArrayList<>();
        informationTitle[0] = new String[10];
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
            default: {
                System.out.println("StringsProject definitionInformationTitle");
                System.exit(3);
            }
        }
    }

    public static void definitionTextForAddItem(int language,int numberCategory)
    {
        addNewItem[0] = new String[informationTitle[0].length+1];
        addNewItem[1] = new String[informationTitle[1].length+2];
        addNewItem[2] = new String[informationTitle[2].length+2];
        int[] numberStartFor = new int[getHowType()];
        int numberForFor = 0;
        definitionInformationTitle(language);
        switch (language) {
            case 0: //Russian
            {
                switch (numberCategory)
                {
                    case 0: //Website
                    {
                        addNewItem[numberCategory][0] = "Адрес";
                        numberStartFor[numberCategory] = 1;
                        break;
                    }
                    case 1: //Card
                    {
                        addNewItem[numberCategory][0] = "Название";
                        addNewItem[numberCategory][1] = "Тип карты";
                        numberStartFor[numberCategory] = 2;
                        break;
                    }
                    default: {
                        System.out.println("StringsProject definitionTextInMainActivity"+language+" | "+numberCategory);
                        System.exit(3);
                        break;
                    }
                }
                break;
            }
            case 1: //English
            {
                switch (numberCategory)
                {
                    case 0: //Website
                    {
                        addNewItem[numberCategory][0] = "Address";
                        numberStartFor[numberCategory] = 1;
                        break;
                    }
                    case 1: //Card
                    {
                        addNewItem[numberCategory][0] = "Name";
                        addNewItem[numberCategory][1] = "Type";
                        numberStartFor[numberCategory] = 2;
                        break;
                    }
                    default: {
                        System.out.println("StringsProject definitionTextInMainActivity"+language+" | "+numberCategory);
                        System.exit(3);
                        break;
                    }
                }
            }
            default: {
                System.out.println("StringsProject definitionTextInMainActivity"+language);
                System.exit(3);
                break;
            }
        }
            for (int i = numberStartFor[numberCategory]; i <= addNewItem[numberCategory].length; i++) {
                try {

                    addNewItem[numberCategory][i] = informationTitle[numberCategory][numberForFor];
                } catch (Exception ignored) {
                }
                numberForFor++;
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
            default: {
                System.out.println("StringsProject definitionTextInMainActivity");
                System.exit(3);
                break;
            }
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

    public static int getInformationTitleLength() {
        return informationTitle.length;
    }

    public static int getCountInformationTitle(int type) // Для определения количества строк в добавлениее информации
    {
        int countInformationTitle = 0;
        for(int numberForFor=0;numberForFor<=getHowType();numberForFor++)
        {
            try {
                if(!informationTitle[type][numberForFor].equals("null"))
                {
                    countInformationTitle++;
                }
            }
            catch (Exception ignore) { }

        }
        return countInformationTitle;
    }

    public static int getHowType() { // Тип категории
        return HowType;
    }

    public static String[] getAddNewItem(int language, int type) {
        definitionTextForAddItem(language,type);
        System.out.println("GEASDS: "+type+" | "+ Arrays.toString(addNewItem[type]));
        return addNewItem[type];
    }
}
