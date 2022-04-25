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
import com.example.Password_manager.model.Security;

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
    private static String[] errorText = new String[10];
    private static String[] securityText = new String[10];

    private DBHelper dbHelper;
    private SQLiteDatabase database;
    private ContentValues contentValues;

    public StringsProject(int language) {
        definitionCategoryFilterTitle(language);
        definitionInformationTitle(language);
        definitionTextInMainActivity(language);
        definitionCategoryForAddNewNote(language);
        definitionErrorText(language);
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
                        //"Добавить прочую информацию",
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
        informationTitle[0] = new String[HowType];
        informationTitle[1] = new String[HowType];
        informationTitle[2] = new String[HowType];
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
                textInMainActivity[0] = "Главная";
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

    static void definitionTextForSecurity(int language)
    {
        switch (language)
        {
            case 0: { //Russian
                securityText[0] = "На данном устройстве не было обнаружено какой-либо информации.\n\nПожалуйста введите пароль и подтвердите его.";
                securityText[1] = "Пожалуйста подтвердите ваш пароль";
                securityText[2] = "Пожалуйста введите ваш пароль";

                securityText[3] = "Создать профиль";
                securityText[4] = "Войти в профиль";
                break;
            }
            default: {
                System.out.println("StringsProject definitionTextForSecurity");
                System.exit(3);
                break;
            }
        }
    }

    static void definitionErrorText(int language)
    {
        switch (language) {
            case 0: { //Russian
                errorText[0] = "Ошибка";
                errorText[1] = "Это обязательное поле";
                errorText[2] = "Введён неправильный пароль";
                errorText[3] = "Пароли не совпадают";
                errorText[4] = "Введите пароль ещё раз";
                errorText[5] = "Пароль должен быть минимум "+ Security.getMinKey()+" символов";
                break;
            }
            case 1: {
                errorText[0] = "Error";
                errorText[1] = "Error1";
                break;
            }
            default: {
                System.out.println("StringsProject definitionErrorText");
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

    public static String[] getErrorText() {
        return errorText;
    }

    public static String getItemErrorText(int item){
        return errorText[item];
    }

    public static String[] getSecurityText() {
        return securityText;
    }

    public static String getItemSecurityText(int item)
    {
        return securityText[item];
    }
}
