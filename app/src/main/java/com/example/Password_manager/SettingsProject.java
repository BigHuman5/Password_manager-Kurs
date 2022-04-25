package com.example.Password_manager;

public class SettingsProject {
    private static int language;

    public SettingsProject() {
        definitionLanguage();
    }

    private void definitionLanguage() {
        language = 0;
    }

    public static int getLanguage() {
        return language;
    }
}
