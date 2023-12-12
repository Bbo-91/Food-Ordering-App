package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Database.database;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.Classes.Dishes;

import java.util.ArrayList;

public class activity_customize extends AppCompatActivity {

    ArrayList<Dishes> dishes = database.dishes;

    TextView name, description, count;
    Button increment, decrement, addSpicy, addExtra, addToCart;
    int numberOfDishes = 0;
    Bundle extras;

    @SuppressLint({"MissingInflatedId", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);

        // Transfer name and description from menu
        name = findViewById(R.id.nameofdishe);
        description = findViewById(R.id.discritionofdishe);

        extras = getIntent().getExtras();
        int index = extras.getInt("index");
        if (extras != null) {
            name.setText(dishes.get(index).getName());
            description.setText(dishes.get(index).getDescription());
        }

        // Number of dishes
        increment = findViewById(R.id.incrememnt);
        decrement = findViewById(R.id.decrement);
        count = findViewById(R.id.count);

        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberOfDishes < 10) {
                    numberOfDishes++;
                }
                updateCount();
            }
        });

        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberOfDishes > 1) {
                    numberOfDishes--;
                }
                updateCount();
            }
        });

        // Add spicy
        addSpicy = findViewById(R.id.spicy);
        addSpicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSpicy.setBackgroundColor(Color.RED);
                int index = extras.getInt("index");
                dishes.get(index).spicy = true;
            }
        });

        // Add extra
        addExtra = findViewById(R.id.add);
        addExtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addExtra.setBackgroundColor(Color.RED);
                int index = extras.getInt("index");
                dishes.get(index).setExtra(10f);
            }
        });

        // Move to cart
        addToCart = findViewById(R.id.cart);
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dishes.get(index).setNoOfDishes(numberOfDishes);
                AddToCart(index);
            }
        });
    }

    private void updateCount() {
        count.setText(String.valueOf(numberOfDishes));
    }

    private void AddToCart(int index) {
        Intent intent = new Intent(this, CartActivity.class);
        intent.putExtra("index", index);
        startActivity(intent);

    }



}
