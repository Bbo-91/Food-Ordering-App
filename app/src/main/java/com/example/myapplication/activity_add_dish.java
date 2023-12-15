package com.example.myapplication;

import static android.app.PendingIntent.getActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Classes.*;
import com.example.myapplication.Database.*;


public class activity_add_dish extends AppCompatActivity {
    public Button add;
   public EditText nameofdish;
    public EditText description;
    public EditText initprice ;
    private RadioGroup MealGroup;
    private RadioGroup CuisineGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.add_new_dish);
        add=findViewById(R.id.button_add_dish);
        nameofdish =findViewById(R.id.editTextText);
        description =findViewById(R.id.editTextTextMultiLine);
        initprice =findViewById(R.id.editTextNumberDecimal);
        MealGroup = findViewById(R.id.radioGroupMeal);
        CuisineGroup = findViewById(R.id.radioGroupCuisine);

       add.setOnClickListener(new View.OnClickListener(){

           @Override
           public void onClick(View v) {
               try {

                 int index = getIntent().getIntExtra("index",-1);
                   String stringValue = initprice.getText().toString();
                   float floatValue = Float.parseFloat(stringValue);
                   Dishes.cuisines selectedCuisine = getCuisineEnum(CuisineGroup);
                   Dishes.categories selectedCategouries =getCategoriesEnum(MealGroup);


                   if (index >= 0 && index < database.adminList.size()) {
                       admin findadmin=database.adminList.get(index);


                       Dishes dish =new Dishes(nameofdish.getText().toString(),description.getText().toString(),floatValue,selectedCuisine,selectedCategouries,findadmin.getResturant());
                       database.addDish(dish);
                       Toast.makeText(activity_add_dish.this, "Dish is added \n click back to go to home screen", Toast.LENGTH_SHORT).show();



                   } else {
                       Toast.makeText(activity_add_dish.this, "Invalid admin index", Toast.LENGTH_SHORT).show();
                   }








                   Log.d("YourTag", "fun is working");
               } catch (Exception e) {
                   e.printStackTrace();
                   Log.e("YourTag", "Error in onClick", e);
                   Toast.makeText(activity_add_dish.this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
               }
           }
       });

    }
    private Dishes.cuisines getCuisineEnum(RadioGroup radioGroup) {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedId);
        return Dishes.cuisines.valueOf(radioButton.getTag().toString());
    }
    private Dishes.categories getCategoriesEnum(RadioGroup radioGroup) {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedId);
        return Dishes.categories.valueOf(radioButton.getTag().toString());
    }
}
