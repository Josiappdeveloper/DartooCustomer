package com.birhman.grocery.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.birhman.grocery.R;
import com.birhman.grocery.activity.BaseActivity;
import com.birhman.grocery.activity.ProductActivity;
import com.birhman.grocery.activity.ProductViewActivity;
import com.birhman.grocery.activity.StoreViewActivity;
import com.birhman.grocery.interfaces.AddorRemoveCallbacks;
import com.birhman.grocery.model.Cart;
import com.birhman.grocery.model.Product;
import com.birhman.grocery.model.StoreModel;
import com.birhman.grocery.util.localstorage.LocalStorage;
import com.google.gson.Gson;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder> {
    List<StoreModel> productList;
    Context context;
    LocalStorage localStorage;
    Gson gson;
    String id;

    public StoreAdapter(List<StoreModel> productList, Context context, String id) {
        this.productList = productList;
        this.context = context;
        this.id = id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_store, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        final StoreModel product = productList.get(position);
        localStorage = new LocalStorage(context);
        gson = new Gson();
        holder.title.setText(product.getTitle());
        holder.distance.setText(product.getDistance());
        holder.txtTime.setText(product.getTimes());
        holder.txtRating.setText(product.getRating());
        Picasso.get()
                .load(product.getImage())
                .into(holder.imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        holder.progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Exception e) {
                        Log.d("Error : ", e.getMessage());
                    }
                });

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, StoreViewActivity.class);
                intent.putExtra("id", product.getId());
                intent.putExtra("title", product.getTitle());
                intent.putExtra("image", product.getImage());
                intent.putExtra("distance", product.getDistance());
                intent.putExtra("time", product.getTimes());
                intent.putExtra("storeType", id);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title, distance, txtTime, txtRating;
        ProgressBar progressBar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.product_image);
            title = itemView.findViewById(R.id.product_title);
            progressBar = itemView.findViewById(R.id.progressbar);
            distance = itemView.findViewById(R.id.product_distance);
            txtTime = itemView.findViewById(R.id.product_time);
            txtRating = itemView.findViewById(R.id.product_rating);
        }
    }
}
