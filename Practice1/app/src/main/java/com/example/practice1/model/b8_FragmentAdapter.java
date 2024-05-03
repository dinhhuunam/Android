package com.example.practice1.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class b8_FragmentAdapter extends FragmentPagerAdapter {
    private int pageNumber;
    public b8_FragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.pageNumber=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                b8_FragFood food= new b8_FragFood();
                return food;
            case 1:
                b8_FragMovie movie= new b8_FragMovie();
                return movie;
            case 2:
                b8_FragTravel travel= new b8_FragTravel();
                return travel;
        }
        return null;
    }

    @Override
    public int getCount() {
        return pageNumber;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return "FOOD";
            case 1: return "MOVIE";
            case 2: return "TRAVEL";
        }
        return null;
    }
}
