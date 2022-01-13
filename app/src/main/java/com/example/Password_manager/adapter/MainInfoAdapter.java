package com.example.Password_manager.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Password_manager.R;
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
        View MainInfoItems = LayoutInflater.from(context).inflate(R.layout.maininfo_content,viewGroup,false);
        return new MainInfoAdapter.MainInfoViewHolder(MainInfoItems);
    }

    @Override
    public void onBindViewHolder(@NonNull MainInfoViewHolder mainInfoViewHolder, int i) {
        mainInfoViewHolder.name_content.setText(MainInfoList.get(i).getNameContent());

        mainInfoViewHolder.CardViewforInformation.setBackgroundResource(R.color.forActionButtonMain);

    }

    @Override
    public int getItemCount() {
        return MainInfoList.size();
    }

    public static final class MainInfoViewHolder extends RecyclerView.ViewHolder
    {
        FloatingActionButton button_close_or_open_content;
        ImageView img_content;
        TextView name_content;
        FloatingActionButton more_info_about_content;
        CardView CardViewforInformation;




        public MainInfoViewHolder(@NonNull View itemView) {
            super(itemView);

            button_close_or_open_content = itemView.findViewById(R.id.button_close_or_open_content);
            img_content = itemView.findViewById(R.id.img_content);
            name_content = itemView.findViewById(R.id.name_content);

            more_info_about_content = itemView.findViewById(R.id.more_info_about_content);
            CardViewforInformation = itemView.findViewById(R.id.cardviewforinformation);

        }
    }
}

