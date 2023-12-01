package com.example.myapplication.Classes;

import java.util.ArrayList;

public class Restaurants {
    public String name;
    public String address;
//    public int number;
//    public boolean[] cuisineCheck= new boolean[5];
//    public ArrayList<Dishes> dishes = new ArrayList<Dishes>();
//    public int image;
//
//    public int getImage() {
//        return image;
//    }
    public Restaurants(String name, String address) {
        this.name = name;
        this.address = address;
//        this.number = number;
//        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    public int getNumber() {
//        return number;
//    }
//
//    public void setNumber(int number) {
//        this.number = number;
//    }
}
