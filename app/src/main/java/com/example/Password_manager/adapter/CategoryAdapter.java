package com.example.Password_manager.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Password_manager.DataBase.ActionsWithBD;
import com.example.Password_manager.MainActivity;
import com.example.Password_manager.Notes.NewNoteActivity;
import com.example.Password_manager.R;
import com.example.Password_manager.StringsProject;
import com.example.Password_manager.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    Context context;
    List<Category> categoryList;
    private MainInfoAdapter MainInfoAdapter;
    MainActivity mainActivity;

    public CategoryAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
        mainActivity=new MainActivity();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View categoryFilterItems = LayoutInflater.from(context).inflate(R.layout.standardview_nameitem,viewGroup,false);
        return new CategoryViewHolder(categoryFilterItems);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i)
    {
        Context c = MainActivity.getContext();
        String nameRes = categoryList.get(i).getNameCategory().toLowerCase();
        int id = c.getResources().getIdentifier(nameRes, "string", c.getPackageName());
        categoryViewHolder.categoryFilterTitle.setText(id);
        //
        id = c.getResources().getIdentifier(nameRes, "drawable", c.getPackageName());
        categoryViewHolder.categoryImageView.setImageResource(id);
        categoryViewHolder.categoryImageView.setColorFilter(ContextCompat.getColor(context,R.color.iris_100));
        //
        int amountItem = ActionsWithBD.getAmountItem(i);
        if(amountItem != (-1))
        {
            categoryViewHolder.amountItems.setText(String.valueOf(amountItem));
            categoryViewHolder.amountItems.setVisibility(View.VISIBLE);
        }
        System.out.println("57: "+MainActivity.getActualCategory()+" | "+i);
        if(MainActivity.getActualCategory() == i){
            categoryViewHolder.categoryFilterTitle.setTextColor(ContextCompat.getColor(context,R.color.iris_100));
            categoryViewHolder.amountItems.setTextColor(ContextCompat.getColor(context,R.color.iris_100));
            categoryViewHolder.leftCard.setVisibility(View.VISIBLE);
        }
        else{
            System.out.println("ELSE");
            categoryViewHolder.categoryFilterTitle.setTextColor(ContextCompat.getColor(context,R.color.black));
            categoryViewHolder.amountItems.setTextColor(ContextCompat.getColor(context,R.color.black));
            categoryViewHolder.leftCard.setVisibility(View.GONE);
        }
        categoryViewHolder.layoutForNameItem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                notifyItemChanged(MainActivity.getActualCategory());
                MainActivity.setActualCategory(categoryViewHolder.getAdapterPosition());
                notifyItemChanged(categoryViewHolder.getAdapterPosition());

                /*Костыль с обновлением данных*/
                context = MainActivity.getContext();
                Intent intent = new Intent(context, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(intent);
                /*------*/


            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static final class CategoryViewHolder extends RecyclerView.ViewHolder
    {

        TextView categoryFilterTitle;
        ImageView categoryImageView;
        CardView leftCard;
        TextView amountItems;
        ConstraintLayout layoutForNameItem;
        public CategoryViewHolder(@NonNull View itemView) {

            super(itemView);
            categoryFilterTitle = itemView.findViewById(R.id.standardNameView);
            categoryImageView = itemView.findViewById(R.id.img_nameItem);
            leftCard = itemView.findViewById(R.id.leftCard);
            amountItems = itemView.findViewById(R.id.amountItems);
            layoutForNameItem = itemView.findViewById(R.id.layoutForNameItem);
        }
    }
}
