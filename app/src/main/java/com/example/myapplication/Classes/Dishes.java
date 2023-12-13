package com.example.myapplication.Classes;

import android.health.connect.datatypes.StepsCadenceRecord;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Serializable;

import java.util.ArrayList;

public class Dishes implements Serializable  {
    private String name;
    private int id;
    private String description;
    protected float initPrice;
    String RestaurantName;
    public enum cuisines{
        ITALIAN,
        MEXICAN,
        RUSSIAN
    }
    public enum categories{
        BREAKFAST,
        DINNER,
        LUNCH
    }
    public cuisines cuisineType;
    public categories category;


    public Dishes(String name, String description, float initPrice,cuisines cuisineType,categories category, String restaurant) {
        this.name = name;
        this.description = description;
        this.initPrice = initPrice;
        this.category = category;
        this.cuisineType = cuisineType;
        this.RestaurantName = restaurant;
    }

    public String getRestaurantName() {
        return RestaurantName;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getInitPrice() {
        return initPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private float noOfDishes=1;
    private float extra=0;
    public boolean spicy=false;

    public float getNoOfDishes() {
        return noOfDishes;
    }

    public void setNoOfDishes(float noOfDishes) {
        this.noOfDishes = noOfDishes;
    }

    public float getExtra() {
        return extra;
    }

    public void setExtra(float extra) {
        this.extra = extra;
    }

    public float getPrice()
    {
        return noOfDishes*initPrice+extra;
    }

    public void setInitPrice(float initPrice) {
        this.initPrice = initPrice;
    }

}