package com.birhman.grocery.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import com.birhman.grocery.R;
import com.birhman.grocery.fragment.AddressFragment;
import com.birhman.grocery.model.Order;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckoutActivity extends BaseActivity {
    String price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            toolbar.setTitleMarginStart((int) getResources().getDimension(R.dimen._15sdp));
        }
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        getSupportActionBar().setTitle("Checkout");
        toolbar.setTitleTextColor(Color.BLACK);

        price = getIntent().getStringExtra("price");
        TextView textView = findViewById(R.id.total_pay);
        textView.setText("Confirm and Pay " + "\u20B9" + price);

        LinearLayout layoutPay = findViewById(R.id.pay_ll);
        layoutPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
         //       progressDialog.setMessage("Please Wait....");
         //       progressDialog.show();
         //       closeProgress();
                showCustomDialog();
            }
        });
    }

    private void closeProgress() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
          //      progressDialog.dismiss();

            }
        }, 3000); // 5000 milliseconds
   //     SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
   //     String currentDateandTime = sdf.format(new Date());
   //     Order order = new Order(id, orderNo, currentDateandTime, "Rs. " + _totalAmount, "Pending");
   //     orderList.add(order);
   //     String orderString = gson.toJson(orderList);
   //     localStorage.setOrder(orderString);
   //     localStorage.deleteCart();

        showCustomDialog();
    }

    private void showCustomDialog() {
        final Dialog dialog = new Dialog(CheckoutActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //before
        dialog.setContentView(R.layout.success_dialog);
        dialog.setCanceledOnTouchOutside(false);

        RelativeLayout relativeLayout = dialog.findViewById(R.id.rl_close);

        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });

        dialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
