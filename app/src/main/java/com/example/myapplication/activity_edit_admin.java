/*
package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.SQLOutput;

public class activity_edit_admin  extends AppCompatActivity {
    public Button add;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_admin_edit);
        add=findViewById(R.id.button_add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {try {
                Intent intent = new Intent(activity_edit_admin.this, activity_add_dish.class);
                startActivity(intent);
                Log.d("YourTag", "fun is working");
            }catch (Exception e) {
                e.printStackTrace();
                Log.e("YourTag", "Error in onClick", e);
            }
            }
        });
    }
}

*/
