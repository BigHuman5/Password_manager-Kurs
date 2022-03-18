package com.example.Password_manager;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.constraint.ConstraintLayout;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.Password_manager.Button.ButtonMainActivity;
import com.example.Password_manager.DataBase.DBHelper;
import com.example.Password_manager.adapter.CategoryAdapter;
import com.example.Password_manager.adapter.MainActivityAdapter;
import com.example.Password_manager.adapter.MainInfoAdapter;
import com.example.Password_manager.model.Category;
import com.example.Password_manager.model.MainInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private static DBHelper dbHelper;
    private RecyclerView categoryFilterRecycler, mainInfoRecycler;
    private ConstraintLayout mainConstraintLayout;
    private static RecyclerView getMainInfoRecycler;
    private static ConstraintLayout mainActivity;
    private CategoryAdapter categoryAdapter;
    private MainInfoAdapter mainInfoAdapter;
    private MainActivityAdapter mainActivityAdapter;

    private static List<MainInfo> mainInfoList;

    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(this);
        getMainInfoRecycler = findViewById(R.id.Main);
        mainActivity = findViewById(R.id.newnoteActivity);
        SettingsProject settingsProject = new SettingsProject();
        int language = settingsProject.getLanguage();

        MainActivity.context = getApplicationContext();

        List<Category> categoryList=new ArrayList<>();
        mainInfoList = new ArrayList<>();

        StringsProject stringsProject = new StringsProject(language);
        categoryList = stringsProject.getListCategoryFilterTitle();
        mainInfoList = stringsProject.getListMainInfo();
        //TestFunc(mainInfoList);

        setCategoryRecycler(categoryList);
        setMainInformationRecycler(mainInfoList);
        MainActivityRecycler();
        ButtonMainActivity.addButton();
        System.out.println("Я тут все данные обновил и всё новоё!");
    }

    private void MainActivityRecycler() {
        mainConstraintLayout = findViewById(R.id.newnoteActivity);
        mainActivityAdapter = new MainActivityAdapter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("Resume получило приложение!!");
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

    public static ConstraintLayout getMainActivity() {
        return mainActivity;
    }

    public static DBHelper getDbHelper() {
        return dbHelper;
    }

    public static List<MainInfo> getMainInfoList() {
        return mainInfoList;
    }

    public static Context getContext()
    {
        return MainActivity.context;
    }
}