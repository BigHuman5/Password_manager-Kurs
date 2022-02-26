package com.example.Password_manager.Notes;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.example.Password_manager.Button.ButtonAddNewNote;
import com.example.Password_manager.R;
import com.example.Password_manager.SettingsProject;
import com.example.Password_manager.StringsProject;
import com.example.Password_manager.model.Category;

import java.util.ArrayList;
import java.util.List;

public class NewNoteActivity extends Activity {

    private RecyclerView NewNoteRecycler,header;
    private static Context context;
    private NewNoteAdapter newNoteAdapter;
    private static String Category;

    private static FloatingActionButton addNewItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newnote); // назначение нового layout

        Bundle arguments = getIntent().getExtras(); // Приём переменной с номером категории
        Category = new String();
        try {
            Category = arguments.get("Category").toString(); //Перевод переменной в удобный читабильный вид для удобной работы.
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        System.out.println("Category: "+Category);
        SettingsProject settingsProject = new SettingsProject();
        int language = settingsProject.getLanguage(); // Для определения языка программы

        NewNoteActivity.context = getApplicationContext(); // Получение данных страницы для работы дальнейшей

        List<Category> categoryList=new ArrayList<>();
        String[][] informationTitle;

        StringsProject stringsProject = new StringsProject(language); // инициализация для поиска названия полей.
        categoryList = stringsProject.getListCategoryAddNewNotes(); // Список с названиями полей

        addNewItem = findViewById(R.id.buttonAddNewItem); // Поиск кнопки подтверждения добавления.

        newNoteRecycler(categoryList,Category);
    }

    private void newNoteRecycler(List<Category> categoryList,String Category) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        NewNoteRecycler = findViewById(R.id.RecyclerWithNameCategoryList);
        NewNoteRecycler.setLayoutManager(layoutManager);

        newNoteAdapter=new NewNoteAdapter(this,categoryList,Category);

        NewNoteRecycler.setAdapter(newNoteAdapter);

        ButtonAddNewNote.enterAddNewItem(newNoteAdapter.getItems()); // !!!!Для работы кнопки подтверждения ввода(Небольшая фича)
    }


    public static FloatingActionButton getAddNewItem() {
        return addNewItem;
    } // Для передачи кнопки подтверждения.

    public static Context getContext() {
        return context;
    } // Для передачи контекста.

    public static String getCategory() {
        return Category;
    } // Для передачи номера категории.
}
