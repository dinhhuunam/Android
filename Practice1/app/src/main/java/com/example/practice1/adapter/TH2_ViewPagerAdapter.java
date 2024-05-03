package com.example.practice1.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.practice1.fragment.B12_FragHistory;
import com.example.practice1.fragment.B12_FragHome;
import com.example.practice1.fragment.B12_FragSearch;
import com.example.practice1.fragment.TH2_FragInfo;
import com.example.practice1.fragment.TH2_FragListView;
import com.example.practice1.fragment.TH2_FragSearch;


public class TH2_ViewPagerAdapter extends FragmentStatePagerAdapter {

    public TH2_ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new TH2_FragListView();
            case 1: return new TH2_FragInfo();
            case 2: return new TH2_FragSearch();
            default: return new TH2_FragListView();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
