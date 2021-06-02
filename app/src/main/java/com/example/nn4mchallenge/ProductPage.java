package com.example.nn4mchallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ProductPage extends AppCompatActivity {

    private RecyclerView productListRecyclerView;
    private ProductListAdapter productListAdapter;

    private ArrayList<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);

        productListRecyclerView = findViewById(R.id.productRecyclerView);

        productList = new ArrayList<>();

        //get products using retrofit2

        productListAdapter = new ProductListAdapter();
        productListAdapter.setProductList(productList);
        productListRecyclerView.setAdapter(productListAdapter);
        productListRecyclerView.setHasFixedSize(true);
        productListRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        //go to ProductPage when an item on the page is clicked
        productListAdapter.setOnItemClickListener(new ProductListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Intent itemClickIntent = new Intent(getApplicationContext(), MoreDetails.class);
                itemClickIntent.putExtra("item_clicked_position", position);
                startActivity(itemClickIntent);

            }
        });

    }
}