package com.example.myapplication.Classes;

import com.example.myapplication.Database.database;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;


public class user extends person{
    private String city;
    private String street;
    private int id;
     static Random random = new Random();
   static Set<Integer> ids = new HashSet<>();

    public user(int id,String email,String username,String password,String city,String street){
        super(username,password,email);
        this.id=id;
        this.city=city;
        this.street=street;
    }

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

    public static boolean Login(String email,String password){
      user res = database.userSearch(email);
        if(res == null || !res.getPassword().equals(password)) return false;
        return true;

    }
    public String SignUP()
    {
        return database.addUser(this);
    }
    public static  int GeneratedId() {

        int userId = random.nextInt(301) + 200;
        if(!ids.contains(userId)){
            ids.add(userId);
            return userId;
        }
         return GeneratedId();

    }
}
