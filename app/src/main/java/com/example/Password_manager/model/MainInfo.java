package com.example.Password_manager.model;


public class MainInfo {


    /*For All*/
    int type;
    int position;

    String nameContent;

    String arg1;

    String nameCategory;


    Boolean favorite;
     /*            */

    public MainInfo(int type,int position,String nameCategory, String nameContent, String arg1, Boolean favorite) {
        this.position = position;
        this.type = type;
        this.nameContent = nameContent;
        this.arg1 = arg1;
        this.favorite = favorite;
        this.nameCategory = nameCategory;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getArg1() {
        return arg1;
    }

    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    public String getNameContent() {
        return nameContent;
    }

    public void setNameContent(String nameContent) {
        this.nameContent = nameContent;
    }


    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
