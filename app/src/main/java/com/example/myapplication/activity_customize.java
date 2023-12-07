package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class activity_customize extends AppCompatActivity {

      TextView name , discription,count;
      Button increment , decrement,addspicy,addextra,addtocart;
     int numberofdishes =0;
     Bundle extras;

    @SuppressLint({"MissingInflatedId", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);

        //transfer name and discription from menu
        name = findViewById(R.id.nameofdishe);
        discription = findViewById(R.id.discritionofdishe);

        extras = getIntent().getExtras();
        if (extras != null) {
            name.setText(extras.getString("name"));
            discription.setText(extras.getString("discription"));

        }
        //number of dishes
        increment = findViewById(R.id.incrememnt);
        decrement = findViewById(R.id.decrement);
        count = (TextView) findViewById(R.id.count);

        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberofdishes >= 10) {
                    numberofdishes = 10;
                } else {
                    numberofdishes++;
                }
                count.setText("" + numberofdishes);

            }
        });

        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberofdishes <= 0) {
                    numberofdishes = 0;
                } else {
                    numberofdishes--;
                }
                count.setText("" + numberofdishes);

            }
        });

        addspicy = findViewById(R.id.spicy);
        addextra = findViewById(R.id.add);


        //add spicy
        addspicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addspicy.setBackgroundColor(Color.RED);
            }
        });

        //add extra
        addextra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addextra.setBackgroundColor(Color.RED);
            }
        });

        //move to cart
        addtocart = findViewById(R.id.cart);
        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(activity_customize.this,CartFragment.class);
               startActivity(intent);
            }
        });
    }

}