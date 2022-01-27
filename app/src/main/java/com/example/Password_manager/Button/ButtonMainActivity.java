package com.example.Password_manager.Button;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.Password_manager.DataBase.DBHelper;
import com.example.Password_manager.MainActivity;
import com.example.Password_manager.NewNoteActivity;
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
        StringsProject stringsProject = new StringsProject(SettingsProject.getLanguage());
        List<MainInfo> mainInfoList = stringsProject.getListMainInfo();
        System.out.println("На меня нажали!");
        MainActivityAdapter mainActivityAdapter = new MainActivityAdapter();
        mainActivityAdapter.getAddNewItem().setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {/*
              System.out.println("На меня нажали и я зашёл в цикл!");
               dbHelper = MainActivity.getDbHelper();
               SQLiteDatabase database = dbHelper.getWritableDatabase();

               //List<MainInfo> MainInfoList = MainActivity.getMainInfoList();

               ContentValues contentValues = new ContentValues(); // Для удобной работы с бд
               contentValues.put(DBHelper.getKeyId(),mainInfoList.size()+1);
               contentValues.put(DBHelper.getKeyPosition(),mainInfoList.size()+1);
        /*contentValues.put(DBHelper.getKeyType(),1);
        contentValues.put(DBHelper.getKeyName(),"twitter.com");
        contentValues.put(DBHelper.getKeyFavorite(),false);

        contentValues.put(DBHelper.getKEY_1ArgValue(),"Какая-то важная информация");
        contentValues.put(DBHelper.getKEY_2ArgValue(),"Крутой пароль тут");
        contentValues.put(DBHelper.getKEY_3ArgValue(),"Коммент");*/
/*
               contentValues.put(DBHelper.getKeyType(),2);
               contentValues.put(DBHelper.getKeyName(),"Master Card");
               contentValues.put(DBHelper.getKeyFavorite(),false);

               contentValues.put(DBHelper.getKEY_1ArgValue(),"3521654597545487");
               contentValues.put(DBHelper.getKEY_2ArgValue(),"02/24");
               contentValues.put(DBHelper.getKEY_3ArgValue(),"5412");
               contentValues.put(DBHelper.getKEY_4ArgValue(),"Evgef Erfdf");
               contentValues.put(DBHelper.getKEY_5ArgValue(),"54874");
               contentValues.put(DBHelper.getKEY_6ArgValue(),"Nice jock");


               Log.d("mfd","ID = "+contentValues.get(DBHelper.getKeyId())
                       +"| Type = "+contentValues.get(DBHelper.getKeyType())
                       +"| Name = "+contentValues.get(DBHelper.getKeyName()));
               database.insert(DBHelper.getTableName(),null,contentValues);
*/
               //context = MainActivity.getMainActivity().getContext();
               //context = LayoutInflater.from(getContext()).inflate(R.layout.activity_main, parent, false);
              // Activity activity = (Activity) context;
               //MainActivity mainActivity = new MainActivity();
               context = MainActivity.getContext();
               Intent intent = new Intent(context, NewNoteActivity.class);
               //Activity activity = new Activity();
               intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               context.startActivity(intent);
           }
       }
        );
    }
}
