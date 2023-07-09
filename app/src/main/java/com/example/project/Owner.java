package com.example.project;

import java.util.ArrayList;

public class Owner {
    private String name;
    private String number;
    private String mail;
    private String password;
    private ArrayList<Home> homes;

    Owner(){
    }

    public Owner(String name, String number, String mail, String password) {
        this.name = name;
        this.number = number;
        this.mail = mail;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Home> getHomes() {
        return homes;
    }

    public void setHomes(ArrayList<Home> homes) {
        this.homes = homes;
    }

    public void addHome(Home home){
        homes.add(home);
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", homes=" + homes +
                '}';
    }
}
