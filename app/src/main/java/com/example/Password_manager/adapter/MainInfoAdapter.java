package com.example.Password_manager.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        View MainInfoItems = LayoutInflater.from(context).inflate(R.layout.websites_close,viewGroup,false);
        return new MainInfoAdapter.MainInfoViewHolder(MainInfoItems);
    }

    @Override
    public void onBindViewHolder(@NonNull MainInfoViewHolder mainInfoViewHolder, int i) {
        mainInfoViewHolder.name_content.setText(MainInfoList.get(i).getNameContent());
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
        CardView cardView;
        ConstraintLayout layout_grey;
        TextView arg_content;
        TextView value_content;
        FloatingActionButton secure_content;



        public MainInfoViewHolder(@NonNull View itemView) {
            super(itemView);

            button_close_or_open_content = itemView.findViewById(R.id.button_close_or_open_content);
            img_content = itemView.findViewById(R.id.img_content);
            name_content = itemView.findViewById(R.id.name_content);

            cardView = itemView.findViewById(R.id.CardView);
            layout_grey = itemView.findViewById(R.id.layout_grey);

            arg_content = itemView.findViewById(R.id.Arg);
            value_content = itemView.findViewById(R.id.Arg_value);
            secure_content = itemView.findViewById(R.id.secure);
        }
    }
}

