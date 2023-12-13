package com.example.myapplication.Classes;

import com.example.myapplication.Database.database;
import java.util.HashMap;
import java.util.Map;


public class user extends person{
    private String city;
    private String street;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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



    public user(int id,String email,String username,String password,String city,String street){
        super(username,password,email);
        this.id=id;
        this.city=city;
        this.street=street;
    }

    public static boolean Login(String email,String password){
      user res = database.userSearch(email);
        if(res == null || !res.getPassword().equals(password)) return false;
        return true;

    }
    public String SignUP()
    {
        return database.addUser(this);
    }

}
