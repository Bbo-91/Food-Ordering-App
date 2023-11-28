package com.example.myapplication.Classes;

public abstract class person {
    public String userName;
    public String password;
    public String email;
    public person(String userName,String password,String email){

        this.email = email;
        this.password = password;
        this.userName = userName;
    }


}
