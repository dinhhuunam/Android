package com.example.practice1.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.practice1.fragment.B12_FragHistory;
import com.example.practice1.fragment.B12_FragHome;
import com.example.practice1.fragment.B12_FragSearch;


public class B12_ViewPagerAdapter extends FragmentStatePagerAdapter {

    public B12_ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new B12_FragHome();
            case 1: return new B12_FragHistory();
            case 2: return new B12_FragSearch();
            default: return new B12_FragHome();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
