package com.example.Password_manager;

import android.app.Activity;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.Password_manager.Button.ButtonMainActivity;
import com.example.Password_manager.DataBase.ActionsWithBD;
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
    private static RecyclerView categoryFilterRecycler, mainInfoRecycler;
    private ConstraintLayout mainConstraintLayout;
    private static RecyclerView MainInfoRecycler;
    private static ConstraintLayout mainActivity;
    private CategoryAdapter categoryAdapter;
    private static MainInfoAdapter mainInfoAdapter;
    private MainActivityAdapter mainActivityAdapter;
    private static int actualCategory=0;

    private static List<MainInfo> mainInfoList;
    private static List<Category> categoryList;

    private static Context context;

    public MainActivity() {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(this);
        MainInfoRecycler = findViewById(R.id.Main);
        mainActivity = findViewById(R.id.newnoteActivity);

        MainActivity.context = getApplicationContext();

        mainInfoList = new ArrayList<>();

        StringsProject stringsProject = new StringsProject();
        categoryList = stringsProject.getListCategoryFilterTitle();
        mainInfoList = ActionsWithBD.getListMainInfo(actualCategory);

        setCategoryRecycler(categoryList);
        setMainInformationRecycler();
        MainActivityRecycler();
        ButtonMainActivity.addButton();
        ButtonMainActivity.menuButton();
        System.out.println("Я тут все данные обновил и всё новоё!");
    }

    public void MainActivityRecycler() {
        mainConstraintLayout = MainActivity.MainInfoRecycler.findViewById(R.id.newnoteActivity);
        mainActivityAdapter = new MainActivityAdapter();
    }

    /*
    @Override
    public void onResume() {
        super.onResume();
        System.out.println("Resume получило приложение!!");
    }*/

    private void setCategoryRecycler(List<Category> categoryList) {
       RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        categoryFilterRecycler = findViewById(R.id.TypeCategory);
        categoryFilterRecycler.setLayoutManager(layoutManager);

        categoryAdapter=new CategoryAdapter(this,categoryList);

        categoryFilterRecycler.setAdapter(categoryAdapter);
    }

    public void setMainInformationRecycler()
    {
        mainInfoList = ActionsWithBD.getListMainInfo(actualCategory);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        mainInfoRecycler = MainActivity.MainInfoRecycler.findViewById(R.id.Main);
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

    public static int getActualCategory() {
        return actualCategory;
    }

    public static void setActualCategory(int actualCategory) {
        MainActivity.actualCategory = actualCategory;
    }
}