package com.birhman.grocery.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.birhman.grocery.R;
import com.birhman.grocery.helper.Converter;
import com.birhman.grocery.util.NetworkUtils;
import com.google.android.material.button.MaterialButton;

public class WebViewActivity extends AppCompatActivity implements View.OnClickListener{
    private Context context;
    String webUrl, heading;
    WebView web;
    ProgressBar progressBar;
    private RelativeLayout relativeLayout, relativeLayoutInternet;


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        context = this;
        init();
        getData();

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#34495E")));
        changeActionBarTitle(getSupportActionBar());
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        web.setWebViewClient (new MyWebClient ());
        web.getSettings ().setJavaScriptEnabled (true);
        try{
            if (NetworkUtils.isOnline(context)) {
                relativeLayout.setVisibility(View.VISIBLE);
                relativeLayoutInternet.setVisibility(View.GONE);
                if (webUrl != null && !webUrl.isEmpty()) web.loadUrl(webUrl);
            }else{
                relativeLayout.setVisibility(View.GONE);
                relativeLayoutInternet.setVisibility(View.VISIBLE);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

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
        tv.setText(heading); // ActionBar title text
        tv.setTextSize(20);

        // Set the text color of TextView to red
        // This line change the ActionBar title text color
        tv.setTextColor(getResources().getColor(R.color.white));

        // Set the ActionBar display option
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        // Finally, set the newly created TextView as ActionBar custom view
        actionBar.setCustomView(tv);
    }

    private void getData() {
        heading = getIntent ().getStringExtra ("strHeading");
        webUrl = getIntent ().getStringExtra ("strUrl");
    }

    private void init() {
        web = findViewById (R.id.web_view);
        progressBar = findViewById(R.id.progressBar1);
        relativeLayout = findViewById(R.id.rl_web_view);
        relativeLayoutInternet = findViewById(R.id.rl_no_internet);
        MaterialButton btnTryAgain = findViewById(R.id.material_text_button);

        btnTryAgain.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here
                Intent intent = new Intent(WebViewActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.material_text_button:
                try{
                    if (NetworkUtils.isOnline(context)) {
                        relativeLayout.setVisibility(View.VISIBLE);
                        relativeLayoutInternet.setVisibility(View.GONE);
                        if (webUrl != null && !webUrl.isEmpty()) web.loadUrl(webUrl);
                    }else{
                        relativeLayout.setVisibility(View.GONE);
                        relativeLayoutInternet.setVisibility(View.VISIBLE);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
        }

    }

    public class MyWebClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            progressBar.setVisibility(View.VISIBLE);
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && web.canGoBack()) {
            web.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}