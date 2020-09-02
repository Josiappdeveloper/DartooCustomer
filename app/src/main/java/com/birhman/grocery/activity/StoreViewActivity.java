package com.birhman.grocery.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.birhman.grocery.R;
import com.birhman.grocery.adapter.ProductAdapter;
import com.birhman.grocery.adapter.StoreAdapter;
import com.birhman.grocery.adapter.StoreViewAdapter;
import com.birhman.grocery.helper.Converter;
import com.birhman.grocery.helper.Data;
import com.birhman.grocery.model.Category;

import java.util.List;

public class StoreViewActivity extends BaseActivity {
    Data data;
    StoreViewAdapter mAdapter;
    String strTitle, id;
    private RecyclerView recyclerView, recyclerViewProduct;
    private static int cart_count = 0;
    ProductAdapter adapter;
    Switch list_toggle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_view);

        strTitle = getIntent().getStringExtra("title");
        id = getIntent().getStringExtra("storeType");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            toolbar.setTitleMarginStart((int) getResources().getDimension(R.dimen._15sdp));
        }
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        cart_count = cartCount();


        recyclerView = findViewById(R.id.product_rv);
        recyclerViewProduct = findViewById(R.id.product);
        TextView txtDistance = findViewById(R.id.product_area);
        TextView txtTime = findViewById(R.id.product_time);

        TextView txtTitle = findViewById(R.id.product_distance);
        txtTitle.setText(strTitle);

        txtDistance.setText(getIntent().getStringExtra("distance"));
        txtTime.setText(getIntent().getStringExtra("time"));
        data = new Data();
        setUpRecyclerView();

        list_toggle=(Switch)findViewById(R.id.on_off_switch);
        list_toggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked) {
                list_toggle.setText("Veg");
                Log.d("You are :", "Checked");
            }
            else {
                list_toggle.setText("Non-veg");
                Log.d("You are :", " Not Checked");
            }
        });
    }

    private void setUpRecyclerView() {
        data = new Data();
        if (id.equals("1")){
            mAdapter = new StoreViewAdapter(data.getGroceryCatList(),
                    StoreViewActivity.this, id, strTitle,
                    getIntent().getStringExtra("distance"),
                    getIntent().getStringExtra("time"));
            recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(mAdapter);
        }else if (id.equals("2")){
            mAdapter = new StoreViewAdapter(data.getFoodCatList(),
                    StoreViewActivity.this, id, strTitle,
                    getIntent().getStringExtra("distance"),
                    getIntent().getStringExtra("time"));
            recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(mAdapter);
        }

        adapter = new ProductAdapter(data.getProductList(), StoreViewActivity.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewProduct.setLayoutManager(mLayoutManager);
        recyclerViewProduct.setItemAnimator(new DefaultItemAnimator());
        recyclerViewProduct.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cart_action:
                startActivity(new Intent(getApplicationContext(), CartActivity.class));
                return true;

            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem menuItem = menu.findItem(R.id.cart_action);
        menuItem.setIcon(Converter.convertLayoutToImage(StoreViewActivity.this, cart_count, R.drawable.ic_shopping_cart));
        return true;
    }

    @Override
    public void onAddProduct() {
        cart_count++;
        invalidateOptionsMenu();

    }

    @Override
    public void onRemoveProduct() {
        cart_count--;
        invalidateOptionsMenu();

    }
}
