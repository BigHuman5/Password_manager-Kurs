package com.example.Password_manager.Notes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Password_manager.R;
import com.example.Password_manager.category.imageType;

import java.util.List;

public class spinnerAdapter extends BaseAdapter {

    private Context context;
    private List<imageType> listItems;

    public spinnerAdapter(Context context, List<imageType> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        View view = LayoutInflater.from(context).inflate(R.layout.standardview_nameitem,viewGroup,false);

        TextView NameView;
        ImageView ImgView;
        NameView = view.findViewById(R.id.standardNameView);
        ImgView = view.findViewById(R.id.img_nameItem);
            NameView.setText(listItems.get(position).getName());
            ImgView.setImageResource(listItems.get(position).getImagesrc());
        return view;
    }
}
