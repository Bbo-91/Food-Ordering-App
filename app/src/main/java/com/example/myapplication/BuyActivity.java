package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.Classes.Dishes;
import com.example.myapplication.Classes.user;
import com.example.myapplication.Database.database;

import java.util.ArrayList;

public class BuyActivity extends AppCompatActivity {

    ArrayList<Dishes> dishes = database.dishes;
    ArrayList<user> users= database.userList;
    Bundle extras;
    TextView noItem, itemName, isSpicy, withExtra, totalPrice, separator,uCity,uStreet;
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
            int userId = extras.getInt("UserId");
            int userIndex=findUserIndex(users,userId);
            itemName = findViewById(R.id.dishname);
            isSpicy = findViewById(R.id.IsSpicy);
            withExtra = findViewById(R.id.withExtra);
            totalPrice = findViewById(R.id.TotalPrice);
            separator = findViewById(R.id.separator);
            uCity = findViewById(R.id.userCity);
            uStreet = findViewById(R.id.userStreet);

            ConfirmOrderBtn=findViewById(R.id.Confirm);
            ConfirmOrderBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent updateData = new Intent(BuyActivity.this, AdminMonitorFragment.class);
                    Intent intent = new Intent(BuyActivity.this, PaymentActivity.class);
                    assert index >= 0;
                    updateData.putExtra("index", index);

                    intent.putExtra("index",index);
                    intent.putExtra("UserId",userId);
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
            uCity.setText(users.get(userIndex).getCity());
            uStreet.setText(users.get(userIndex).getStreet());

            separator.setText("----------------------------");
            totalPrice.setText(String.valueOf(dishes.get(index).getPrice()) + " L.E");
        }



    }
    public int findUserIndex(ArrayList<user> users,int userId){
        for(int i=0;i<users.size();i++){
            if(users.get(i).getId()==userId){
                return i;
            }
        }
        return -1;
    }
}