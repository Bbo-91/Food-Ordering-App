package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.Classes.Dishes;
import com.example.myapplication.Classes.Payment;
import com.example.myapplication.Database.database;

import java.util.ArrayList;
import java.util.Random;

public class PaymentActivity extends AppCompatActivity {
    Random random=new Random();
    ArrayList<Dishes> dishes = database.dishes;
    ArrayList<Integer> uniqueIds = new ArrayList<>();
    ArrayList<Payment> payments=database.payments;
    Bundle extras;
    TextView dishName, price, separator, cardNameWarning, cardNumWarning, ExpiryWarning, cvcWarning;
    EditText cardName, cardNum, MMcardExpirydate, YYcardExpirydate, cardCVC;
    Button buy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        extras = getIntent().getExtras();
        int index = extras.getInt("index");
        int userId = extras.getInt("UserId");
        assert index >= 0;
        buy = findViewById(R.id.buy);
        dishName = findViewById(R.id.dishName);
        price = findViewById(R.id.dishPrice);
        cardName = findViewById(R.id.edCardName);
        cardNum = findViewById(R.id.cardNum);
        MMcardExpirydate = findViewById(R.id.MMExpiryDate);
        YYcardExpirydate = findViewById(R.id.YYexpiryDate);
        cardCVC = findViewById(R.id.CVC);
        cardNameWarning = findViewById(R.id.cardNameWarning);
        cvcWarning = findViewById(R.id.CVCWarning);
        cardNumWarning = findViewById(R.id.cardNumWarning);
        ExpiryWarning = findViewById(R.id.ExpiryWarning);
        separator = findViewById(R.id.separator);

        dishName.setText(dishes.get(index).getName());
        price.setText(String.valueOf(dishes.get(index).getPrice()));
        separator.setText("-----------------------------");

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkValidation()) {
                    Payment payment=new Payment(userId,dishes.get(index).getId(),GeneratedUniqueId());
                    payments.add(payment);
                    Intent intent = new Intent(PaymentActivity.this, TrackActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public boolean checkValidation() {
        clearWarnings(); // Clear previous warning messages

        String cardNameText = cardName.getText().toString().trim();
        String cardNumText = cardNum.getText().toString().trim();
        String mmDateText = MMcardExpirydate.getText().toString().trim();
        String yyDateText = YYcardExpirydate.getText().toString().trim();
        String cvcText = cardCVC.getText().toString().trim();

        // Name
        if (cardNameText.isEmpty()) {
            cardNameWarning.setText("Name is required");
            return false;
        } else if (!cardNameText.matches("[a-zA-Z ]+")) {
            cardNameWarning.setText("Name must contain only letters");
            return false;
        }

        // Card Number
        if (cardNumText.isEmpty()) {
            cardNumWarning.setText("Card Number is required");
            return false;
        } else if (cardNumText.length() != 16 || !cardNumText.matches("\\d+")) {
            cardNumWarning.setText("Card Number must be a 16-digit number");
            return false;
        }

        // Date
        if (mmDateText.length() != 2 || yyDateText.length() != 2 ||
                !mmDateText.matches("\\d{2}") || !yyDateText.matches("\\d{2}")) {
            ExpiryWarning.setText("Expiry date must be in MM YY format");
            return false;
        }

        // CVC
        if (cvcText.isEmpty()) {
            cvcWarning.setText("CVC is required");
            return false;
        } else if (cvcText.length() != 3 || !cvcText.matches("\\d+")) {
            cvcWarning.setText("CVC must be a 3-digit number");
            return false;
        }

        return true;
    }

    private void clearWarnings() {
        cardNameWarning.setText("");
        cardNumWarning.setText("");
        ExpiryWarning.setText("");
        cvcWarning.setText("");
    }
    public int GeneratedUniqueId() {
        // Random Id for every Payment process with range (600 to 800)
        int id = random.nextInt(601) + 200;

        if (uniqueIds == null) {
            uniqueIds.add(id);
            return id;
        } else {
            for (int i = 0; i < uniqueIds.size(); i++) {
                if (id == uniqueIds.get(i)) {
                    return GeneratedUniqueId(); // Return the result of the recursive call
                }
            }
            uniqueIds.add(id);
            return id;
        }
    }
}