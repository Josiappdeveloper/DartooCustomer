package com.birhman.grocery.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.birhman.grocery.fragment.ProductFragment;

public class ProductViewPagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;
    Fragment fragment = null;

    public ProductViewPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        for (int i = 0; i < mNumOfTabs ; i++) {
            if (i == position) {
                fragment = ProductFragment.newInstance();
                break;
            }
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
}