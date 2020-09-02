package com.birhman.grocery.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.birhman.grocery.fragment.MoreFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.birhman.grocery.R;
import com.birhman.grocery.fragment.CategoryFragment;
import com.birhman.grocery.fragment.HomeFragment;
import com.birhman.grocery.fragment.MyOrderFragment;
import com.birhman.grocery.fragment.NewProductFragment;
import com.birhman.grocery.fragment.OffrersFragment;
import com.birhman.grocery.fragment.PopularProductFragment;
import com.birhman.grocery.fragment.ProfileFragment;
import com.birhman.grocery.helper.Converter;
import com.birhman.grocery.model.User;
import com.birhman.grocery.util.localstorage.LocalStorage;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.List;

import static androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE;

public class MainActivity extends BaseActivity
        implements View.OnClickListener {
    private static int cart_count = 0;
    User user;
    private Context context;
    private BottomNavigationView bottomNavigationView;
    private String FRAGMENT_HOME = "Home", FRAGMENT_OTHER = "Favorite";

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem menuItem = menu.findItem(R.id.cart_action);
        menuItem.setIcon(Converter.convertLayoutToImage(MainActivity.this, cart_count, R.drawable.ic_shopping_cart));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cart_action:
                startActivity(new Intent(getApplicationContext(), CartActivity.class));
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                return true;
        }
        return super.onOptionsItemSelected(item);

    }

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            toolbar.setTitleMarginStart((int) getResources().getDimension(R.dimen._15sdp));
        }

        init();
        toolbar.setTitle("DLF Colony, Sector 14, Gurugram, Haryana");
        toolbar.setTitleTextColor(Color.BLACK);

        viewFragment(new HomeFragment(), FRAGMENT_HOME);

        cart_count = cartCount();

        localStorage = new LocalStorage(getApplicationContext());
        String userString = localStorage.getUserLogin();
        Gson gson = new Gson();
        userString = localStorage.getUserLogin();
        user = gson.fromJson(userString, User.class);
    }

    private void init() {
        bottomNavigationView = findViewById(R.id.navigationBottom);
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation_home:
                        viewFragment(new HomeFragment(), FRAGMENT_HOME);
                        return true;
                    case R.id.navigation_order:
                        viewFragment(new MyOrderFragment(), FRAGMENT_OTHER);
                        return true;
                    case R.id.navigation_category:
                        viewFragment(new CategoryFragment(), FRAGMENT_OTHER);
                        return true;
                    case R.id.navigation_account:
                        viewFragment(new ProfileFragment(), FRAGMENT_OTHER);
                        return true;
                    case R.id.navigation_more:
                        viewFragment(new MoreFragment(), FRAGMENT_OTHER);
                        return true;
                }
                return false;
            }
        });
    }

    private void viewFragment(Fragment fragment, String name){
        final FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frament_layout, fragment);
        // 1. Know how many fragments there are in the stack
        final int count = fragmentManager.getBackStackEntryCount();
        // 2. If the fragment is **not** "home type", save it to the stack
        if( name.equals( FRAGMENT_OTHER) ) {
            fragmentTransaction.addToBackStack(name);
        }
        // Commit !
        fragmentTransaction.commit();
        // 3. After the commit, if the fragment is not an "home type" the back stack is changed, triggering the
        // OnBackStackChanged callback
        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                // If the stack decreases it means I clicked the back button
                if( fragmentManager.getBackStackEntryCount() <= count){
                    // pop all the fragment and remove the listener
                    fragmentManager.popBackStack(FRAGMENT_OTHER, POP_BACK_STACK_INCLUSIVE);
                    fragmentManager.removeOnBackStackChangedListener(this);
                    // set the home button selected
                    bottomNavigationView.getMenu().getItem(0).setChecked(true);
                }
            }
        });
    }

    @Override
    public void onAddProduct() {
        super.onAddProduct();
        cart_count++;
        invalidateOptionsMenu();
    }

    @Override
    public void onRemoveProduct() {
        super.onRemoveProduct();
    }

    @Override
    public void onClick(View view) {}
}
