package com.example.Password_manager.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.Password_manager.R;
import com.example.Password_manager.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    Context context;
    List<Category> categoryList;

    public CategoryAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View categoryFilterItems = LayoutInflater.from(context).inflate(R.layout.category_filter,viewGroup,false);
        return new CategoryViewHolder(categoryFilterItems);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i)
    {
        categoryViewHolder.categoryFilterTitle.setText(categoryList.get(i).getNameCategory());
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static final class CategoryViewHolder extends RecyclerView.ViewHolder
    {
        TextView categoryFilterTitle;
        public CategoryViewHolder(@NonNull View itemView) {

            super(itemView);

            categoryFilterTitle = itemView.findViewById(R.id.CategoryFilterTitle);
        }
    }
}
