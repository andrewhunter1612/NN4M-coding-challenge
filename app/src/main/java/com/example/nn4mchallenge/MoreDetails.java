package com.example.nn4mchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MoreDetails extends AppCompatActivity {

    private ImageView detailsImageView;

    private ArrayList<Product> productArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_details);

        detailsImageView = findViewById(R.id.detailsImageView);

        Intent moreDetailsIntent = getIntent();
        int listPosition = moreDetailsIntent.getIntExtra("item_clicked_position", -1);
        String json = moreDetailsIntent.getStringExtra("product_list");
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Product>>() {}.getType();
        productArrayList = gson.fromJson(json, type);

        if (listPosition != -1){
            Picasso.get().load("http://riverisland.scene7.com/is/image/RiverIsland/" +
                    productArrayList.get(listPosition).getProdid() +
                    "_main").into(detailsImageView);
        }
    }
}