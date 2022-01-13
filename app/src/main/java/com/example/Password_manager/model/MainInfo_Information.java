package com.example.Password_manager.model;

public class MainInfo_Information {
    int type;

    String NameArgs;
    String arg1;
    String arg2;
    String arg3;
    String arg4;

    public MainInfo_Information(int type, String arg1, String arg2, String arg3, String arg4) {
        this.type = type;
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.arg3 = arg3;
        this.arg4 = arg4;
    }

    public String getNameArgs() {
        return NameArgs;
    }

    public void setNameArgs(String nameArgs) {
        NameArgs = nameArgs;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getArg1() {
        return arg1;
    }

    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    public String getArg2() {
        return arg2;
    }

    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }

    public String getArg3() {
        return arg3;
    }

    public void setArg3(String arg3) {
        this.arg3 = arg3;
    }

    public String getArg4() {
        return arg4;
    }

    public void setArg4(String arg4) {
        this.arg4 = arg4;
    }
}
