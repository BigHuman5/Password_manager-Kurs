package com.example.Password_manager.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.Password_manager.R;
import com.example.Password_manager.model.Category;
import com.example.Password_manager.model.MainInformation;

import java.util.List;

public class MainInformationAdapter extends RecyclerView.Adapter<MainInformationAdapter.MainInformationViewHolder> {

    Context context;
    List<MainInformation> MainInformationList;


    public MainInformationAdapter(Context context, List<MainInformation> mainInformationList) {
        this.context = context;
        MainInformationList = mainInformationList;
    }

    @NonNull
    @Override
    public MainInformationViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View MainInformationItems = LayoutInflater.from(context).inflate(R.layout.maininfo_information,viewGroup,false);
        return new MainInformationAdapter.MainInformationViewHolder(MainInformationItems);
    }

    @Override
    public void onBindViewHolder(@NonNull MainInformationViewHolder mainInformationViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return MainInformationList.size();
    }

    public static class MainInformationViewHolder extends RecyclerView.ViewHolder {

        public MainInformationViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
