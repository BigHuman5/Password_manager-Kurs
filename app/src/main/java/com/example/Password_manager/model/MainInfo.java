package com.example.Password_manager.model;


public class MainInfo {


    /*For All*/
    String nameContent;

    int type;
    Boolean favorite;

    String arg1;
     /*            */

    public MainInfo(String nameContent, int type, Boolean favorite,String arg1) {
        this.nameContent = nameContent;
        this.type = type;
        this.favorite = favorite;
    }

    public String getNameContent() {
        return nameContent;
    }

    public void setNameContent(String nameContent) {
        this.nameContent = nameContent;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public String getArg1() {
        return arg1;
    }

    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }
}
