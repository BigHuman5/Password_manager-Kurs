package com.example.Password_manager.Notes;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.Password_manager.R;
import com.example.Password_manager.SettingsProject;
import com.example.Password_manager.StringsProject;
import com.example.Password_manager.model.Category;

import java.util.ArrayList;
import java.util.List;

public class NewNoteActivity extends Activity {

    private RecyclerView NewNoteRecycler;
    private static Context context;
    private NewNoteAdapter newNoteAdapter;
    private static String Category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newnote);

        Bundle arguments = getIntent().getExtras();
        Category = new String();
        try {
            Category = arguments.get("Category").toString();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        System.out.println("Text: "+Category);
        SettingsProject settingsProject = new SettingsProject();
        int language = settingsProject.getLanguage();

        NewNoteActivity.context = getApplicationContext();

        List<Category> categoryList=new ArrayList<>();
        String[][] informationTitle;

        StringsProject stringsProject = new StringsProject(language);
        categoryList = stringsProject.getListCategoryAddNewNotes();


        newNoteRecycler(categoryList,Category);
    }

    private void newNoteRecycler(List<Category> categoryList,String Category) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);

        //informationTitle = StringsProject.getInformationTitle(position);
        NewNoteRecycler = findViewById(R.id.RecyclerWithNameCategoryList);
        NewNoteRecycler.setLayoutManager(layoutManager);

        newNoteAdapter=new NewNoteAdapter(this,categoryList,Category);

        NewNoteRecycler.setAdapter(newNoteAdapter);
    }

    public static Context getContext() {
        return context;
    }

    public static String getCategory() {
        return Category;
    }
}
