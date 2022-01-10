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
import com.example.Password_manager.model.MainInfo;

import java.util.List;

public class MainInfoAdapter extends RecyclerView.Adapter<MainInfoAdapter.MainInfoViewHolder> {

    Context context;
    List<MainInfo> MainInfoList;

    public MainInfoAdapter(Context context, List<MainInfo> mainInfoList) {
        this.context = context;
        MainInfoList = mainInfoList;
    }

    @NonNull
    @Override
    public MainInfoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MainInfoViewHolder mainInfoViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return MainInfoList.size();
    }

    public static final class MainInfoViewHolder extends RecyclerView.ViewHolder
    {

        public MainInfoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

