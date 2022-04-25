package com.example.Password_manager.Notes.model;

import android.widget.TextView;

public class Fields {
    private TextView inputText;
    private TextView errorText;
    public Fields(TextView inputText, TextView errorText) {
        this.inputText = inputText;
        this.errorText = errorText;
    }

    public TextView getInputText() {
        return inputText;
    }

    public TextView getErrorText() {
        return errorText;
    }
}
