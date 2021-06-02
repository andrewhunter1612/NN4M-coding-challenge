package com.example.nn4mchallenge;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonApi {

    @GET
    Call<List<Product>> getAllProducts();

    @GET
    Call<Product> getProduct();
}
