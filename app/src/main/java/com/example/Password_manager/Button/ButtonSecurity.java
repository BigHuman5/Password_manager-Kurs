package com.example.Password_manager.Button;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.Password_manager.DataBase.ActionsWithBD;
import com.example.Password_manager.DataBase.DBHelper;
import com.example.Password_manager.MainActivity;
import com.example.Password_manager.Notes.NewNoteActivity;
import com.example.Password_manager.Notes.NewNoteAdapter;
import com.example.Password_manager.Notes.Regex;
import com.example.Password_manager.SecurityActivity;
import com.example.Password_manager.SecurityInformation;
import com.example.Password_manager.StringsProject;
import com.example.Password_manager.adapter.SecurityAdapter;
import com.example.Password_manager.model.Security;

public class ButtonSecurity {

    static Context context;

    public ButtonSecurity()
    {
        VerifyExistingPassword();
        CreateNewPassword();
    }

    private void CreateNewPassword() {
        SecurityAdapter.getButtonForCreatePassword().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputNewPassword = SecurityAdapter.getInputNewPassword().getText().toString();
                String inputPasswordConfirmation = SecurityAdapter.getInputPasswordConfirmation().getText().toString();

                SecurityAdapter.getErrorNewPasswordText().setVisibility(View.GONE);
                SecurityAdapter.getErrorConfirmationPasswordText().setVisibility(View.GONE);
                if(Regex.isNewPasswordEntered(inputNewPassword))
                {
                    SecurityAdapter.getErrorNewPasswordText().setVisibility(View.GONE);
                    if(Regex.isNullPasswordConfirmation(inputPasswordConfirmation))
                    {
                        SecurityAdapter.getErrorConfirmationPasswordText().setVisibility(View.GONE);
                        if(Regex.isPasswordsSame(inputNewPassword,inputPasswordConfirmation))
                        {
                            SecurityAdapter.getErrorConfirmationPasswordText().setVisibility(View.GONE);
                            ActionsWithBD.addNewSecretKey(inputNewPassword);
                            //
                            context = SecurityActivity.getContext();
                            Intent intent = new Intent(context, SecurityActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY); // чтобы закрывалось на выход.
                            context.startActivity(intent);
                            //
                        }
                        else{
                            SecurityAdapter.getErrorConfirmationPasswordText().setText(StringsProject.getItemErrorText(3));
                            SecurityAdapter.getErrorConfirmationPasswordText().setVisibility(View.VISIBLE);
                        }
                    }
                    else{
                        SecurityAdapter.getErrorConfirmationPasswordText().setText(StringsProject.getItemErrorText(4));
                        SecurityAdapter.getErrorConfirmationPasswordText().setVisibility(View.VISIBLE);
                    }
                }
                else {
                    SecurityAdapter.getErrorNewPasswordText().setText(StringsProject.getItemErrorText(5));
                    SecurityAdapter.getErrorNewPasswordText().setVisibility(View.VISIBLE);
                }
            }
        });

        }

    private void ResetPassword(){}

    private void VerifyExistingPassword()
    {
        SecurityAdapter.getButtonForEnterPassword().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputPassword = SecurityAdapter.getInputPassword().getText().toString();
                String encKey = ActionsWithBD.getSecretKey();
                String encInputPassword = SecurityInformation.encryption(inputPassword);
                if(encKey != null && encInputPassword != null) {
                    boolean isRightPass = Regex.isWrongPassword(encKey, encInputPassword);
                    if (isRightPass) {
                        Security.setKey(inputPassword);
                        SecurityAdapter.getErrorText().setVisibility(View.GONE);
                        SecurityAdapter.getInputPassword().setText("");
                        context = SecurityActivity.getContext();
                        Intent intent = new Intent(context, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY); // чтобы оно mainActivity закрывалось на выход.
                        context.startActivity(intent);

                    } else {
                        SecurityAdapter.getErrorText().setText(StringsProject.getItemErrorText(2));
                        SecurityAdapter.getErrorText().setVisibility(View.VISIBLE);
                    }
                }
                else {
                    SecurityAdapter.getErrorText().setText("SYSTEM ERROR");
                    SecurityAdapter.getErrorText().setVisibility(View.VISIBLE);
                }
            }
        });
    }

}
