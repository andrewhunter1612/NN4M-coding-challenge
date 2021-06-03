package com.example.nn4mchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductPage extends AppCompatActivity {

    private static final String TAG = "ProductPage";

    private RecyclerView productListRecyclerView;
    private ProductListAdapter productListAdapter;

    private ArrayList<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);

        productListRecyclerView = findViewById(R.id.productRecyclerView);

        productList = new ArrayList<>();
        productListAdapter = new ProductListAdapter();


        //get data from the api
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://static-ri.ristack-3.nn4maws.net/v1/plp/en_gb/2506/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonApi jsonApi = retrofit.create(JsonApi.class);

        Call<ProductList> call = jsonApi.getAllProducts();

        call.enqueue(new Callback<ProductList>() {
            @Override
            public void onResponse(Call<ProductList> call, Response<ProductList> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "Response was unsuccessful. Error code is: " + response.code());
                    return;
                }

                productList.addAll(response.body().getProductArrayList());

                productListAdapter.setProductList(productList);
                productListRecyclerView.setAdapter(productListAdapter);
                productListRecyclerView.setHasFixedSize(true);
                productListRecyclerView.setLayoutManager(new LinearLayoutManager(ProductPage.this));
            }

            @Override
            public void onFailure(Call<ProductList> call, Throwable t) {
                Log.d(TAG, "Error: " + t.getMessage());
            }
        });

        //go to ProductPage when an item on the page is clicked
        productListAdapter.setOnItemClickListener(new ProductListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Gson gson = new Gson();
                String json = gson.toJson(productList);


                Intent itemClickIntent = new Intent(getApplicationContext(), MoreDetails.class);
                itemClickIntent.putExtra("item_clicked_position", position);
                itemClickIntent.putExtra("product_list", json);
                startActivity(itemClickIntent);
            }
        });

    }
}