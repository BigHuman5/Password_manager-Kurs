package com.example.Password_manager.Notes;

public class Regex {

    public static boolean nullName(String name)
    {
        if(name.length() == 0)
        {
            System.out.println("Пустое имя");
            return true; // Если поле с именем пустое.
        }
        else
        {
            System.out.println("Название: "+name);
            return false;
        }
    }

    public static boolean nullLogin(String login)
    {
        if(login.length() == 0)
        {
            System.out.println("Пустой логин");
            return true; // Если поле с логином пустое.
        }
        else
        {
            System.out.println("Логин: "+login);
            return false;
        }
    }

    //
    public static boolean isWrongPassword(String password,String inputPassword)
    {
        return password.equals(inputPassword);
    }
}
