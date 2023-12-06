package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class Filter_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter_dishes);
        SeekBar seekBar = findViewById(R.id.seekbar_price);
        TextView currentPriceTextView = findViewById(R.id.text_current_price);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int currentProgress = 0;
            int minPrice = 30; // Minimum price

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentProgress = progress;
                int currentPrice = minPrice + (currentProgress * 10);
                currentPriceTextView.setText("Current Price: $" + currentPrice);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Not needed, but required to implement
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Not needed, but required to implement
            }
        });
    }

}