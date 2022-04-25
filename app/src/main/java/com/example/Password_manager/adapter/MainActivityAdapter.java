package com.example.Password_manager.adapter;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.widget.TextView;

import com.example.Password_manager.MainActivity;
import com.example.Password_manager.R;
import com.example.Password_manager.SettingsProject;
import com.example.Password_manager.StringsProject;

public class MainActivityAdapter extends MainActivity {

    ConstraintLayout context;

    private static FloatingActionButton addNewItem;
    private TextView titleInMain;

    public MainActivityAdapter() {
        definitionItems();
        onBindView();
    }



    public void onBindView()
    {
        StringsProject stringsProject = new StringsProject(SettingsProject.getLanguage());
        String[] textInMainActivity = stringsProject.getTextInMainActivity();
        titleInMain.setText(textInMainActivity[0]);
        //
        System.out.println(textInMainActivity[0]);
    }

    public void definitionItems()
    {
        ConstraintLayout mainInfoRecycler = MainActivity.getMainActivity();
        addNewItem = mainInfoRecycler.findViewById(R.id.AddNewItem); // Button for add new item
        titleInMain = mainInfoRecycler.findViewById(R.id.TitleInAddNewItem); // Title text in Main Activity
    }

    public static FloatingActionButton getAddNewItem() {
        return addNewItem;
    }

    public static void setAddNewItem(FloatingActionButton addNewItem) {
        MainActivityAdapter.addNewItem = addNewItem;
    }

    public TextView getTitleInMain() {
        return titleInMain;
    }

    public void setTitleInMain(TextView titleInMain) {
        this.titleInMain = titleInMain;
    }
}
