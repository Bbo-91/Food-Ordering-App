package com.example.myapplication.Classes;

public class Ratings {
    private int userID; //key for data
    private int foodID;
    private int ratingValue;
    private String comment;

    public Ratings() {
    }

    public Ratings(int userPhone, int foodID, int ratingValue, String comment) {
        this.userID = userPhone;
        this.foodID = foodID;
        this.ratingValue = ratingValue;
        this.comment = comment;
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

    public int getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(int ratingValue) {
        this.ratingValue = ratingValue;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
