package com.birhman.grocery.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.birhman.grocery.R;
import com.birhman.grocery.activity.AnyStoreActivity;
import com.birhman.grocery.activity.MainActivity;
import com.birhman.grocery.activity.StoreListActivity;
import com.birhman.grocery.adapter.BannerAdapter;
import com.birhman.grocery.adapter.CategoryAdapter;
import com.birhman.grocery.adapter.HomeSliderAdapter;
import com.birhman.grocery.adapter.NewProductAdapter;
import com.birhman.grocery.adapter.PopularProductAdapter;
import com.birhman.grocery.helper.Data;
import com.birhman.grocery.model.BannerResponse;
import com.birhman.grocery.model.Category;
import com.birhman.grocery.util.LinePagerIndicatorDecoration;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {
    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    Timer timer;
    int page_position = 0;
    Data data;
    private int dotscount;
    private ImageView[] dots;
    private List<Category> categoryList = new ArrayList<>();
    private RecyclerView recyclerView, nRecyclerView, pRecyclerView;
    private CategoryAdapter mAdapter;
    private NewProductAdapter nAdapter;
    private PopularProductAdapter pAdapter;
    private Integer[] images = {R.drawable.slider1, R.drawable.slider2, R.drawable.slider3,
            R.drawable.slider4, R.drawable.slider5};

    private List<BannerResponse> mList = new ArrayList<>();
    private int[] moduleImages = new int[]{R.drawable.slider1, R.drawable.slider2,
            R.drawable.slider3, R.drawable.slider4, R.drawable.slider5};
    RecyclerView recyclerViewBanner;

    public HomeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        data = new Data();
        recyclerView = view.findViewById(R.id.category_rv);
        pRecyclerView = view.findViewById(R.id.popular_product_rv);
        nRecyclerView = view.findViewById(R.id.new_product_rv);

        LinearLayout linearLayoutAnyStore = view.findViewById(R.id.ll_any_store);
        LinearLayout linearLayoutFood = view.findViewById(R.id.ll_food);
        LinearLayout linearLayoutPaan = view.findViewById(R.id.ll_paan_shop);

        mList = new ArrayList<>();
        for (int i = 0; i < moduleImages.length; i++) {
            BannerResponse homeResponse = new BannerResponse();
            homeResponse.setResourceId(moduleImages[i]);
            mList.add(homeResponse);
        }
        recyclerViewBanner = view.findViewById(R.id.rv_banner);
        recyclerViewBanner.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false));
        BannerAdapter homeAdapter = new BannerAdapter(mList, Glide.with(getActivity().getApplicationContext()));
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerViewBanner);
        recyclerViewBanner.setAdapter(homeAdapter);

        recyclerViewBanner.addItemDecoration(new LinePagerIndicatorDecoration());

        linearLayoutPaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), StoreListActivity.class);
                intent.putExtra("title", "Order Paan");
                intent.putExtra("id", "1");
                requireActivity().startActivity(intent);
            }
        });

        linearLayoutFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), StoreListActivity.class);
                intent.putExtra("title", "Order Food");
                intent.putExtra("id", "2");
                requireActivity().startActivity(intent);
            }
        });

        linearLayoutAnyStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AnyStoreActivity.class);
                requireActivity().startActivity(intent);
            }
        });

        mAdapter = new CategoryAdapter(data.getCategoryList(), getContext(), "Home");
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        nAdapter = new NewProductAdapter(data.getNewList(), getContext(), "Home");
        RecyclerView.LayoutManager nLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        nRecyclerView.setLayoutManager(nLayoutManager);
        nRecyclerView.setItemAnimator(new DefaultItemAnimator());
        nRecyclerView.setAdapter(nAdapter);

        pAdapter = new PopularProductAdapter(data.getPopularList(), getContext(), "Home");
        RecyclerView.LayoutManager pLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        pRecyclerView.setLayoutManager(pLayoutManager);
        pRecyclerView.setItemAnimator(new DefaultItemAnimator());
        pRecyclerView.setAdapter(pAdapter);

        /*timer = new Timer();
        viewPager = view.findViewById(R.id.viewPager);
        sliderDotspanel = view.findViewById(R.id.SliderDots);
        HomeSliderAdapter viewPagerAdapter = new HomeSliderAdapter(getContext(), images);
        viewPager.setAdapter(viewPagerAdapter);
        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for (int i = 0; i < dotscount; i++) {
            dots[i] = new ImageView(getContext());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.non_active_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            sliderDotspanel.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.active_dot));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
        //        for (int i = 0; i < dotscount; i++) {
        //            dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.non_active_dot));
        //        }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });*/
    //    scheduleSlider();

        return view;
    }


    public void scheduleSlider() {
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            public void run() {
                if (page_position == dotscount) {
                    page_position = 0;
                } else {
                    page_position = page_position + 1;
                }
                viewPager.setCurrentItem(page_position, true);
            }
        };
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(update);
            }
        }, 500, 4000);
    }

    @Override
    public void onStop() {
    //    timer.cancel();
        super.onStop();
    }

    @Override
    public void onPause() {
    //    timer.cancel();
        super.onPause();
    }

    public void onLetsClicked(View view) {
        startActivity(new Intent(getContext(), MainActivity.class));
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("DLF Colony, Sector 14, Gurugram, Haryana");
    }
}
