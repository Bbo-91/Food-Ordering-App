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

        ArrayList<Dishes> filteredDishes = database.searchRestaurant(restaurantName).menu.dishesList;

        TextView nameTextView = findViewById(R.id.textView3);
        nameTextView.setText(restaurantName);

        ImageView restaurantImage = findViewById(R.id.imageViewMenu);
        restaurantImage.setImageResource(restaurantImageResourceId);


        MenuAdapter menuAdapter = new MenuAdapter(this,filteredDishes,restaurantName,restaurantImageResourceId,this);

        recyclerView.setAdapter(menuAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

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
    SeekBar seekBar = dialogView.findViewById(R.id.seekbar_price);
    TextView currentPriceTextView = dialogView.findViewById(R.id.text_current_price);

    // Find the "Apply" button in the dialog
    Button applyButton = dialogView.findViewById(R.id.button_apply);
    Button resetButton = dialogView.findViewById(R.id.button_reset);
    resetButton.setOnClickListener(view -> {
        radioGroup2.clearCheck();
        radioGroup1.clearCheck();
        seekBar.setProgress(30);


    });
    seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        int currentProgress = 0;
        int minPrice = 30; // Minimum price

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            currentProgress = progress;
            int currentPrice = minPrice + (currentProgress * 10);
            currentPriceTextView.setText("Current Price: $" + currentPrice);
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
        // Get the selected radio button from each RadioGroup
        int selectedRadioButtonId1 = radioGroup1.getCheckedRadioButtonId();
        int selectedRadioButtonId2 = radioGroup2.getCheckedRadioButtonId();

        // Find the SeekBar value
        int seekBarValue = seekBar.getProgress();

        // Convert radio button IDs to their respective values or perform actions based on selections
        // ...

        // Log or process the obtained values


        // Dismiss the dialog after processing the values
        // This closes the dialog after the "Apply" button is clicked
        AlertDialog dialog = (AlertDialog) view.getTag();
        if (dialog != null) {
            dialog.dismiss();
        }
    });

    // Handle the Cancel button inside the dialog if needed
    builder.setNegativeButton("Cancel", (dialogInterface, i) -> {
        // Handle Cancel button click if needed
    });

    // Create and show the dialog
    AlertDialog dialog = builder.create();
    dialog.show();

    // Set the dialog as a tag to the Apply button to retrieve it later
    applyButton.setTag(dialog);
}






    @Override
    public void onClick(int pos) {
//        Dishes selectedDish = dishes.get(pos); // Get the selected dish at 'pos'

        Intent intent = new Intent(activity_menu.this, activity_customize.class);
        ArrayList<Dishes> dishes = database.dishes;
        // Pass data of the selected dish to the next activity
        intent.putExtra("name", dishes.get(pos).getName());
        intent.putExtra("description", dishes.get(pos).getDescription());
        // Add any other data you want to pass

        startActivity(intent);
    }

}