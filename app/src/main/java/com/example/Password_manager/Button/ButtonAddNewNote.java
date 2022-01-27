package com.example.Password_manager.Button;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.Password_manager.MainActivity;
import com.example.Password_manager.NewNoteActivity;
import com.example.Password_manager.Notes.NewNoteAdapter;

import com.example.Password_manager.Notes.NewNoteAdapter;
import com.example.Password_manager.adapter.MainActivityAdapter;
import com.example.Password_manager.adapter.MainInfoAdapter;

public class ButtonAddNewNote {

    static Context context;

    public static void selectCategoryAdd(int position) {
        NewNoteAdapter.NewNoteViewHolder.getLayoutSelectCategory().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //System.out.println(position);
                context = NewNoteActivity.getContext();
                Intent intent = new Intent(context, NewNoteActivity.class);
                System.out.println(position+" Position");
                intent.putExtra("Category", position);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

}

public static void enterAddInformation()
{
    NewNoteAdapter.NewNoteViewHolder.getLayoutSelectCategory().setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //System.out.println(position);
            context = MainActivity.getContext();
            Intent intent = new Intent(context, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    });
}
    }