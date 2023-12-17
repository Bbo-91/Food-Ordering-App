package com.example.myapplication.Classes;
public class Payment {
    private int userId;
    private int dishId;
    private int uniqueId;

    private float Rating;

    public Payment(int userId, int dishId, int uniqueId) {
        this.userId = userId;
        this.dishId = dishId;
        this.uniqueId = uniqueId;
    }

    public int getUserId() {
        return userId;
    }

    public int getDishId() {
        return dishId;
    }

    public int getUniqueId() {
        return uniqueId;
    }

    public float getRating() {
        return Rating;
    }

    public void setRating(float rating) {
        Rating = rating;
    }
}
