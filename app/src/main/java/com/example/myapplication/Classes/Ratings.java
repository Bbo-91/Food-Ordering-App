package com.example.myapplication.Classes;

public class Ratings {
    private String userPhone; //key for data
    private String foodID;
    private int ratingValue;
    private String comment;

    public Ratings() {
    }

    public Ratings(String userPhone, String foodID, int ratingValue, String comment) {
        this.userPhone = userPhone;
        this.foodID = foodID;
        this.ratingValue = ratingValue;
        this.comment = comment;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
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
