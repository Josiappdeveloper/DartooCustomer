package com.birhman.grocery.activity;

import android.content.DialogInterface;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.birhman.grocery.R;
import com.birhman.grocery.adapter.CartAdapter;
import com.birhman.grocery.model.Cart;
import com.birhman.grocery.util.localstorage.LocalStorage;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends BaseActivity {
    LocalStorage localStorage;
    List<Cart> cartList = new ArrayList<>();
    Gson gson;
    RecyclerView recyclerView;
    CartAdapter adapter;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    ImageView emptyCart;
    LinearLayout checkoutLL;
    TextView totalPrice, txtItemPrice, txtDeliveryFees, txtFinalAmount;
    private String mState = "SHOW_MENU";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            toolbar.setTitleMarginStart((int) getResources().getDimension(R.dimen._15sdp));
        }
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
     //   toolbar.setTitle("Confirm Order");
        getSupportActionBar().setTitle("Confirm Order");
        toolbar.setTitleTextColor(Color.BLACK);

        localStorage = new LocalStorage(getApplicationContext());
        gson = new Gson();
        emptyCart = findViewById(R.id.empty_cart_img);
        checkoutLL = findViewById(R.id.ll_next);
        totalPrice = findViewById(R.id.total_price);
        txtItemPrice = findViewById(R.id.txt_total);
        txtDeliveryFees = findViewById(R.id.txt_delivery_fees);
        txtFinalAmount = findViewById(R.id.txt_final_pay);
        double amount = getTotalPrice() + 30.0;
        totalPrice.setText("Pay: " + "\u20B9" + String.valueOf(amount));
        txtFinalAmount.setText("\u20B9" +  String.valueOf(amount));
        txtItemPrice.setText("\u20B9" + getTotalPrice());
        txtDeliveryFees.setText("\u20B9" + "30");
        setUpCartRecyclerview();

        checkoutLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CheckoutActivity.class);
                intent.putExtra("price", String.valueOf(amount));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.cart_menu, menu);
        MenuItem item = menu.findItem(R.id.cart_delete);
        if (mState.equalsIgnoreCase("HIDE_MENU")) {
            item.setVisible(false);
        } else {
            item.setVisible(true);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cart_delete:
                AlertDialog diaBox = showDeleteDialog();
                diaBox.show();
                return true;

            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private AlertDialog showDeleteDialog() {
        AlertDialog myQuittingDialogBox = new AlertDialog.Builder(this)

                //set message, title, and icon
                .setTitle("Delete")
                .setMessage("Do you want to Delete")
                .setIcon(R.drawable.ic_delete_black_24dp)

                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        localStorage.deleteCart();
                        adapter.notifyDataSetChanged();
                        emptyCart.setVisibility(View.VISIBLE);
                        mState = "HIDE_MENU";
                        invalidateOptionsMenu();
                        dialog.dismiss();
                    }

                })

                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }
                })
                .create();
        return myQuittingDialogBox;
    }

    private void setUpCartRecyclerview() {
        cartList = new ArrayList<>();
        cartList = getCartList();
        if (cartList.isEmpty()) {
            mState = "HIDE_MENU";
            invalidateOptionsMenu();
            emptyCart.setVisibility(View.VISIBLE);
            checkoutLL.setVisibility(View.GONE);
        }
        recyclerView = findViewById(R.id.cart_rv);
        recyclerView.setHasFixedSize(true);
        recyclerViewlayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(recyclerViewlayoutManager);
        adapter = new CartAdapter(cartList, CartActivity.this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void updateTotalPrice() {
        double amount = getTotalPrice() + 30.0;
        totalPrice.setText("Pay: " + "\u20B9" + String.valueOf(amount));
        txtFinalAmount.setText("\u20B9" +  String.valueOf(amount));
     //   totalPrice.setText("Pay: " + "\u20B9" + getTotalPrice());
        txtItemPrice.setText("\u20B9" + getTotalPrice());
        if (getTotalPrice() == 0.0) {
            mState = "HIDE_MENU";
            invalidateOptionsMenu();
            emptyCart.setVisibility(View.VISIBLE);
            checkoutLL.setVisibility(View.GONE);
        }
    }
}
