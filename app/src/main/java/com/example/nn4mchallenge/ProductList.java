package com.example.nn4mchallenge;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ProductList {

    @SerializedName("Products")
    private ArrayList<Product> productArrayList;

    public ProductList() {
        this.productArrayList = new ArrayList<>();
    }

    public ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }

    public void setProductArrayList(ArrayList<Product> productArrayList) {
        this.productArrayList = productArrayList;
    }
}
