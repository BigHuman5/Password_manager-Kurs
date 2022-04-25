package com.example.Password_manager.Notes;

import com.example.Password_manager.model.Security;

public class Regex {

    public static boolean nullField(String field)
    {
        if(field.length() == 0)
        {
            System.out.println("Пустое имя");
            return true; // Если поле с именем пустое.
        }
        else
        {
            System.out.println("Поле: "+field);
            return false;
        }
    }

    //
    public static boolean isWrongPassword(String password,String inputPassword)
    {
        // Одинаковые ли пароль и контрольный пароль.
        return password.equals(inputPassword);
    }
    //
    public static boolean isNewPasswordEntered(String password)
    {
        //Введённый новый пароль больше символов минимального пароля Security.minKey и не пробелы
        return password.length() >= Security.getMinKey() && password.charAt(0) != ' ';
    }

    public static boolean isNullPasswordConfirmation(String passwordConfirmation)
    {
        //Введён ли пароль проверки.
        return passwordConfirmation.length() > 0;
    }

    public static boolean isPasswordsSame(String password, String passwordConfirmation)
    {
        //Схожи ли пароль и пароль проверки.
        return password.length() == passwordConfirmation.length() && password.equals(passwordConfirmation);
    }
}
