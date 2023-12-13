package com.example.myapplication;

import static android.app.PendingIntent.getActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class activity_add_dish extends AppCompatActivity {
    public Button add=findViewById(R.id.button_add_dish);
   public EditText nameofdish =findViewById(R.id.editTextText);
    public EditText description =findViewById(R.id.editTextTextMultiLine);
    public EditText initprice =findViewById(R.id.editTextNumberDecimal);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.add_new_dish);
       add.setOnClickListener(new View.OnClickListener(){

           @Override
           public void onClick(View v) {
               try {
                   Intent intent = new Intent(activity_add_dish.this, AdminEditFragment.class);
                 Toast.makeText(activity_add_dish.this, "Dish is added", Toast.LENGTH_SHORT).show();







                  startActivity(intent);
                   Log.d("YourTag", "fun is working");
               } catch (Exception e) {
                   e.printStackTrace();
                   Log.e("YourTag", "Error in onClick", e);
                   Toast.makeText(activity_add_dish.this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
               }
           }
       });

    }
}
