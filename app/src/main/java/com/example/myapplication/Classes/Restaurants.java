package com.example.myapplication.Classes;

import com.example.myapplication.R;

import java.util.ArrayList;

public class Restaurants {
    public String name;
    public String address;
    public int number;
    public boolean[] cuisineCheck= new boolean[5];
    public int image;

    public int getImage() {
        return image;
    }
    public Restaurants(String name, String address, int number, int image) {
        this.name = name;
        this.address = address;
        this.number = number;
        this.image = image;
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

    public static ArrayList<Restaurants> getRestaurants(){
        ArrayList<Restaurants> restaurants = new ArrayList<Restaurants>();
        restaurants.add(new Restaurants("arabiata","El Rehab Food court",12345, R.drawable.arabiata));
        restaurants.add(new Restaurants("El Tahrir","Nasr City",12222,R.drawable.koshary_el_tahrir));

        return restaurants;
    }
}
