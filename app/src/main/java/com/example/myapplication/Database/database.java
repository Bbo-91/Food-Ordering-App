package com.example.myapplication.Database;

import com.example.myapplication.Classes.Dishes;
import com.example.myapplication.Classes.Restaurants;
import  com.example.myapplication.Classes.user;
import  com.example.myapplication.Classes.admin;
import java.util.ArrayList;

public class database {
    private static ArrayList<user> userList = new ArrayList<>();
    public static ArrayList<admin> adminList = new ArrayList<>();
    public static ArrayList<Restaurants> restaurants = new ArrayList<>();

    public static ArrayList<Dishes> dishes = new ArrayList<>();


    public database(){};
    public static String addUser(user User){
//        check if user already exist
        for(user u :userList){
            if(u.getEmail().equals(User.getEmail())){
                return "duplicate user";
            }
        }
        userList.add(User);
        return "user added";

    }
    public static user userSearch(String email){
        user us = new user("a@a.a","a","123","a","a");
        userList.add(us);
        for(user u :userList){
            if(u.getEmail().equals(email)){
                return u;

            }

        }
        return null;
    }

    public static String addAdmin(admin Admin){

//        check if admin already exist
        for(admin a :adminList){
            if(a.getEmail().equals(Admin.getEmail())){
                return "duplicate admin";
            }

        }
         for(user u :userList){
            if(u.getEmail().equals(Admin.getEmail())){
                return "email isn't available choose another";
            }

        }
        adminList.add(Admin);
        return "admin created";

    }
    public static admin adminSearch(String email){
        admin new_admin =new admin("admin@gmail.com","admin","123","arabiata");
        adminList.add(new_admin);
        for(admin a :adminList){
            if(a.getEmail().equals(email) ){
                return a;
            }

        }
        return null;
    }
    public static Restaurants searchRestaurant(String restName){
        for(Restaurants rest:restaurants){
            if(rest.name.equals(restName)){
                return rest;
            }

        }
        return null;

    }
    public static Restaurants addRestaurent(Restaurants rest){
        for(Restaurants r:restaurants){
            if(r==rest) return null;
        }
        restaurants.add(rest);
        return rest;
    }
    public static Dishes searchDishes(String dishName){
        for(Dishes d:dishes){
            if(d.getName().equals(dishName)){
                return d;
            }

        }
        return null;

    }
    public static Dishes addDish(Dishes dish){
        for(Dishes d:dishes){
            if(d==dish) return null;
        }
        dishes.add(dish);
        return dish;
    }
}
