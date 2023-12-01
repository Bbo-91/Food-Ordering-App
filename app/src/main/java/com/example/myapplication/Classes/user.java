package com.example.myapplication.Classes;

import com.example.myapplication.Database.database;
import java.util.HashMap;
import java.util.Map;


public class user extends person{


    public Map<String, String> delievryAddress = new HashMap<>();


    public user(String email,String username,String password){
        super(username,password,email);

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
