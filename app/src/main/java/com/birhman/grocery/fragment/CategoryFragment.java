package com.birhman.grocery.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.birhman.grocery.R;
import com.birhman.grocery.activity.StoreListActivity;
import com.birhman.grocery.adapter.CategoryAdapter;
import com.birhman.grocery.helper.Data;
import com.birhman.grocery.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {

    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        LinearLayout linearLayoutAnyStore = view.findViewById(R.id.ll_any_store);
        LinearLayout linearLayoutFood = view.findViewById(R.id.ll_food);
        linearLayoutAnyStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), StoreListActivity.class);
                intent.putExtra("title", "Order Grocery");
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


        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Category");
    }

}
