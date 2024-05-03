package com.example.practice1.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.practice1.fragment.b10_FragCafe;
import com.example.practice1.fragment.b10_FragHome;
import com.example.practice1.fragment.b10_FragNoti;
import com.example.practice1.fragment.b10_FragSearch;

public class b10_ViewPagerAdapter extends FragmentStatePagerAdapter {
    int pageNum;
    public b10_ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new b10_FragHome();
            case 1: return new b10_FragNoti();
            case 2: return new b10_FragSearch();
            case 3: return new b10_FragCafe();
            default: return new b10_FragHome();
        }
    }

    @Override
    public int getCount() {
        return pageNum;
    }
}
