package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import java.util.Random;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.Classes.Restaurants;
//import com.example.myapplication.fileParsers.usersWrite;
import com.google.android.material.snackbar.Snackbar;

import  com.example.myapplication.Classes.user;
import  com.example.myapplication.Database.database;

import java.util.ArrayList;
import java.util.List;
import com.example.myapplication.Classes.*;

// karen
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Random random = new Random();
    EditText username,email,password,city,street;
    TextView loginLink;
    Button signUpBtn;
    @Override
    public void onClick(View v){
       if(v.getId() == R.id.buttonSignUp){
           signUp();
       }
       else if(v.getId() == R.id.loginLink){
           Intent intent = new Intent(MainActivity.this, login_page.class);
           startActivity(intent);
       }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.editTextUsername);
        password = findViewById(R.id.editTextPassword);
        email = findViewById(R.id.editTextEmail);
        city= findViewById(R.id.editCity);
        street= findViewById(R.id.editStreet);
        loginLink = findViewById(R.id.loginLink);
        signUpBtn = findViewById(R.id.buttonSignUp);
        signUpBtn.setOnClickListener( this);
        loginLink.setOnClickListener(this);
    }

    public void signUp(){
        String name = username.getText().toString();
        String pass = password.getText().toString();
        String emailString  = email.getText().toString();
        String City  = city.getText().toString();
        String Street  = street.getText().toString();
        View parentLayout = findViewById(android.R.id.content);

        if(name.isEmpty() || pass.isEmpty() || emailString.isEmpty()||City.isEmpty()||Street.isEmpty()){
            Snackbar.make(parentLayout, "Please fill in all fields", Snackbar.LENGTH_SHORT).show();
        }
        else if(!isValidEmail(emailString)){
            Snackbar.make(parentLayout, "Enter a valid email", Snackbar.LENGTH_SHORT).show();

        }
        else{
            user newUser = new user(emailString,name,pass,City,Street);
            int randomNumber = random.nextInt(301) + 200;
           String res =  newUser.SignUP();
           if(res.equals("duplicate user")){
               Snackbar.make(parentLayout, "there's a user with those credentials", Snackbar.LENGTH_SHORT).show();
           }

           else{
//               usersWrite.addUser(getApplicationContext(),emailString,name,pass);
               Intent intent = new Intent(MainActivity.this, login_page.class);
               startActivity(intent);
           }

        }


    }
    private boolean isValidEmail(String target) {
        return (!target.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
    }