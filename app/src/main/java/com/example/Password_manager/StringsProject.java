package com.example.Password_manager;

import android.util.Log;

import com.example.Password_manager.model.Category;
import com.example.Password_manager.model.MainInfo;
import com.example.Password_manager.model.MainInfo_Information;

import java.util.ArrayList;
import java.util.List;

public class StringsProject {

    private int HowType = 4;
    private String[] categoryFilterTitle;
    private String[][] InformationTitle= new String[HowType][];

    public StringsProject(int language) {
        definitionCategoryFilterTitle(language);
        definitionInformationTitle(language);
    }

    public List<Category> getListCategoryFilterTitle(int language)
    {
        List<Category> categoryList = new ArrayList<>();
        for(int i=0;i<categoryFilterTitle.length;i++)
            categoryList.add(new Category(i,categoryFilterTitle[i]));
        return categoryList;
    }

    public List<MainInfo> getListMainInfo(int language)
    {
        List<MainInfo> mainInfoList = new ArrayList<>();
        for(int i=0;i<=6;i++) {
            mainInfoList.add(new MainInfo("vk.com", 1, false,"1"));
            mainInfoList.add(new MainInfo("twitter.com", 1, false,"1"));
            mainInfoList.add(new MainInfo("facebook.com", 1, false,"1"));
        }
        return mainInfoList;
    }

    public List<MainInfo_Information> getListMainInformation(int language)
    {
        List<MainInfo_Information> mainInformationList = new ArrayList<>();
        mainInformationList.add(new MainInfo_Information(1,"Vk.com",null,null,null));
        return mainInformationList;
    }

    public void definitionCategoryFilterTitle(int language) {
        switch (language) {
            case 0: //Russian
            {
                categoryFilterTitle = new String[]{
                        "Веб-сайты",
                        "Банковские карты",
                        "Прочее",
                };
                break;
            }
            case 1: //English
            {
                categoryFilterTitle = new String[]{
                        "Websites",
                        "Bank cards",
                        "Other",
                };
            }
            default: System.exit(3);
        }
    }

    public void definitionInformationTitle(int language) {
        switch (language) {
            case 0: //Russian
            { //Website
                InformationTitle[1] = new String[]{
                        "Логин",
                        "Пароль",
                        "Комментарий"};
                break;
            }
            case 1: //English
            {
                //Website
                InformationTitle[1] = new String[]{
                        "Login",
                        "Password",
                        "Comment"};
                break;
            }
            default: System.exit(3);
        }
    }

    public void setCategoryFilterTitle(String[] categoryFilterTitle) {
        this.categoryFilterTitle = categoryFilterTitle;
    }

}
