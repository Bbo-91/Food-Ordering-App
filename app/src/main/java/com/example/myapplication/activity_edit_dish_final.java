//package com.example.myapplication;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.RadioGroup;
//import android.widget.TextView;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.myapplication.Classes.admin;
//import com.example.myapplication.Database.database;
//
//import java.util.ArrayList;
//import java.util.Random;
//
//public class activity_edit_dish_final extends AppCompatActivity {
//
//    public Button edit;
//    public TextView nameOfDish;
//    public TextView description;
//    public EditText initPrice;
//    public TextView category;
//    public TextView cuisineType;
//    Random random = new Random();
//    ArrayList<Integer> dishesId = new ArrayList<>();
//    ArrayList<admin> admins = database.adminList;
//
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.edit_dish_f);
//
//        // Retrieve the index from the intent
//        int index = getIntent().getIntExtra("index", -1);
//
//        edit = findViewById(R.id.button_add_dish);
//        nameOfDish = findViewById(R.id.editTextText);
//        description = findViewById(R.id.editTextTextMultiLine);
//        initPrice = findViewById(R.id.editTextNumberDecimal);
//        cuisineType = findViewById(R.id.radioGroupCuisine);
//         category = findViewById(R.id.radioGroupMeal);
//
//        edit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String stringValue = initPrice.getText().toString();
//                float floatValue = Float.parseFloat(stringValue);
//
//                if (index >= 0 && index < admins.size()) {
//                    admin currentAdmin = admins.get(index);
//                }
//            }
//
//
//        }
//    }
