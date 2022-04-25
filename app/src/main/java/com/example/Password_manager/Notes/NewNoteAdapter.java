package com.example.Password_manager.Notes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Password_manager.Button.ButtonAddNewNote;
import com.example.Password_manager.Notes.model.Fields;
import com.example.Password_manager.R;
import com.example.Password_manager.SettingsProject;
import com.example.Password_manager.StringsProject;
import com.example.Password_manager.model.Category;

import java.util.ArrayList;
import java.util.List;

public class NewNoteAdapter extends RecyclerView.Adapter<NewNoteAdapter.NewNoteViewHolder> {

    Context context;
    List<Category> categoryList;
    String[] informationTitle = new String[StringsProject.getHowType()];

    String typeCategory;

    int numberCategory;

    private int countInformationTitle = 0;

    public NewNoteAdapter(Context context, List<Category> categoryList, String typeCategory) {
        this.context = context;
        this.categoryList = categoryList;
        this.typeCategory = typeCategory;
        numberCategory = getNumberCategory();
        informationTitle = StringsProject.getInformationTitle(numberCategory);
        countInformationTitle = StringsProject.getCountInformationTitle(numberCategory);
        System.out.println(numberCategory+" | "+StringsProject.getInformationTitleLength(numberCategory) + " Число");
    }

    public TextView[][] f = new TextView[StringsProject.getInformationTitleLength(numberCategory)+200][2];

    private ArrayList<Fields> fields = new ArrayList<Fields>();


    @NonNull
    @Override
    public NewNoteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View NewNoteItems;
        if(typeCategory.equals("")) { //Если прилетел пустой ответ, тоесть тип не выбрал. Отображается выбор типа
            NewNoteItems = LayoutInflater.from(context).inflate(R.layout.selectcategory_addnewnote, viewGroup, false);
        }
        else{ //Если прилетел ответ, тоесть тип выбран. Отображается меню с заполнением информации
            //typesNotes.setCountNewNotes(0); // Зануление уникальных полей
            NewNoteItems = LayoutInflater.from(context).inflate(R.layout.enterinfo_addnewnote,viewGroup,false);
        }
        return new NewNoteAdapter.NewNoteViewHolder(NewNoteItems);
    }

    @Override
    public void onBindViewHolder(@NonNull NewNoteViewHolder newNoteViewHolder, int i) {
        if(typeCategory.equals("")) { //Если прилетел пустой ответ, тоесть тип не выбрал. Отображается выбор типа
            newNoteViewHolder.nameCategory.setText(categoryList.get(i).getNameCategory());
            NewNoteActivity.getAddNewItem().hide();
            switch (i) { /* Подстановка изображения в типы категорий. */
                case 0: { // Изображение веб сайта
                    newNoteViewHolder.imageView.setImageResource(R.drawable.ic_baseline_website_24);
                    break;
                }
                case 1: // Изображение добавление карты
                {
                    newNoteViewHolder.imageView.setImageResource(R.drawable.ic_baseline_add_card_24);
                    break;
                }
                default: // Выкидывает картинку сайт при ошибке.
                {
                    newNoteViewHolder.imageView.setImageResource(R.drawable.ic_baseline_website_24);
                    break;
                }
            }
            int position = newNoteViewHolder.getAdapterPosition();
            ButtonAddNewNote.selectCategoryAdd(position);
        }
        else // Вывод окна с вводом данных
        {
            NewNoteViewHolder.errorText.setVisibility(View.INVISIBLE);
            NewNoteViewHolder.inputText.setText("");
            informationTitle = StringsProject.getAddNewItem(getLanguage(),numberCategory);
            newNoteViewHolder.titleText.setText(informationTitle[i]);
            new typesNotes(numberCategory,i);
            fields.add(new Fields(NewNoteViewHolder.getInputText(),NewNoteViewHolder.getErrorText()));
            System.out.println("\n"+i+" | "+fields.get(i).getInputText().getText().toString()+" | "+fields.get(i).getErrorText().getText().toString());
            System.out.println(NewNoteViewHolder.getLayoutAddCategory().findViewById(R.id.errorText).getContext().toString());
        }
    }

    @Override
    public int getItemCount() {
        if(typeCategory.equals("")) {
            return categoryList.size();
        }
        else {
            return countInformationTitle+typesNotes.getCountNewNotes();
        }
    }

    protected int getNumberCategory() {
        int NumberCategory = 0;
            try {
                NumberCategory = Integer.parseInt(typeCategory.trim());
            } catch (Exception e) {
                System.out.println(e);
            }
        return NumberCategory;
    }

    public int getCountInformationTitle() {
        return countInformationTitle;
    }

    public void setCountInformationTitle(int countInformationTitle) {
        this.countInformationTitle = countInformationTitle;
    }

    protected int getLanguage()
    {
        return SettingsProject.getLanguage();
    }

    public ArrayList<Fields> getItems() {
        return fields;
    }

    public static final class NewNoteViewHolder extends RecyclerView.ViewHolder {

        private TextView nameCategory;
        private static ConstraintLayout layoutSelectCategory;
        private static ConstraintLayout layoutAddCategory;
        private TextView titleText;
        private static TextView errorText;
        private ImageView imageView;
        private static TextView inputText;
        private static FloatingActionButton addNewItem;

        String typeCategory;

        public NewNoteViewHolder(@NonNull View itemView) {
            super(itemView);
            typeCategory = NewNoteActivity.getCategory();
            nameCategory = itemView.findViewById(R.id.name_category);
            if(typeCategory.equals(""))
            {
                layoutSelectCategory = itemView.findViewById(R.id.layoutSelectCategory);
                imageView = itemView.findViewById(R.id.MainInfo_imgContent);
                System.out.println("NewNoteAdapter.NewNoteViewHolder зашёл в список с категориями");
            }
            else
            {
                titleText = itemView.findViewById(R.id.titleText);
                inputText = itemView.findViewById(R.id.inputText);
                errorText = itemView.findViewById(R.id.errorText);
                layoutAddCategory = itemView.findViewById(R.id.layoutAddCategory);
                System.out.println("NewNoteAdapter.NewNoteViewHolder зашёл в список параметрами категорий");
            }
        }

        public TextView getNameCategory() {
            return nameCategory;
        }

        public static TextView getInputText() {
            return inputText;
        }

        public static TextView getErrorText() {
            return errorText;
        }

        public static ConstraintLayout getLayoutAddCategory() {
            return layoutAddCategory;
        }

        public void setNameCategory(TextView nameCategory) {
            this.nameCategory = nameCategory;
        }

        public static ConstraintLayout getLayoutSelectCategory() {
            return layoutSelectCategory;
        }

        public void setLayoutSelectCategory(ConstraintLayout layoutSelectCategory) {
            NewNoteViewHolder.layoutSelectCategory = layoutSelectCategory;
        }

    }
}
