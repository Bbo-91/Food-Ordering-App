package com.example.myapplication.Classes;

import android.health.connect.datatypes.StepsCadenceRecord;

import java.util.ArrayList;

public class Dishes {
    public String name;
    protected String description;
    protected float initPrice;
    public enum cuisines{
        ITALIC,
        MEXICAN,
        RUSSIAN
    }
    public enum categories{
        BREAKFAST,
        DINNER,
        LAUNCH
    }
    public cuisines cuisineType;
    public categories category;


    public Dishes(String name, String description, float initPrice,cuisines cuisineType,categories category) {
        this.name = name;
        this.description = description;
        this.initPrice = initPrice;
        this.category = category;
        this.cuisineType = cuisineType;

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

    protected float getPrice()
    {




        return initPrice;
    }


}