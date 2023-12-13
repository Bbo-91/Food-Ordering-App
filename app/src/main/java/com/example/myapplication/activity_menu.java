package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import com.example.myapplication.Database.database;
import com.example.myapplication.MenuFragment;
import com.example.myapplication.Classes.*;
import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

public class activity_menu extends AppCompatActivity implements RecyclerViewInterface {
    private RecyclerView recyclerView;
    View rootView;
    ArrayList<Dishes> dishes = new ArrayList<Dishes>();
    Button btn;
    SeekBar seekBar;
    MenuAdapter menuAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        RecyclerView recyclerView = findViewById(R.id.MenuView);

        Intent intent = getIntent();
        String restaurantName = intent.getStringExtra("restaurantName");
        String restaurantLocation = intent.getStringExtra("restaurantLocation");
        int restaurantImageResourceId = intent.getIntExtra("restaurantImage", 0);


        btn = findViewById(R.id.to_filter);
        btn.setOnClickListener(v -> openFilterDialog());

        ArrayList<Dishes> filteredDishes = getDishesForRestaurant(restaurantName);

        TextView nameTextView = findViewById(R.id.textView3);
        nameTextView.setText(restaurantName);

        ImageView restaurantImage = findViewById(R.id.imageViewMenu);
        restaurantImage.setImageResource(restaurantImageResourceId);


        menuAdapter = new MenuAdapter(this,filteredDishes,restaurantName,restaurantImageResourceId,this);

        recyclerView.setAdapter(menuAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private ArrayList<Dishes> getDishesForRestaurant(String restaurantName) {


        ArrayList<Dishes> filteredDishes = new ArrayList<>();

        // Iterate through all dishes and add only those for the selected restaurant
        for (Dishes dish : database.dishes) {
            if (dish.getRestaurantName().equals(restaurantName)) {
                filteredDishes.add(dish);
            }
        }

        return filteredDishes;
    }

private void openFilterDialog() {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Custom Dialog");

    // Inflate custom layout for the dialog
    View dialogView = getLayoutInflater().inflate(R.layout.filter_dishes, null);
    builder.setView(dialogView);

    // Find views in the dialog layout
    RadioGroup radioGroup1 = dialogView.findViewById(R.id.radioGroupMeal);
    RadioGroup radioGroup2 = dialogView.findViewById(R.id.radioGroupCuisine);
     seekBar = dialogView.findViewById(R.id.seekbar_price);
    TextView currentPriceTextView = dialogView.findViewById(R.id.text_current_price);

    // Find the "Apply" button in the dialog
    Button applyButton = dialogView.findViewById(R.id.button_apply);
    Button resetButton = dialogView.findViewById(R.id.button_reset);
    resetButton.setOnClickListener(view -> {
        radioGroup2.clearCheck();
        radioGroup1.clearCheck();
        seekBar.setProgress(0);


    });
    final int minValue = 30; // Minimum value of SeekBar
    final int maxValue = 500; // Maximum value of SeekBar
    final int seekBarMax = maxValue - minValue; // Range of SeekBar

    // Set the SeekBar progress to represent the minimum value (30)
    seekBar.setMax(seekBarMax);
    seekBar.setProgress(minValue);

    // Listener to update the TextView and handle SeekBar progress changes
    seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            int currentValue = progress; // Map SeekBar progress to actual values
            currentPriceTextView.setText("Current Price: $" + currentValue);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // Not needed, but required to implement
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // Not needed, but required to implement
        }
    });

    applyButton.setOnClickListener(view -> {
        int selectedRadioButtonId1 = radioGroup1.getCheckedRadioButtonId();
        int selectedRadioButtonId2 = radioGroup2.getCheckedRadioButtonId();

        String selectedRadioButton1Name = "";
        String selectedRadioButton2Name = "";

        if (selectedRadioButtonId1 != -1) {
            selectedRadioButton1Name = getResources().getResourceEntryName(selectedRadioButtonId1);
        }
        if (selectedRadioButtonId2 != -1) {
            selectedRadioButton2Name = getResources().getResourceEntryName(selectedRadioButtonId2);
        }

        int seekBarValue = seekBar.getProgress();

        ArrayList<Dishes> filteredDishes = new ArrayList<>();
        for (Dishes dish : dishes) {
            boolean meetsCriteria = true;

            if (!selectedRadioButton1Name.isEmpty() && !selectedRadioButton1Name.equals(dish.category.name())) {
                meetsCriteria = false;
            }
            if (!selectedRadioButton2Name.isEmpty() && !selectedRadioButton2Name.equals(dish.cuisineType.name())) {
                meetsCriteria = false;
            }
            if (dish.getInitPrice() > seekBarValue) {
                meetsCriteria = false;
            }

            if (meetsCriteria) {
                filteredDishes.add(dish);
            }
        }

        menuAdapter.updateData(filteredDishes);

        AlertDialog dialog = (AlertDialog) view.getTag();
        if (dialog != null) {
            dialog.dismiss();
        }
    });

    builder.setNegativeButton("Cancel", (dialogInterface, i) -> {
        // Handle Cancel button click if needed
    });

    AlertDialog dialog = builder.create();
    dialog.show();

    applyButton.setTag(dialog);
}






    @Override
    public void onClick(int pos) {
        if(LoginHandler.isLoggedIn() ){
            Intent intent = new Intent(activity_menu.this, activity_customize.class);
            ArrayList<Dishes> dishes = database.dishes;

            // Pass data of the selected dish to the next activity
            intent.putExtra("name", dishes.get(pos).getName());
            intent.putExtra("description", dishes.get(pos).getDescription());
            intent.putExtra("index", pos);



            startActivity(intent);

        }else{
            Intent intent = new Intent(activity_menu.this, login_page.class);
            startActivity(intent);

        }

    }

}