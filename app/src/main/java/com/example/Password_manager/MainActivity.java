package com.example.Password_manager;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.Password_manager.DataBase.DBHelper;
import com.example.Password_manager.adapter.CategoryAdapter;
import com.example.Password_manager.adapter.MainInfoAdapter;
import com.example.Password_manager.adapter.MainInformationAdapter;
import com.example.Password_manager.model.Category;
import com.example.Password_manager.model.MainInfo;
import com.example.Password_manager.model.MainInformation;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static DBHelper dbHelper;
    private RecyclerView categoryFilterRecycler, mainInfoRecycler;
    private CategoryAdapter categoryAdapter;
    private MainInfoAdapter mainInfoAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(this);
        SettingsProject settingsProject = new SettingsProject();
        int language = settingsProject.getLanguage();

        List<Category> categoryList=new ArrayList<>();
        List<MainInfo> mainInfoList = new ArrayList<>();

        StringsProject stringsProject = new StringsProject(language);
        categoryList = stringsProject.getListCategoryFilterTitle();
        mainInfoList = stringsProject.getListMainInfo();
        TestFunc(mainInfoList);

        setCategoryRecycler(categoryList);
        setMainInformationRecycler(mainInfoList);
    }

    private void setCategoryRecycler(List<Category> categoryList) {
       RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        categoryFilterRecycler = findViewById(R.id.CategoryFilterTitle);
        categoryFilterRecycler.setLayoutManager(layoutManager);

        categoryAdapter=new CategoryAdapter(this,categoryList);

        categoryFilterRecycler.setAdapter(categoryAdapter);
    }

    private void setMainInformationRecycler(List<MainInfo> mainInfoList)
    {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);

        mainInfoRecycler = findViewById(R.id.Main);
        mainInfoRecycler.setLayoutManager(layoutManager);


        mainInfoAdapter=new MainInfoAdapter(this,mainInfoList);

        mainInfoRecycler.setAdapter(mainInfoAdapter);
    }

    public void TestFunc(List<MainInfo> mainInfoList)
    {
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues(); // Для удобной работы с бд
        contentValues.put(DBHelper.KEY_ID,mainInfoList.size()+1);
        contentValues.put(DBHelper.KEY_POSITION,mainInfoList.size()+1);
        contentValues.put(DBHelper.KEY_TYPE,1);
        contentValues.put(DBHelper.KEY_NAME,"twitter.com");
        contentValues.put(DBHelper.KEY_FAVORITE,false);

        contentValues.put(DBHelper.KEY_1ArgValue,"Какая-то важная информация");
        contentValues.put(DBHelper.KEY_1ArgSecure,1);

        contentValues.put(DBHelper.KEY_2ArgValue,"Крутой пароль тут");
        contentValues.put(DBHelper.KEY_2ArgSecure,1);

        contentValues.put(DBHelper.KEY_3ArgValue,"Коммент");
        contentValues.put(DBHelper.KEY_3ArgSecure,0);

        //contentValues.put(DBHelper.KEY_4ArgValue,null);
        contentValues.put(DBHelper.KEY_4ArgSecure,1);

        Log.d("mfd","ID = "+contentValues.get(DBHelper.KEY_ID)
                +"| Type = "+contentValues.get(DBHelper.KEY_TYPE)
                +"| Name = "+contentValues.get(DBHelper.KEY_NAME));
        database.insert(DBHelper.TABLE_INFORMATION,null,contentValues);

    }

    public static DBHelper getDbHelper() {
        return dbHelper;
    }
}