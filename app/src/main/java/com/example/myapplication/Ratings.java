package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import java.util.Arrays;

public class Ratings extends AppCompatActivity implements RatingDialogListener{

    private Button submitBtn;
    private EditText userComment;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);

        submitBtn = findViewById(R.id.submitBtn);
        userComment = findViewById(R.id.userComment);
        ratingBar = findViewById(R.id.ratingBar);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }


        });
    }
//        private void showRatingDialog(){
//            new appRatingDialog.Builder()
//                    .setPositiveButtonText("Submit")
//                    .setNegativeButtonText("Cancel")
//                    .setNoteDescriptions(Arrays.asList("Very Bad", "Not good", "Quite Ok", "Very Good", "Excellent"))
//                    .setDefaultRating(0)
//                    .setTitle("Rate this Restaurant")
//                    .setDescription("Please select some stars and give your feedback")
//                    .setHint("Please write your feedback here ...")
//                    .create(Ratings.this)
//                    .show();
//        }
    }

