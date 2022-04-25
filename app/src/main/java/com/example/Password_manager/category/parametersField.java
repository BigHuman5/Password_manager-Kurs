package com.example.Password_manager.category;

import com.example.Password_manager.StringsProject;

import java.util.Arrays;

public class parametersField {
    private boolean[] secureField = new boolean[StringsProject.getHowType()];
    private boolean[] copyField = new boolean[StringsProject.getHowType()];

    public parametersField(int type) {
        switch (type)
        {
            case 0:
            {
                secureField[0] = false; // Логин
                copyField[0] = false;
                //
                secureField[1] = true; // Пароль
                copyField[1] = true;
                //
                secureField[2] = true; // Комментарий
                copyField[2] = false;
                break;
            }
            case 1:
            {
                secureField[0] = true; // Номер карты
                copyField[0] = true;
                //
                secureField[1] = true; // Дата окончания
                copyField[1] = true;
                //
                secureField[2] = true; // Код безопасности/CVV
                copyField[2] = true;
                //
                secureField[3] = true; // Имя владельца карты
                copyField[3] = true;
                //
                secureField[4] = true; // Пин код
                copyField[4] = true;
                //
                secureField[5] = false; // Комментарий
                copyField[5] = true;
                break;
            }
            default:
            {
                System.out.println("Break! "+type);
                break;
            }
        }
    }

    public boolean[] getSecureField() {
        System.out.println("Fd: "+ Arrays.toString(secureField));
        return secureField;
    }

    public void setSecureField(boolean[] secureField) {
        this.secureField = secureField;
    }

    public boolean[] getCopyField() {
        return copyField;
    }

    public void setCopyField(boolean[] copyField) {
        this.copyField = copyField;
    }
}
