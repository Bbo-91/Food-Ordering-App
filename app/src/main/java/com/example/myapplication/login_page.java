package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class login_page extends AppCompatActivity implements View.OnClickListener {
    EditText emailEdit ,passwordEdit;
    TextView signupLink;
    Button btn;
    public void onClick(View v){
        if(v.getId()== R.id.buttonLogIn){
            Login();
        }else if(v.getId()==R.id.signupLink){
            Intent intent = new Intent(login_page.this, MainActivity.class);
            startActivity(intent);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        emailEdit = findViewById(R.id.editTextEmail);
        passwordEdit = findViewById(R.id.editTextPassword);
        btn = findViewById(R.id.buttonLogIn);
        btn.setOnClickListener(this);
        signupLink = findViewById(R.id.signupLink);
        signupLink.setOnClickListener(this);

    }
    public void Login(){
        String email = emailEdit.getText().toString();
        String password = passwordEdit.getText().toString();
        View parentLayout = findViewById(android.R.id.content);

        if(password.isEmpty() || email.isEmpty()){
            Snackbar.make(parentLayout, "Please fill in all fields", Snackbar.LENGTH_SHORT).show();
        }
        else{
            if(admin.Login(email,password)){
                Snackbar.make(parentLayout, "access granted to admin", Snackbar.LENGTH_SHORT).show();


            }
            else{
                if(user.Login(email,password)){
                    Snackbar.make(parentLayout, "access granted to user", Snackbar.LENGTH_SHORT).show();
                    Intent intent = new Intent(login_page.this, home.class);
                    startActivity(intent);

                }else{
                    Snackbar.make(parentLayout, "invalid credintials", Snackbar.LENGTH_SHORT).show();

                }
            }
        }

    }
}
