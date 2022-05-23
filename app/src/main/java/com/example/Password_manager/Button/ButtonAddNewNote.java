package com.example.Password_manager.Button;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.Password_manager.DataBase.ActionsWithBD;
import com.example.Password_manager.MainActivity;
import com.example.Password_manager.Notes.NewNoteActivity;
import com.example.Password_manager.Notes.NewNoteAdapter;
import com.example.Password_manager.Notes.Regex;
import com.example.Password_manager.Notes.adapter.NameItemAdapter;
import com.example.Password_manager.Notes.model.Fields;
import com.example.Password_manager.Notes.typesNotes;
import com.example.Password_manager.R;
import com.example.Password_manager.StringsProject;
import com.example.Password_manager.adapter.MainInfoAdapter;

import java.util.ArrayList;

public class ButtonAddNewNote
{

    static Context context;

    public static void selectCategoryAdd(int position) {
        NewNoteAdapter.NewNoteViewHolder.getLayoutSelectCategory().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                typesNotes.setCountNewNotes(0); // Зануление уникальных полей
                context = NewNoteActivity.getContext();
                Intent intent = new Intent(context, NewNoteActivity.class);
                System.out.println("Position: "+position);
                intent.putExtra("Category", position);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

}

    public static void enterAddNewItem(ArrayList<Fields> items)
    {
        NewNoteActivity.getAddNewItem().setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               boolean isFieldNull = false;
               if(NewNoteActivity.getCategory().equals("0")) {
                   if (Regex.nullField(typesNotes.getmAutoCompleteAddressSite().getText().toString())) //Проверка названия сайта на пустоту
                   {
                       items.get(0).getErrorText().setVisibility(View.VISIBLE);
                       isFieldNull = true;
                   } else items.get(0).getErrorText().setVisibility(View.GONE);
                   //
                   if (Regex.nullField(items.get(1).getInputText().getText().toString())) // Проверка логина на сайте на пустоту.
                   {
                       items.get(1).getErrorText().setVisibility(View.VISIBLE);
                       isFieldNull = true;
                   } else items.get(0).getErrorText().setVisibility(View.GONE);
               }
               else if(NewNoteActivity.getCategory().equals("1")){
                   if (Regex.nullField(items.get(0).getInputText().getText().toString())) //Проверка названия карты на пустоту
                   {
                       items.get(0).getErrorText().setVisibility(View.VISIBLE);
                       isFieldNull = true;
                   } else items.get(0).getErrorText().setVisibility(View.GONE);
                   //
                   if (Regex.nullField(items.get(2).getInputText().getText().toString()))
                   {
                       items.get(2).getErrorText().setVisibility(View.VISIBLE);
                       isFieldNull = true;
                   } else items.get(0).getErrorText().setVisibility(View.GONE);
               }

               if(!isFieldNull)
               {
                   //ArrayList<String> information = new ArrayList<String>();
                   //System.out.println(items.size());
                   ActionsWithBD.addNewItem(items);

                   context = NewNoteActivity.getContext();
                   Intent intent = new Intent(context, MainActivity.class);
                   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                   context.startActivity(intent);

               }

           }
       });
    }
}