package com.example.myapplication;

import java.util.ArrayList;

public class database {
    private static ArrayList<user> userList = new ArrayList<>();
    private static ArrayList<admin> adminList = new ArrayList<>();
    public database(){};
    public static String addUser(user User){
//        check if user already exist
        for(user u :userList){
            if(u.email.equals(User.email)){
                return "duplicate user";
            }

        }
        userList.add(User);
        return "user added";

    }
    public static user userSearch(String email,String password){
        for(user u :userList){
            if(u.email.equals(email) && u.password.equals(password)){
                return u;
            }

        }
        return null;
    }
    public static String addAdmin(admin Admin){
//        check if admin already exist
        for(admin a :adminList){
            if(a.email.equals(Admin.email)){
                return "duplicate admin";
            }

        }
         for(user u :userList){
            if(u.email.equals(Admin.email)){
                return "email isn't available choose another";
            }

        }
        adminList.add(Admin);
        return "admin created";

    }
    public static admin adminSearch(String email,String password){
        for(admin a :adminList){
            if(a.email.equals(email) && a.password.equals(password)){
                return a;
            }

        }
        return null;
    }
}
