package com.example.Password_manager.model;


public class MainInfo {
    /*For Website*/
    String login;
    String password;
    /*            */

    /*For Bank cards*/
    String numberCard;
    String dateCard;
    String CVV;
    /*            */

    public MainInfo(String login, String password, String numberCard, String dateCard, String CVV) {
        this.login = login;
        this.password = password;
        this.numberCard = numberCard;
        this.dateCard = dateCard;
        this.CVV = CVV;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public String getDateCard() {
        return dateCard;
    }

    public void setDateCard(String dateCard) {
        this.dateCard = dateCard;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }
}
