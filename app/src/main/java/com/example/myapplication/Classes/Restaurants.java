package com.example.myapplication.Classes;

import com.example.myapplication.R;

import java.util.ArrayList;

public class Restaurants {
    private String name;
    private String address;
    private int number;
    private int image;
    private int rate = 0;

    public Restaurants(String name, String address, int number, int image) {
        this.name = name;
        this.address = address;
        this.number = number;
        this.image = image;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
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

    public int getImage() {
        return image;
    }

    @Override
    public String toString() {
        return name + "," + address + "," + number + "," + image;
    }

    
}
