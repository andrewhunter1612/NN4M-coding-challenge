package com.example.nn4mchallenge;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.http.Url;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductViewHolder> {

    private List<Product> productList;
    private ProductListAdapter.OnItemClickListener listener;

    public ProductListAdapter() {
        this.productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_card, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.itemPriceTextView.setText(String.valueOf(productList.get(position).getPrice()));
        holder.itemNameTextView.setText(productList.get(position).getName());



//        holder.itemImageView.setImageURI(Uri.parse("http://riverisland.scene7.com/is/image/RiverIsland/" +
//                productList.get(position).getProdid() +
//                "_main"));

        URL url = null;
        try {
            url = new URL("http://image10.bizrate-images.com/resize?sq=60&uid=2216744464");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            holder.itemImageView.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(ProductListAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        private TextView itemNameTextView, itemPriceTextView;
        private ImageView itemImageView;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImageView = itemView.findViewById(R.id.itemImageView);
            itemNameTextView = itemView.findViewById(R.id.itemNameTextView);
            itemPriceTextView = itemView.findViewById(R.id.itemPriceTextView);
        }
    }
}
