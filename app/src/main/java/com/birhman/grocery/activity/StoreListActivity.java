package com.birhman.grocery.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.birhman.grocery.R;
import com.birhman.grocery.adapter.CategoryAdapter;
import com.birhman.grocery.adapter.ProductAdapter;
import com.birhman.grocery.adapter.StoreAdapter;
import com.birhman.grocery.helper.Converter;
import com.birhman.grocery.helper.Data;

public class StoreListActivity extends AppCompatActivity {
    Data data;
    StoreAdapter mAdapter;
    String strTitle, id;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_list);

        strTitle = getIntent().getStringExtra("title");
        id = getIntent().getStringExtra("id");

        recyclerView = findViewById(R.id.product_rv);
        ImageView imgBackArrow = findViewById(R.id.img_back_arrow);
        TextView txtTitle = findViewById(R.id.title);
        txtTitle.setText(strTitle);
        data = new Data();
        setUpRecyclerView();

        imgBackArrow.setOnClickListener(view -> onBackPressed());
    }

    private void setUpRecyclerView() {
        data = new Data();
        if (id.equals("1")){
            mAdapter = new StoreAdapter(data.getStoreList(), StoreListActivity.this, id);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(mAdapter);
        }else if (id.equals("2")){
            mAdapter = new StoreAdapter(data.getFoodStoreList(), StoreListActivity.this, id);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(mAdapter);
        }
    }
}
