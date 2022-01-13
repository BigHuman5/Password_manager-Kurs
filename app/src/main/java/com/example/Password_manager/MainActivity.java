package com.example.Password_manager;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.Password_manager.DataBase.DBHelper;
import com.example.Password_manager.adapter.CategoryAdapter;
import com.example.Password_manager.adapter.MainInfoAdapter;
import com.example.Password_manager.model.Category;
import com.example.Password_manager.model.MainInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryFilterRecycler, mainInfoRecycler;
    CategoryAdapter categoryAdapter;
    MainInfoAdapter mainInfoAdapter;

    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //dbHelper = new DBHelper(this);

        List<Category> categoryList=new ArrayList<>();
        List<MainInfo> mainInfoList = new ArrayList<>();


        StringsProject stringsProject = new StringsProject();
        categoryList = stringsProject.getListCategoryFilterTitle();
        mainInfoList = stringsProject.getListMainInfo();

        setCategoryRecycler(categoryList);
        setMainInformationRecycler(mainInfoList);
       // TestFunc();
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

    private void TestFunc()
    {
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues(); // Для удобной работы с бд

        contentValues.put(DBHelper.KEY_TYPE,1);
        contentValues.put(DBHelper.KEY_1Arg,"vk.com");
        contentValues.put(DBHelper.KEY_2Arg,"Nice Login");
        contentValues.put(DBHelper.KEY_3Arg,"Nice Password");

        database.insert(DBHelper.TABLE_INFORMATION,null,contentValues);

        Cursor cursor = database.query(DBHelper.TABLE_INFORMATION,null,null,null,null,null,null);
        if(cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
            int typeIndex = cursor.getColumnIndex(DBHelper.KEY_TYPE);
            int Arg1Index = cursor.getColumnIndex(DBHelper.KEY_1Arg);
            int Arg2Index = cursor.getColumnIndex(DBHelper.KEY_2Arg);
            int Arg3Index = cursor.getColumnIndex(DBHelper.KEY_3Arg);

            do {
                Log.d("mLog","ID = "+cursor.getInt(idIndex)
                +" Type = "+cursor.getInt(typeIndex)
                +" 1 Arg = "+cursor.getString(Arg1Index)
                +" 2 Arg = "+cursor.getString(Arg2Index)
                +" 3 Arg = "+cursor.getString(Arg3Index));
            } while (cursor.moveToNext());
        }else Log.d("mLog","0 rows");

        cursor.close();
        dbHelper.close();
    }

}