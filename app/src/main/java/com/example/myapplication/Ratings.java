package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.myapplication.Classes.Payment;
import com.example.myapplication.Database.database;

import java.util.ArrayList;
import java.util.Arrays;

public class Ratings extends AppCompatActivity{

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
        int userId = extras.getInt("UserId");

        submitBtn = findViewById(R.id.submitBtn);
        ratingBar = findViewById(R.id.ratingBar);


        payments.get(Payment_index).setRating(ratingBar.getRating());

        submitBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Ratings.this,UserActivity.class);
                intent.putExtra("UserId",userId);
                startActivity(intent);
            }
        });



    }




}

