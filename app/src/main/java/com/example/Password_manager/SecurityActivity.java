package com.example.Password_manager;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;

import com.example.Password_manager.Button.ButtonSecurity;
import com.example.Password_manager.DataBase.DBHelper;
import com.example.Password_manager.Notes.NewNoteActivity;
import com.example.Password_manager.adapter.SecurityAdapter;

public class SecurityActivity extends Activity {
    SecurityAdapter securityAdapter;
    private static Context context;
    private static ConstraintLayout securityActivity;
    private static Object BD = true;
    private static int language;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        language = SettingsProject.getLanguage();
        StringsProject.definitionTextForSecurity(language);
        StringsProject.definitionErrorText(language);
        setContentView(R.layout.security_main); // назначение нового layout
        SecurityActivity.context = getApplicationContext();
        securityActivity = findViewById(R.id.securityActivity);
        securityAdapter = new SecurityAdapter(this);
        new ButtonSecurity();
    }

    public static ConstraintLayout getSecurityActivity() {
        return securityActivity;
    }

    public static Context getContext() {
        return context;
    }

    public static Object getBD() {
        return BD;
    }

    public static int getLanguage() { return language;}
}
