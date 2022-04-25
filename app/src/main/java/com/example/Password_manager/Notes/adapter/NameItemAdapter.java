package com.example.Password_manager.Notes.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Password_manager.Notes.NewNoteActivity;
import com.example.Password_manager.Notes.NewNoteAdapter;
import com.example.Password_manager.Notes.typesNotes;
import com.example.Password_manager.R;
import com.example.Password_manager.category.imageType;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NameItemAdapter extends ArrayAdapter<imageType> {

    private List<imageType> listWebsites;

    public NameItemAdapter(@NonNull Context context, @NonNull List<imageType> objects) {
        super(context, 0, objects);
        listWebsites = new ArrayList<>(objects);
    }


    public Filter getFilter()
        {
                return filterNamed;
        }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.standardview_nameitem,parent,false);
        }
        //web
        TextView NameView;
        ImageView ImgView;
        NameView = convertView.findViewById(R.id.standardNameView);
        ImgView = convertView.findViewById(R.id.img_nameItem);
            imageType imageType = getItem(position);
            if (imageType != null) {
                NameView.setText(imageType.getName());
                ImgView.setImageResource(imageType.getImagesrc());
            }
        return convertView;
    }



    private Filter filterNamed = new Filter()
        {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence)
            {
                FilterResults results = new FilterResults();
                List<imageType> suggestions = new ArrayList<>();

                if(charSequence == null || charSequence.length() == 0)
                {
                    suggestions.addAll(listWebsites);
                }
                else
                {
                    String filternPattern = charSequence.toString().toLowerCase().trim();

                    for (imageType item: listWebsites)
                    {
                        if(item.getName().toLowerCase().contains(filternPattern))
                        {
                            suggestions.add(item);
                        }
                    }
                }

                results.values = suggestions;
                results.count = suggestions.size();
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults)
            {
                clear();
                addAll((List) filterResults.values);
                notifyDataSetChanged(); // обновить лист
            }

            public CharSequence convertResultToString(Object resultValue) {
                    return ((imageType) resultValue).getName();
            }
        };
    }
