package com.example.myapplication.Classes;

import com.example.myapplication.Database.database;
import java.util.HashMap;
import java.util.Map;


public class user extends person{
    private String city;
    private String street;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }



    public user(String email,String username,String password,String city,String street){
        super(username,password,email);
        this.city=city;
        this.street=street;
    }

    public static boolean Login(String email,String password){
      user res = database.userSearch(email);
        if(res == null || !res.password.equals(password)) return false;
        return true;

    }
    public String SignUP()
    {
        return database.addUser(this);
    }

}
