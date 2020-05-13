package com.example.myproject;

public class User {
    private String Nickname = "";
    private String Password = "";
    private String Email = "";
    private String Phone = "";

    public User(String Nickname, String Password, String Email, String Phone) {
        this.Nickname = Nickname;
        this.Password = Password;
        this.Email = Email;
        this.Phone = Phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "Nickname=" + Nickname + '\n' +
                "Password=" + Password + '\n' +
                "Email=" + Email + '\n' +
                "Phone=" + Phone + '\n' ;

    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String Nickname) {
        this.Nickname = Nickname;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
}
