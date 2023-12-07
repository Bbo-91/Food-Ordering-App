package com.example.myapplication.Classes;

import android.health.connect.datatypes.StepsCadenceRecord;

import java.util.ArrayList;

public class Dishes {
    protected String name;
    protected String description;
    protected float initPrice;

    String restaurantName;
    protected float[] customPrice= new float[3];
    protected boolean[] customPriceBool= new boolean[3];

    public Dishes(String name, String description, float initPrice, String restaurantName) {
        this.name = name;
        this.description = description;
        this.initPrice = initPrice;
        this.restaurantName = restaurantName;
    }

    public String getRestaurantName() {
        return restaurantName;
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

        float sum=this.initPrice;

        for (int i=0;i<3;i++)
        {

            if(this.customPriceBool[i])
            {
                sum += this.customPrice[i];
            }

        }

        return sum;
    }

    public static ArrayList<Dishes> getDishes(){
        ArrayList<Dishes> dishes = new ArrayList<>();
        dishes.add(new Dishes("Foul Sandwich","balady Bread with foul medames Sandwich", 5, "arabiata"));
        dishes.add(new Dishes("Foul Box","foul medames Box", 15, "arabiata"));
        dishes.add(new Dishes("Koshary Box","Large koshary Box", 25, "El Tahrir"));

        return dishes;
    }
}
