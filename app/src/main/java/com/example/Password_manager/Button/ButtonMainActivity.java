package com.example.Password_manager.Button;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.Password_manager.DataBase.DBHelper;
import com.example.Password_manager.MainActivity;
import com.example.Password_manager.Notes.NewNoteActivity;
import com.example.Password_manager.R;
import com.example.Password_manager.SettingsProject;
import com.example.Password_manager.StringsProject;
import com.example.Password_manager.adapter.MainActivityAdapter;
import com.example.Password_manager.adapter.MainInfoAdapter;
import com.example.Password_manager.model.MainInfo;
import com.example.Password_manager.model.MainInformation;

import java.util.List;


public class ButtonMainActivity {

    private static DBHelper dbHelper;
    static Context context;
    /*public ButtonMainActivity(View v)
    {
        //MainActivityAdapter mainActivityHolder = new MainActivityAdapter();
        //addButton(mainActivityHolder);
    }*/


    public static void secure(MainInfoAdapter.MainInfoViewHolder mainInfoViewHolder, String visualProtectionText, List<MainInformation> mainInfoInformationList) {
        mainInfoViewHolder.getSecure1().setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               if (mainInfoViewHolder.getArg1().getText() == visualProtectionText) //Проверка ** или текст стоит сейчас
               {
                   mainInfoViewHolder.getSecure1().setImageResource(R.drawable.ic_baseline_visibility_off_10);
                   mainInfoViewHolder.getArg1().setText(mainInfoInformationList.get(0).getArg1());
               } else {
                   mainInfoViewHolder.getSecure1().setImageResource(R.drawable.ic_baseline_visibility_10);
                   mainInfoViewHolder.getArg1().setText(visualProtectionText);
               }
           }
       }
        );

        mainInfoViewHolder.getSecure2().setOnClickListener(new View.OnClickListener() {
               public void onClick(View v) {
                   if (mainInfoViewHolder.getArg2().getText() == visualProtectionText) //Проверка ** или текст стоит сейчас
                   {
                       mainInfoViewHolder.getSecure2().setImageResource(R.drawable.ic_baseline_visibility_off_10);
                       mainInfoViewHolder.getArg2().setText(mainInfoInformationList.get(0).getArg2());
                   } else {
                       mainInfoViewHolder.getSecure2().setImageResource(R.drawable.ic_baseline_visibility_10);
                       mainInfoViewHolder.getArg2().setText(visualProtectionText);
                   }
               }
           }
        );

        mainInfoViewHolder.getSecure3().setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               if (mainInfoViewHolder.getArg3().getText() == visualProtectionText) //Проверка ** или текст стоит сейчас
               {
                   mainInfoViewHolder.getSecure3().setImageResource(R.drawable.ic_baseline_visibility_off_10);
                   mainInfoViewHolder.getArg3().setText(mainInfoInformationList.get(0).getArg3());
               } else {
                   mainInfoViewHolder.getSecure3().setImageResource(R.drawable.ic_baseline_visibility_10);
                   mainInfoViewHolder.getArg3().setText(visualProtectionText);
               }
           }
       }
        );

        mainInfoViewHolder.getSecure4().setOnClickListener(new View.OnClickListener() {
               public void onClick(View v) {
                   if (mainInfoViewHolder.getArg4().getText() == visualProtectionText) //Проверка ** или текст стоит сейчас
                   {
                       mainInfoViewHolder.getSecure4().setImageResource(R.drawable.ic_baseline_visibility_off_10);
                       mainInfoViewHolder.getArg4().setText(mainInfoInformationList.get(0).getArg4());
                   } else {
                       mainInfoViewHolder.getSecure4().setImageResource(R.drawable.ic_baseline_visibility_10);
                       mainInfoViewHolder.getArg4().setText(visualProtectionText);
                   }
               }
           }
        );
    }
    public static void addButton()
    {
        MainActivityAdapter mainActivityAdapter = new MainActivityAdapter();
        mainActivityAdapter.getAddNewItem().setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               context = MainActivity.getContext();
               Intent intent = new Intent(context, NewNoteActivity.class);
               intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               context.startActivity(intent);
           }
       }
        );
    }
}
