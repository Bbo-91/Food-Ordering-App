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

import java.util.Arrays;

public class Ratings extends AppCompatActivity{

    private Button submitBtn;
    TextView test;
    private RatingBar ratingBar;

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

        //test.setText(String.valueOf(userId));

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

