package com.example.Password_manager.model;

public class MainInformation {
    int type;

    String NameArg1;
    String arg1;
    int secure1;

    String NameArg2;
    String arg2;
    int secure2;

    String NameArg3;
    String arg3;
    int secure3;

    String NameArg4;
    String arg4;
    int secure4;


    public MainInformation(int type, String nameArg1, String arg1, int secure1, String nameArg2, String arg2, int secure2, String nameArg3, String arg3, int secure3, String nameArg4, String arg4, int secure4) {
        this.type = type;
        NameArg1 = nameArg1;
        this.arg1 = arg1;
        this.secure1 = secure1;
        NameArg2 = nameArg2;
        this.arg2 = arg2;
        this.secure2 = secure2;
        NameArg3 = nameArg3;
        this.arg3 = arg3;
        this.secure3 = secure3;
        NameArg4 = nameArg4;
        this.arg4 = arg4;
        this.secure4 = secure4;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getNameArg1() {
        return NameArg1;
    }

    public void setNameArg1(String nameArg1) {
        NameArg1 = nameArg1;
    }

    public String getArg1() {
        return arg1;
    }

    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }



    public String getNameArg2() {
        return NameArg2;
    }

    public void setNameArg2(String nameArg2) {
        NameArg2 = nameArg2;
    }

    public String getArg2() {
        return arg2;
    }

    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }



    public String getNameArg3() {
        return NameArg3;
    }

    public void setNameArg3(String nameArg3) {
        NameArg3 = nameArg3;
    }

    public String getArg3() {
        return arg3;
    }

    public void setArg3(String arg3) {
        this.arg3 = arg3;
    }



    public String getNameArg4() {
        return NameArg4;
    }

    public void setNameArg4(String nameArg4) {
        NameArg4 = nameArg4;
    }

    public String getArg4() {
        return arg4;
    }

    public void setArg4(String arg4) {
        this.arg4 = arg4;
    }

    public int getSecure1() {
        return secure1;
    }

    public void setSecure1(int secure1) {
        this.secure1 = secure1;
    }

    public int getSecure2() {
        return secure2;
    }

    public void setSecure2(int secure2) {
        this.secure2 = secure2;
    }

    public int getSecure3() {
        return secure3;
    }

    public void setSecure3(int secure3) {
        this.secure3 = secure3;
    }

    public int getSecure4() {
        return secure4;
    }

    public void setSecure4(int secure4) {
        this.secure4 = secure4;
    }
}
