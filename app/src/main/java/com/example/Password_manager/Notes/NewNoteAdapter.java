package com.example.Password_manager.Notes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Password_manager.Button.ButtonAddNewNote;
import com.example.Password_manager.R;
import com.example.Password_manager.SettingsProject;
import com.example.Password_manager.StringsProject;
import com.example.Password_manager.model.Category;

import java.util.List;

public class NewNoteAdapter extends RecyclerView.Adapter<NewNoteAdapter.NewNoteViewHolder> {

    Context context;
    List<Category> categoryList;
    String[] informationTitle = new String[StringsProject.getHowType()];

    String typeCategory;

    int numberCategory;

    public NewNoteAdapter(Context context, List<Category> categoryList, String typeCategory) {
        this.context = context;
        this.categoryList = categoryList;
        this.typeCategory = typeCategory;
        numberCategory = getNumberCategory();
        informationTitle = StringsProject.getInformationTitle(numberCategory);
        System.out.println(numberCategory+" | "+StringsProject.getInformationTitleLength(numberCategory) + " Число");
    }

    @NonNull
    @Override
    public NewNoteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View NewNoteItems;
        if(typeCategory.equals("")) { //Если прилетел пустой ответ, тоесть тип не выбрал. Отображается выбор типа
            NewNoteItems = LayoutInflater.from(context).inflate(R.layout.selectcategory_addnewnote, viewGroup, false);
        }
        else{ //Если прилетел ответ, тоесть тип выбран. Отображается меню с заполнением информации
            NewNoteItems = LayoutInflater.from(context).inflate(R.layout.enterinfo_addnewnote,viewGroup,false);
        }
        return new NewNoteAdapter.NewNoteViewHolder(NewNoteItems);
    }

    @Override
    public void onBindViewHolder(@NonNull NewNoteViewHolder newNoteViewHolder, int i) {
        if(typeCategory.equals("")) { //Если прилетел пустой ответ, тоесть тип не выбрал. Отображается выбор типа
            newNoteViewHolder.nameCategory.setText(categoryList.get(i).getNameCategory());
            System.out.println(i);
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
        else
        {
            newNoteViewHolder.errorText.setVisibility(View.INVISIBLE);
            newNoteViewHolder.inputText.setText("");
            numberCategory = getNumberCategory();
            informationTitle = StringsProject.getAddNewItem(getLanguage(),numberCategory);
            //informationTitle = StringsProject.getInformationTitle(numberCategory);
            newNoteViewHolder.titleText.setText(informationTitle[i]);
            typesNotes typesNotes = new typesNotes(numberCategory,i);
        }
    }

    @Override
    public int getItemCount() {
        if(typeCategory.equals("")) {
            return categoryList.size();
        }
        else {
            return informationTitle.length;
        }
    }

    protected int getNumberCategory() {
        int NumberCategory = 0;
        System.out.println(typeCategory+" Test");
            try {
                NumberCategory = Integer.parseInt(typeCategory.trim());
            } catch (Exception e) {
                System.out.println(e);
            }
        return NumberCategory;
    }

    protected int getLanguage()
    {
        return SettingsProject.getLanguage();
    }

    public static final class NewNoteViewHolder extends RecyclerView.ViewHolder {

        private TextView nameCategory;
        private static ConstraintLayout layoutSelectCategory;
        private static ConstraintLayout layoutAddCategory;
        private TextView titleText;
        private TextView errorText;
        private ImageView imageView;
        private static TextView inputText;

        String typeCategory;

        public NewNoteViewHolder(@NonNull View itemView) {
            super(itemView);
            typeCategory = NewNoteActivity.getCategory();
            nameCategory = itemView.findViewById(R.id.name_category);
            if(typeCategory.equals(""))
            {
                layoutSelectCategory = itemView.findViewById(R.id.layoutSelectCategory);
                imageView = itemView.findViewById(R.id.img_content);
                System.out.println("!!!Typecategory null ну это понятно!!");
            }
            else
            {
                titleText = itemView.findViewById(R.id.titleText);
                inputText = itemView.findViewById(R.id.inputText);
                errorText = itemView.findViewById(R.id.errorText);

                layoutAddCategory = itemView.findViewById(R.id.layoutAddCategory);
                System.out.println("!!Typecategory null НЕЖДАНЧИК!!");
            }
        }

        public TextView getNameCategory() {
            return nameCategory;
        }

        public static TextView getInputText() {
            return inputText;
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
            this.layoutSelectCategory = layoutSelectCategory;
        }
    }
}
