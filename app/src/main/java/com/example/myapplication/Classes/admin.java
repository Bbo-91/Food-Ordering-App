package com.example.myapplication.Classes;
import  com.example.myapplication.Database.database;

public class admin extends person {
    String resturant;
//  Menu menu;

    public admin(String email, String username, String password, String resturant){
        super(username,password,email);
        this.resturant=resturant;
    }

    public String getResturant() {
        return resturant;
    }

    public static boolean Login(String email, String password){
       admin res =  database.adminSearch(email);
       if(res == null || !res.getPassword().equals(password)) return false;
       return true;

    }


}
