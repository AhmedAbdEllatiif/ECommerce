package com.example.ahmedd.ecommerce.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ahmedd.ecommerce.Fragment.CouponFragment;
import com.example.ahmedd.ecommerce.Fragment.HomeFragment;

public class PageAdapter extends FragmentPagerAdapter {

    private int numberOfTabs;

    public PageAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case(0) : return new HomeFragment();
            case(1) : return new CouponFragment();
            default : return null;
            }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
