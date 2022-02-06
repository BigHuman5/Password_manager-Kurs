package com.example.Password_manager.Notes;

import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.Password_manager.MainActivity;
import com.example.Password_manager.R;

import java.util.Arrays;
import java.util.List;

public class typesNotes {

    public typesNotes(int numberCategory, int numberField) {
        System.out.printf(numberCategory+" | "+numberField);
        switch (numberCategory)
        {
            case 0:
            { // Website
                AutoCompleteTextView mAutoCompleteAddressSite;
                if(numberField == 0)
                {
                    final String[] mCats = { "Мурзик", "Рыжик", "Барсик", "Борис",
                            "Мурзилка", "Мурка", "bank" };
                    mAutoCompleteAddressSite = NewNoteAdapter.NewNoteViewHolder.getLayoutAddCategory().findViewById(R.id.autoCompleteTextView);
                    mAutoCompleteAddressSite.setVisibility(View.VISIBLE);
                    //app:layout_constraintStart_toStartOf
                    ArrayAdapter<String> adapter = new ArrayAdapter (NewNoteActivity.getContext(), R.layout.enterinfo_addnewnote, mCats);
                    mAutoCompleteAddressSite.setAdapter(adapter);

                    //mAutoCompleteAddressSite.add
                    //mAutoCompleteAddressSite
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
}
