package com.example.myapplication.Classes;

public class Ratings {
    private int userID; //key for data
    private int foodID;
    private float ratingValue;

    public Ratings(int userID, int foodID, float ratingValue) {
        this.userID = userID;
        this.foodID = foodID;
        this.ratingValue = ratingValue;
    }

    public int getUserPhone() {
        return userID;
    }

    public void setUserPhone(int userID) {
        this.userID = userID;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public float getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(float ratingValue) {
        this.ratingValue = ratingValue;
    }

}
