package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Classes.Dishes;
import com.example.myapplication.Classes.RemoveAdapter;
import com.example.myapplication.Classes.admin;
import com.example.myapplication.Database.database;

import java.util.ArrayList;

public class activity_remove_dish extends AppCompatActivity implements RecyclerViewInterface {
    ArrayList<admin> admins = database.adminList;
    ArrayList<Dishes> dishes = database.dishes;
    ArrayList <Dishes>resdishes = null;
    RemoveAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remove_dish);
        // Retrieve the index from the intent
        int index = getIntent().getIntExtra("index", -1);

        RecyclerView recyclerView= findViewById(R.id.removeRyclerview);
       admin ad= admins.get(index);
       String resname=ad.getResturant();


       for(Dishes d :dishes){
           if(d.getRestaurantName().equals(resname)){
               resdishes.add(d);
           }
       }
         adapter=new RemoveAdapter(this,resdishes,resname,this);




    }

    @Override
    public void onClick(int pos) {


    }

    @Override
    public void onlongclick(int pos) {
        resdishes.remove(pos);
        adapter.notifyItemRemoved(pos);

    }


}
