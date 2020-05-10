package com.example.myproject;

import android.provider.ContactsContract;

public class UserGrades {
    private String nickname;
    private String password;
    private String countries;
    private String cities;
    private String animals;

    public UserGrades(String nickname, String password, String countries, String cities, String animals) {
        this.nickname = nickname;
        this.password = password;
        this.countries = countries;
        this.cities = cities;
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "UserGrades{" +
                "nickname=" + nickname + '\n' +
                "password=" + password + '\n' +
                "countries=" + countries + '\n' +
                "cities=" + cities + '\n' +
                "animals=" + animals + '\n' ;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public String getCities() {
        return cities;
    }

    public void setCities(String cities) {
        this.cities = cities;
    }

    public String getAnimals() {
        return animals;
    }

    public void setAnimals(String animals) {
        this.animals = animals;
    }
}

