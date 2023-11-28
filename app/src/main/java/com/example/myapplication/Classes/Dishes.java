package com.example.myapplication.Classes;

public class Dishes {
    protected String name;
    protected String description;
    protected float initPrice;
    protected float[] customPrice= new float[3];
    protected boolean[] customPriceBool= new boolean[3];

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
}
