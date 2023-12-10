package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.Classes.Dishes;
import com.example.myapplication.Database.database;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    ArrayList<Dishes> dishes = database.dishes;
    Bundle extras;

    TextView noItem, itemName, isSpicy, withExtra, totalPrice, separator;
    Button ConfirmOrderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        extras = getIntent().getExtras();
        if (extras == null) {
            noItem = findViewById(R.id.noItemsExist);
            noItem.setText("Empty Cart....!!");
        } else {
            int index = extras.getInt("index");
            itemName = findViewById(R.id.dishname);
            isSpicy = findViewById(R.id.IsSpicy);
            withExtra = findViewById(R.id.withExtra);
            totalPrice = findViewById(R.id.TotalPrice);
            separator = findViewById(R.id.separator);

            ConfirmOrderBtn=findViewById(R.id.Confirm);
            ConfirmOrderBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(CartActivity.this, PaymentActivity.class);
                    startActivity(intent);
                }
            });

            itemName.setText(dishes.get(index).getName());
            if (dishes.get(index).spicy == true) {
                isSpicy.setText("Spicy");
            }
            if (dishes.get(index).getExtra() == 10f) {
                withExtra.setText("Order Extra : " + String.valueOf(dishes.get(index).getExtra()) + " L.E");
            }

            separator.setText("----------------------------");
            totalPrice.setText(String.valueOf(dishes.get(index).getPrice()) + " L.E");

        }


    }
}