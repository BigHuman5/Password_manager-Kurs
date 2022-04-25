package com.example.Password_manager.Notes;

import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.Password_manager.MainActivity;
import com.example.Password_manager.Notes.adapter.NameItemAdapter;
import com.example.Password_manager.Notes.adapter.spinnerAdapter;
import com.example.Password_manager.R;
import com.example.Password_manager.StringsProject;
import com.example.Password_manager.adapter.MainInfoAdapter;
import com.example.Password_manager.category.imageType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class typesNotes {

    private static AutoCompleteTextView mAutoCompleteAddressSite;
    private static Spinner spinner;
    ImageView imageView;
    private static int countNewNotes = 0;

    public typesNotes(int numberCategory, int numberField) {
        System.out.printf(numberCategory+" | "+numberField);
        switch (numberCategory)
        {
            case 0: // Website
            {
                if(numberField == 0)
                {
                    mAutoCompleteAddressSite = NewNoteAdapter.NewNoteViewHolder.getLayoutAddCategory().findViewById(R.id.autoCompleteTextView);
                    mAutoCompleteAddressSite.setVisibility(View.VISIBLE);
                    mAutoCompleteAddressSite.setText("");
                    List<imageType> ListNamedAddItems = new ArrayList<>();
                    ListNamedAddItems = StringsProject.getListNamedAddItems(numberCategory);
                    NameItemAdapter nameItemAdapter;
                    nameItemAdapter = new NameItemAdapter(NewNoteActivity.getContext(),ListNamedAddItems);
                    mAutoCompleteAddressSite.setAdapter(nameItemAdapter);
                    countNewNotes++;
                }
                else
                {
                    NewNoteAdapter.NewNoteViewHolder.getInputText().setVisibility(View.VISIBLE);
                }
                break;
            }
            case 1: // Bank cards
            {
                if(numberField == 1)
                {
                    spinner = NewNoteAdapter.NewNoteViewHolder.getLayoutAddCategory().findViewById(R.id.spinner);
                    spinner.setVisibility(View.VISIBLE);
                    List<imageType> ListNamedAddItems = new ArrayList<>();
                    ListNamedAddItems = StringsProject.getListNamedAddItems(numberCategory);
                    spinnerAdapter spinnerAdapter;
                    spinnerAdapter = new spinnerAdapter(NewNoteActivity.getContext(),ListNamedAddItems);
                    spinner.setAdapter(spinnerAdapter);
                    countNewNotes++;
                }
                else
                {
                    NewNoteAdapter.NewNoteViewHolder.getInputText().setVisibility(View.VISIBLE);
                }
                break;
            }
            default:
            {
                System.out.printf("TypesNotes");
                System.exit(4); // Ошибка
            }
        }
    }



    public static AutoCompleteTextView getmAutoCompleteAddressSite() {
        return mAutoCompleteAddressSite;
    }

    public static int getCountNewNotes() {
        return countNewNotes;
    }

    public static void setCountNewNotes(int countNewNotes) {
        typesNotes.countNewNotes = countNewNotes;
    }

    public static Spinner getSpinner() {
        return spinner;
    }
}

