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

public class activity_menu extends AppCompatActivity {
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
        dishes.add(new Dishes("Foul Sandwich","balady Bread with foul medames Sandwich", 5, "arabiata"));
        dishes.add(new Dishes("Foul Box","foul medames Sandwich", 15, "arabiata"));
        dishes.add(new Dishes("Koshary Box","Large koshary Box", 25, "Koshary El Tahrir"));

        ArrayList<Dishes> filteredDishes = getDishesForRestaurant(restaurantName);

        MenuAdapter menuAdapter = new MenuAdapter(this,filteredDishes,restaurantName,restaurantImageResourceId);

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
    /*private void setUpMenu(){

    }*/
}