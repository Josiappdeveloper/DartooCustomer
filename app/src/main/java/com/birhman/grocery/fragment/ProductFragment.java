package com.birhman.grocery.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.birhman.grocery.R;
import com.birhman.grocery.activity.MainActivity;
import com.birhman.grocery.activity.WebViewActivity;
import com.birhman.grocery.adapter.ProductAdapter;
import com.birhman.grocery.helper.Data;
import com.birhman.grocery.helper.URLConfig;
import com.birhman.grocery.util.AppUtils;

public class ProductFragment extends Fragment implements View.OnClickListener {
    private Context context;
    private RecyclerView recyclerView;
    ProductAdapter mAdapter;
    Data data;

    public static ProductFragment newInstance(){
        ProductFragment moreFragment = new ProductFragment();
        return moreFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getActivity();
        recyclerView = view.findViewById(R.id.product_rv);

        data = new Data();
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        mAdapter = new ProductAdapter(data.getProductList(), context);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context.getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            /*case R.id.rl_gallery:
                intent = new Intent(context, GalleryActivity.class);
                context.startActivity(intent);
                break;

            case R.id.rl_videos:
                intent = new Intent(context, VideosListingActivity.class);
                context.startActivity(intent);
                break;

            case R.id.rl_testimonial:
                intent = new Intent(context, TestimonialListingActivity.class);
                context.startActivity(intent);
                break;*/
        }
    }
}