package com.birhman.grocery.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.birhman.grocery.R;
import com.birhman.grocery.adapter.CategoryAdapter;
import com.birhman.grocery.adapter.NewProductAdapter;
import com.birhman.grocery.adapter.ProductAdapter;
import com.birhman.grocery.adapter.ProductViewPagerAdapter;
import com.birhman.grocery.helper.Converter;
import com.birhman.grocery.helper.Data;
import com.birhman.grocery.model.Category;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class ProductActivity extends BaseActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    String strTitle, strStoreType, storeName, storeTime, storeDistance;
    int no_of_categories = -1;
    Data data;
    List<Category> categoryList;
    private static int cart_count = 0;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        strTitle = getIntent().getStringExtra("title");
        strStoreType = getIntent().getStringExtra("storeType");
        storeName = getIntent().getStringExtra("storeName");
        storeTime = getIntent().getStringExtra("storeTime");
        storeDistance = getIntent().getStringExtra("storeDistance");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            toolbar.setTitleMarginStart((int) getResources().getDimension(R.dimen._15sdp));
        }
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        TextView txtTitle = findViewById(R.id.product_distance);
        TextView txtDistance = findViewById(R.id.product_area);
        TextView txtTime = findViewById(R.id.product_time);
        txtTitle.setText(storeName);
        txtDistance.setText(storeDistance);
        txtTime.setText(storeTime);

        /*getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#34495E")));
        changeActionBarTitle(getSupportActionBar());
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);*/

        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);

        data = new Data();
        cart_count = cartCount();
        categoryList = data.getFoodCategoryList();
        no_of_categories = categoryList.size();

        for (int i = 0; i < no_of_categories; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(categoryList.get(i).getTitle()));
        }

        ProductViewPagerAdapter adapter = new ProductViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void changeActionBarTitle(ActionBar actionBar) {
        // Create a LayoutParams for TextView
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, // Width of TextView
                RelativeLayout.LayoutParams.WRAP_CONTENT); // Height of TextView
        TextView tv = new TextView(getApplicationContext());
        // Apply the layout parameters to TextView widget
        tv.setLayoutParams(lp);
        tv.setTypeface(null, Typeface.BOLD);
        // Set text to display in TextView
        tv.setText(strTitle); // ActionBar title text
        tv.setTextSize(20);

        // Set the text color of TextView to red
        // This line change the ActionBar title text color
        tv.setTextColor(getResources().getColor(R.color.white));

        // Set the ActionBar display option
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        // Finally, set the newly created TextView as ActionBar custom view
        actionBar.setCustomView(tv);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            case R.id.cart_action:
                startActivity(new Intent(getApplicationContext(), CartActivity.class));
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
        menuItem.setIcon(Converter.convertLayoutToImage(ProductActivity.this, cart_count, R.drawable.ic_shopping_cart));
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
