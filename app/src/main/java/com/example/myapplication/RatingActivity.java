package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import com.example.myapplication.Classes.Dishes;
import com.example.myapplication.Classes.Payment;
import com.example.myapplication.Classes.Ratings;
import com.example.myapplication.Classes.Restaurants;
import com.example.myapplication.Database.database;

import java.util.ArrayList;

public class RatingActivity extends AppCompatActivity{

    ArrayList<Payment> payments= database.payments;
    Button submitBtn;
    RatingBar ratingBar;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);

        extras = getIntent().getExtras();
        int Payment_index = extras.getInt("PaymentIndex");
        int dishIndex = extras.getInt("index");
        int userId = extras.getInt("UserId");

        submitBtn = findViewById(R.id.submitBtn);
        ratingBar = findViewById(R.id.ratingBar);


        submitBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                payments.get(Payment_index).setRating(ratingBar.getRating());
                database.ratings.add(new Ratings(userId,payments.get(Payment_index).getDishId(),ratingBar.getRating()));
                database.dishes.get(dishIndex).setRating(database.assignRatingDish(payments.get(Payment_index).getDishId()));
                //dish.setRating(database.assignRatingDish(payments.get(Payment_index).getDishId()));
                Restaurants restaurant = database.searchRestaurant(database.dishes.get(dishIndex).getRestaurantName());
                restaurant.setRate(database.AssignResturantRate(restaurant.getName()));
                Intent intent=new Intent(RatingActivity.this,UserActivity.class);
                intent.putExtra("UserId",userId);
                startActivity(intent);
            }
        });
    }




}

