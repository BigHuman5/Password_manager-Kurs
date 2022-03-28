package com.example.Password_manager.adapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Password_manager.DataBase.DBHelper;
import com.example.Password_manager.MainActivity;
import com.example.Password_manager.R;
import com.example.Password_manager.SecurityActivity;

public class SecurityAdapter extends SecurityActivity {

    private int logoInt = R.drawable.facebook;
    private DBHelper dbHelper;
    private SQLiteDatabase database;
    //
    private ImageView logo;
    ///
    private ConstraintLayout layoutWithActiveBD;
    private static TextView textEnterPasswordSecurity;
    private static EditText inputPassword;
    private static TextView errorText;
    private static Button buttonForEnterPassword;
    ///
    private ConstraintLayout layoutCreateBD;
    private static TextView textCreatePasswordSecurity;
    private static EditText InputNewPassword;
    private static TextView textConfirmationPasswordSecurity;
    private static EditText InputPasswordConfirmation;
    private static TextView errorCreateText;
    private static Button buttonForCreatePassword;
    //


    public SecurityAdapter(Context context) {
        definitionItems();
        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase(); // создание/открытие бд
        System.out.println(dbHelper.isDataEntered()); // проверяет создана ли бд
        fd(dbHelper);
    }

    public void fd(DBHelper dbHelper)
    {
        if(dbHelper.isDataEntered()) {
            textEnterPasswordSecurity.setText("Тут есть бд");
            layoutWithActiveBD.setVisibility(View.VISIBLE);
        }
        else{
            textCreatePasswordSecurity.setText("Тут пусто");
            layoutCreateBD.setVisibility(View.VISIBLE);
        }
    }

    protected void definitionItems()
    {
        ConstraintLayout securityActivity = SecurityActivity.getSecurityActivity();
        //
        layoutWithActiveBD = securityActivity.findViewById(R.id.LayoutWithActiveBD);
        textEnterPasswordSecurity = securityActivity.findViewById(R.id.textEnterPasswordSecurity);
        logo = securityActivity.findViewById(R.id.logo);
        logo.setImageResource(logoInt);
        inputPassword = securityActivity.findViewById(R.id.InputPassword);
        errorText = securityActivity.findViewById(R.id.errorText);
        buttonForEnterPassword = securityActivity.findViewById(R.id.buttonForEnterPassword);
        //
        layoutCreateBD = securityActivity.findViewById(R.id.LayoutCreatePassword);
        textCreatePasswordSecurity = securityActivity.findViewById(R.id.textCreatePasswordSecurity);
        InputNewPassword = securityActivity.findViewById(R.id.InputNewPassword);
        textConfirmationPasswordSecurity = securityActivity.findViewById(R.id.textConfirmationPasswordSecurity);
        InputPasswordConfirmation = securityActivity.findViewById(R.id.InputPasswordConfirmation);
        errorCreateText = securityActivity.findViewById(R.id.errorCreateText);
        buttonForCreatePassword = securityActivity.findViewById(R.id.buttonForCreatePassword);
        //

    }

    public ConstraintLayout getLayoutWithActiveBD() {
        return layoutWithActiveBD;
    }

    public static TextView getTextEnterPasswordSecurity() {
        return textEnterPasswordSecurity;
    }

    public static EditText getInputPassword() {
        return inputPassword;
    }

    public static TextView getErrorText() {
        return errorText;
    }

    public static Button getButtonForEnterPassword() {
        return buttonForEnterPassword;
    }
}
