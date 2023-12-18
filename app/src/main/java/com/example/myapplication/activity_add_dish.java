package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.Classes.Dishes;
import com.example.myapplication.Classes.admin;
import com.example.myapplication.Database.database;
import com.example.myapplication.fileParsers.dishesRead;
import com.example.myapplication.fileParsers.dishesWrite;

import java.util.ArrayList;
import java.util.Random;

public class activity_add_dish extends AppCompatActivity {
    public Button add;
    public EditText nameOfDish;
    public EditText description;
    public EditText initPrice;
    Random random = new Random();
    ArrayList<Integer> dishesId = new ArrayList<>();
    ArrayList<admin> admins = database.adminList;
    

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_dish);

        // Retrieve the index from the intent
        int index = getIntent().getIntExtra("index", -1);

        add = findViewById(R.id.button_add_dish);
        nameOfDish = findViewById(R.id.editTextText);
        description = findViewById(R.id.editTextTextMultiLine);
        initPrice = findViewById(R.id.editTextNumberDecimal);
        RadioGroup cuisineGroup = findViewById(R.id.radioGroupCuisine);
        RadioGroup mealGroup = findViewById(R.id.radioGroupMeal);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String stringValue = initPrice.getText().toString();
                    float floatValue = Float.parseFloat(stringValue);

                    Dishes.cuisines selectedCuisine = getCuisineEnum(cuisineGroup);
                    Dishes.categories selectedMeal = getMealEnum(mealGroup);

                    if (index >= 0 && index < admins.size()) {
                        admin currentAdmin = admins.get(index);

                        Dishes newDish = new Dishes(nameOfDish.getText().toString(), description.getText().toString(), floatValue, selectedCuisine, selectedMeal, currentAdmin.getResturant());
                        dishesWrite.addDish(getApplicationContext(),nameOfDish.getText().toString(), description.getText().toString(),Float.toString(floatValue),currentAdmin.getResturant(),selectedCuisine.toString(), selectedMeal.toString(), Integer.toString(newDish.getId()) );
                        database.addDish(newDish);

                        Toast.makeText(activity_add_dish.this, "Dish is added", Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(activity_add_dish.this,AdminActivity.class);
                        intent.putExtra("index",index);
                        startActivity(intent);



                    } else {
                        Toast.makeText(activity_add_dish.this, "Invalid admin index", Toast.LENGTH_SHORT).show();
                    }

            }
        });
    }

    private Dishes.cuisines getCuisineEnum(RadioGroup radioGroup) {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedId);
        return Dishes.cuisines.valueOf(radioButton.getTag().toString());
    }
    private Dishes.categories getMealEnum(RadioGroup radioGroup) {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedId);
        return Dishes.categories.valueOf(radioButton.getTag().toString());
    }
}
