package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.Classes.Dishes;
import com.example.myapplication.Classes.admin;
import com.example.myapplication.Database.database;
import com.example.myapplication.fileParsers.dishesWrite;

import java.util.ArrayList;
import java.util.Random;

public class activity_edit_dish_final extends AppCompatActivity {

    public Button edit;
    public TextView nameOfDish;
    public TextView description;
    public EditText initPrice;
    public TextView category;
    public TextView cuisineType;
    Random random = new Random();

   // ArrayList<Dishes> dishes = database.dishes;
    ArrayList<admin> admins = database.adminList;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_dish_f);


        // Retrieve the index from the intent
        int index = getIntent().getIntExtra("index", -1);
        int dish_index=getIntent().getIntExtra("indexofdish",-1);

        edit = findViewById(R.id.button_add_dish);
        nameOfDish = findViewById(R.id.editTextText);
        description = findViewById(R.id.editTextTextMultiLine);
        initPrice = findViewById(R.id.editTextNumberDecimal);
        cuisineType = findViewById(R.id.radioGroupCuisine);
        category = findViewById(R.id.radioGroupMeal);

        nameOfDish.setText(database.dishes.get(dish_index).getName());
        description.setText(database.dishes.get(dish_index).getDescription());
        cuisineType.setText(database.dishes.get(dish_index).cuisineType.toString());
        category.setText(database.dishes.get(dish_index).category.toString());

        String price=Float.toString(database.dishes.get(dish_index).getInitPrice());
        initPrice.setText(price);
        Log.d("DebugTag", "Dishes size: " + database.dishes.size());
        Log.d("DebugTag", "Index: " + index + ", Dish Index: " + dish_index);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Get the string representation of the EditText and then parse it
                    String stringValue = initPrice.getText().toString();
                    float floatValue = Float.parseFloat(stringValue);

                    if (dish_index >= 0 && dish_index < database.dishes.size() ) {

                        database.dishes.get(dish_index).setInitPrice(floatValue);
                        dishesWrite.editDishPrice(getApplicationContext(),Integer.toString(database.dishes.get(dish_index).getId()),stringValue);

                        Toast.makeText(activity_edit_dish_final.this, "price is changed", Toast.LENGTH_SHORT).show();
                        // Assuming you are in an activity
                    Intent intent =new Intent(activity_edit_dish_final.this,AdminActivity.class);
                    intent.putExtra("index",index);
                    startActivity(intent);

                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    Toast.makeText(activity_edit_dish_final.this, "Error: Invalid input for price", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}