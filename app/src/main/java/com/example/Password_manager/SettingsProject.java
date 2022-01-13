package com.example.Password_manager;

public class SettingsProject {
    private int language;

    public SettingsProject() {
        definitionLanguage();
    }

    private void definitionLanguage() {
        language = 1;
    }

    public int getLanguage() {
        return language;
    }
}
