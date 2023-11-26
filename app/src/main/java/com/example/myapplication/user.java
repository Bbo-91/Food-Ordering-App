package com.example.myapplication;


public class user extends person{


    public String deliveryAddress;
    public user(String email,String username,String password){
        super(username,password,email);

    }

    public static boolean Login(String email,String password){
      user res = database.userSearch(email,password);
        if(res == null) return false;
        return true;

    }
    public String SignUP()
    {
        return database.addUser(this);
    }

}
