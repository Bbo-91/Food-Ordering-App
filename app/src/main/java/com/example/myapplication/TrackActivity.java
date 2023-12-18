package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TrackActivity extends AppCompatActivity {
    private TextView confirmed, preparing, onTheWay, arrived;
    private ImageView view1, view2, view3, view4;

    private Bundle extras;
    private int paymentIndex, userId,dishIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);

        extras = getIntent().getExtras();
        if (extras != null) {
            paymentIndex = extras.getInt("PaymentIndex");
            dishIndex = extras.getInt("index");
            userId = extras.getInt("UserId");
        }

        confirmed = findViewById(R.id.textView6);
        preparing = findViewById(R.id.textView7);
        onTheWay = findViewById(R.id.textView8);
        arrived = findViewById(R.id.textView9);
        view1 = findViewById(R.id.imageView1);
        view2 = findViewById(R.id.imageView2);
        view3 = findViewById(R.id.imageView3);
        view4 = findViewById(R.id.imageView4);

        showConfirmed();
    }

    private void showConfirmed() {
        confirmed.setText("Order Confirmed");
        setViewsInvisible(view1, view2, view3, view4);

        new Handler().postDelayed(this::showPreparing, 2000);
    }

    private void showPreparing() {
        preparing.setText("Order Is Getting Prepared");
        confirmed.setTextColor(getResources().getColor(R.color.light_grey));
        view1.setVisibility(View.VISIBLE);

        new Handler().postDelayed(this::showOnTheWay, 2000);
    }

    private void showOnTheWay() {
        onTheWay.setText("Order Is On The Way");
        preparing.setTextColor(getResources().getColor(R.color.light_grey));
        view2.setVisibility(View.VISIBLE);

        new Handler().postDelayed(this::showArrived, 2000);
    }

    private void showArrived() {
        arrived.setText("Order Has Arrived");
        onTheWay.setTextColor(getResources().getColor(R.color.light_grey));
        view3.setVisibility(View.VISIBLE);
        view4.setVisibility(View.VISIBLE);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(TrackActivity.this, RatingActivity.class);
            intent.putExtra("UserId", userId);
            intent.putExtra("index", dishIndex);
            intent.putExtra("PaymentIndex", paymentIndex);
            startActivity(intent);
            finish();
        }, 2000);
    }

    private void setViewsInvisible(View... views) {
        for (View view : views) {
            view.setVisibility(View.INVISIBLE);
        }
    }
}
