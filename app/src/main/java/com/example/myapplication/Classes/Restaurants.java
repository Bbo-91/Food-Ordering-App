package com.example.myapplication.Classes;

import com.example.myapplication.R;

import java.util.ArrayList;

public class Restaurants {
    public String name;
    public String address;
    public int number;
    public int image;

    public Menu menu;

    public int getImage() {
        return image;
    }
    public Restaurants(String name, String address, int number, int image,Menu menu) {
        this.name = name;
        this.address = address;
        this.number = number;
        this.image = image;
        this.menu = menu;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
   }


}
