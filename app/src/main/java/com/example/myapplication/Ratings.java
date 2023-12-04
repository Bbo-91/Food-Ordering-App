package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Arrays;

public class Ratings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);
    }
//        private void showDialog() {
//            new AppRatingDialog.Builder()
//                    .setPositiveButtonText("Submit")
//                    .setNegativeButtonText("Cancel")
//                    .setNoteDescriptions(Arrays.asList("Very Bad", "Not good", "Quite Ok", "Very Good", "Excellent"))
//                    .setDefaultRating(0)
//                    .setTitle("Rate this food")
//                    .setDescription("Please select some stars and give your feedback")
//                    .setHint("Please write your feedback here ...")
//                    .create(Ratings.this)
//                    .show();
//
//        }
}