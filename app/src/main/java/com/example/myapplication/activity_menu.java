package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.MenuFragment;
import com.example.myapplication.Classes.*;

import java.util.ArrayList;

public class activity_menu extends AppCompatActivity implements RecyclerViewInterface {
    private RecyclerView recyclerView;
    View rootView;
    ArrayList<Dishes> dishes = new ArrayList<Dishes>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        RecyclerView recyclerView = findViewById(R.id.MenuView);

        Intent intent = getIntent();
        String restaurantName = intent.getStringExtra("restaurantName");
        String restaurantLocation = intent.getStringExtra("restaurantLocation");
        int restaurantImageResourceId = intent.getIntExtra("restaurantImage", 0);


        dishes = Dishes.getDishes();

        ArrayList<Dishes> filteredDishes = getDishesForRestaurant(restaurantName);

        TextView nameTextView = findViewById(R.id.textView3);
        nameTextView.setText(restaurantName);

        ImageView restaurantImage = findViewById(R.id.imageViewMenu);
        restaurantImage.setImageResource(restaurantImageResourceId);


        MenuAdapter menuAdapter = new MenuAdapter(this,filteredDishes,restaurantName,restaurantImageResourceId,this);

        recyclerView.setAdapter(menuAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private ArrayList<Dishes> getDishesForRestaurant(String restaurantName) {


        ArrayList<Dishes> filteredDishes = new ArrayList<>();

        // Iterate through all dishes and add only those for the selected restaurant
        for (Dishes dish : dishes) {
            if (dish.getRestaurantName().equals(restaurantName)) {
                filteredDishes.add(dish);
            }
        }

        return filteredDishes;
    }


    @Override
    public void onClick(int pos) {
        Dishes selectedDishes = dishes.get(pos);

        Intent intent = new Intent(activity_menu.this, activity_customize.class);
        startActivity(intent);
    }

}