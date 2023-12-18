package com.example.myapplication;

import com.example.myapplication.Classes.Dishes;
import com.example.myapplication.Classes.RemoveAdapter;
import com.example.myapplication.Classes.admin;
import com.example.myapplication.Database.database;

import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Classes.Dishes;
import com.example.myapplication.Classes.RemoveAdapter;
import com.example.myapplication.Classes.admin;
import com.example.myapplication.Database.database;

import java.util.ArrayList;


public class activity_edit_dish extends AppCompatActivity implements RecyclerViewInterface {
    ArrayList<admin> admins = database.adminList;
    ArrayList<Dishes> dishes = database.dishes;
    ArrayList <Dishes> resdishes = null;
    RemoveAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_dish);

        // Retrieve the index from the intent
        int index = getIntent().getIntExtra("index", -1);

        RecyclerView recyclerView= findViewById(R.id.recyclerViewedit);
        admin ad = admins.get(index);
        String resname = ad.getResturant();


        resdishes = new ArrayList<>();

        for (Dishes d : dishes) {
            if (d.getRestaurantName().equals(resname)) {
                resdishes.add(d);
            }
        }

        adapter = new RemoveAdapter(this, resdishes, resname, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    public void onClick(int pos) {

        int databasePos = -1;
        for (Dishes d:database.dishes) {
            if (resdishes.get(pos).getName().equals(d.getName()) && resdishes.get(pos).getRestaurantName().equals(d.getRestaurantName())){
                databasePos = pos;
                break;
            }
        }
        Intent intent = new Intent(activity_edit_dish.this, activity_edit_dish_final.class);

       intent.putExtra("indexofdish",databasePos);

        startActivity(intent);
    }

    @Override
    public void onlongclick(int pos) {


    }


}