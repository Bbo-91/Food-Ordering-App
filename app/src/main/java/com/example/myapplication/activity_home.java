package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.fileParsers.adminRead;
import com.example.myapplication.fileParsers.dishesRead;
import com.example.myapplication.fileParsers.usersRead;

public class activity_home extends AppCompatActivity {

    Button start;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        usersRead.copy(this);
        usersRead.parser(this);
        adminRead.parser(this);
        dishesRead.parser(this);


        start = findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_home.this, UserActivity.class);
                startActivity(intent);


            }
        });


    }
}
