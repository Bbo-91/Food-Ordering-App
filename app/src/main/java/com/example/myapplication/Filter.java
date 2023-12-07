package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;

public class Filter extends AppCompatActivity {

    private RadioGroup MealGroup;
    private RadioGroup CuisineGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter_dishes);
        MealGroup = findViewById(R.id.radioGroupMeal);
        CuisineGroup = findViewById(R.id.radioGroupCuisine);

    }

}