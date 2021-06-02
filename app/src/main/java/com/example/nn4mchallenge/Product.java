package com.example.nn4mchallenge;

import com.google.gson.annotations.SerializedName;

public class Product {

    private String name;

    @SerializedName("cost")
    private double price;

    @SerializedName("prodid")
    private String prodid;

    public Product(String name, double price, String imageUrl) {
        this.name = name;
        this.price = price;
        this.prodid = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProdid() {
        return prodid;
    }

    public void setProdid(String prodid) {
        this.prodid = prodid;
    }
}
