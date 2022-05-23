package com.example.Password_manager.adapter;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.widget.TextView;

import com.example.Password_manager.MainActivity;
import com.example.Password_manager.R;
import com.example.Password_manager.SettingsProject;
import com.example.Password_manager.StringsProject;

public class MainActivityAdapter extends MainActivity {

    ConstraintLayout context;

    private static FloatingActionButton addNewItem;
    private TextView titleInMain;
    private static FloatingActionButton menuButton;
    private static NavigationView Menu;
    private static ConstraintLayout MainLayout;

    public MainActivityAdapter() {
        definitionItems();
        onBindView();
    }



    public void onBindView()
    {
        //StringsProject stringsProject = new StringsProject(SettingsProject.getLanguage());
        //String[] textInMainActivity = stringsProject.getTextInMainActivity();
        //titleInMain.setText(textInMainActivity[0]);
        //
        //System.out.println(textInMainActivity[0]);
    }

    public void definitionItems()
    {
        ConstraintLayout mainInfoRecycler = MainActivity.getMainActivity();
        MainLayout = mainInfoRecycler.findViewById(R.id.newnoteActivity);
        //
        addNewItem = mainInfoRecycler.findViewById(R.id.AddNewItem); // Button for add new item
        titleInMain = mainInfoRecycler.findViewById(R.id.TitleInAddNewItem); // Title text in Main Activity
        menuButton = mainInfoRecycler.findViewById(R.id.menuFloating); // Button for menu
        //
        Menu = mainInfoRecycler.findViewById(R.id.Menu);
    }

    public static FloatingActionButton getAddNewItem() {
        return addNewItem;
    }

    public TextView getTitleInMain() {
        return titleInMain;
    }

    public static FloatingActionButton getMenuButton() {
        return menuButton;
    }

    public static NavigationView getMenu() {
        return Menu;
    }

    public static ConstraintLayout getMainLayout() {
        return MainLayout;
    }

}
