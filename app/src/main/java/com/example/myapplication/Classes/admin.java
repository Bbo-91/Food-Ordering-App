package com.example.myapplication.Classes;
import  com.example.myapplication.Database.database;

public class admin extends person {
    String resturant;

    public admin(String email,String username,String password,String resturant){
        super(username,password,email);
        this.resturant = resturant;

    }
    public static boolean Login(String email,String password){
       admin res =  database.adminSearch(email,password);
       if(res == null) return false;
       return true;

    }


}
