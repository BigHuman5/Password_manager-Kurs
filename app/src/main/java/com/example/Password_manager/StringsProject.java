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
    private static String[] categoryFilterTitle;
    private String[] categoryForAddNewNote;
    private static String[][] informationTitle = new String[HowType][];
    private static String[][] addNewItem = new String[HowType][];


    public StringsProject() {
        definitionInformationTitle();
        definitionCategoryForAddNewNote();
    }

    public List<Category> getListCategoryFilterTitle()
    {
        List<Category> categoryList = new ArrayList<>();
        definitionCategoryFilterTitle();
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



    public static void definitionCategoryFilterTitle() {
                categoryFilterTitle = new String[]{
                        "all_categories",
                        "favorite_categories",
                        //"website_categories",
                        //"cards_categories",
                };
    }

    public void definitionCategoryForAddNewNote() {
                categoryForAddNewNote = new String[]{
                        "web_add_new_item",
                        "cards_add_new_item",
                };
    }

    private static void definitionInformationTitle() {
        informationTitle[0] = new String[HowType];
        informationTitle[1] = new String[HowType];

        informationTitle[0][0] = "login";
        informationTitle[0][1] = "password";
        informationTitle[0][2] = "commentary";
        //Card
        informationTitle[1][0] = "number";
        informationTitle[1][1] = "date";
        informationTitle[1][2] = "cvv";
        informationTitle[1][3] = "ownerName";
        informationTitle[1][4] = "pin";
        informationTitle[1][5] = "commentary";
    }

    public static void definitionTextForAddItem(int numberCategory)
    {
        addNewItem[0] = new String[informationTitle[0].length+1];
        addNewItem[1] = new String[informationTitle[1].length+2];
        int[] numberStartFor = new int[getHowType()];
        int numberForFor = 0;
        definitionInformationTitle();
                switch (numberCategory)
                {
                    case 0: //Website
                    {
                        addNewItem[numberCategory][0] = "address";
                        numberStartFor[numberCategory] = 1;
                        break;
                    }
                    case 1: //Card
                    {
                        addNewItem[numberCategory][0] = "name";
                        addNewItem[numberCategory][1] = "typeCard";
                        numberStartFor[numberCategory] = 1;
                        break;
                    }
                    default: {
                        System.out.println("StringsProject definitionTextInMainActivity"+" | "+numberCategory);
                        System.exit(3);
                        break;
                    }
                }

            for (int i = numberStartFor[numberCategory]; i <= addNewItem[numberCategory].length; i++)
            {
                try {
                    addNewItem[numberCategory][i] = informationTitle[numberCategory][numberForFor];
                }
                catch (Exception ignored) {                }
                numberForFor++;
            }
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

    public static String[] getAddNewItem(int type) {
        definitionTextForAddItem(type);
        return addNewItem[type];
    }
}
