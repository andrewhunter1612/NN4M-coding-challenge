package com.example.nn4mchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MoreDetails extends AppCompatActivity {

    private ImageView detailsImageView;
    private TextView detailsNameTextView, detailsPriceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_details);

        detailsImageView = findViewById(R.id.detailsImageView);
        detailsNameTextView = findViewById(R.id.detailsNameTextView);
        detailsPriceTextView = findViewById(R.id.detailsPriceTextView);

    }
}