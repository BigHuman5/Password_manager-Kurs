package com.example.Password_manager.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.Password_manager.R;
import com.example.Password_manager.model.MainInfo;
import com.example.Password_manager.model.MainInfo_Information;

import java.util.List;

public class MainInfo_InformationAdapter extends RecyclerView.Adapter<MainInfo_InformationAdapter.MainInfo_InformationHolder>{

    Context context;
    List<MainInfo_Information> MainInfo_Information;

    public MainInfo_InformationAdapter(Context context, List<com.example.Password_manager.model.MainInfo_Information> mainInfo_Information) {
        this.context = context;
        MainInfo_Information = mainInfo_Information;
    }

    @NonNull
    @Override
    public MainInfo_InformationHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View MainInfo_InformationItems = LayoutInflater.from(context).inflate(R.layout.maininfo_information,viewGroup,false);
        return new MainInfo_InformationHolder(MainInfo_InformationItems);
    }

    @Override
    public void onBindViewHolder(@NonNull MainInfo_InformationHolder mainInfo_informationHolder, int i) {
        mainInfo_informationHolder.arg.setText(MainInfo_Information.get(i).getNameArgs());
    }

    @Override
    public int getItemCount() {
        return MainInfo_Information.size();
    }

    public static final class MainInfo_InformationHolder extends RecyclerView.ViewHolder {

        TextView arg;
        TextView arg_value;
        FloatingActionButton copy;
        FloatingActionButton secure;

        public MainInfo_InformationHolder(@NonNull View itemView) {
            super(itemView);

            arg = itemView.findViewById(R.id.Arg);
            arg_value = itemView.findViewById(R.id.Arg_value);
            copy = itemView.findViewById(R.id.copy);
            secure = itemView.findViewById(R.id.secure);

        }
    }
}
