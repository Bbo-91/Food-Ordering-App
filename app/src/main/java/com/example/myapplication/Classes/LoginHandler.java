package com.example.myapplication.Classes;

public class LoginHandler {
    public static admin ADMIN=null;
    public static user USER=null;
    public static boolean isLoggedIn(){
        return ADMIN!=null || USER!=null;
    }
    public static void LOGIN(user u){
        USER = u;
    }
    public static void LOGIN(admin a){
        ADMIN = a;
    }
    public static boolean isAdmin(){
        return ADMIN!=null;
    }


}
