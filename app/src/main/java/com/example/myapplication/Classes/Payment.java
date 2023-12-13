package com.example.myapplication.Classes;
public class Payment {
    private int userId;
    private int dishId;
    private int uniqueId;

    public Payment(int userId, int dishId, int uniqueId) {
        this.userId = userId;
        this.dishId = dishId;
        this.uniqueId = uniqueId;
    }
}
