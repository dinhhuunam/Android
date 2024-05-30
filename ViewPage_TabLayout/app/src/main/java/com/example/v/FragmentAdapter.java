package com.example.v;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.v.model.FragmentFood;
import com.example.v.model.FragmentMovie;
import com.example.v.model.FragmentTravel;

public class FragmentAdapter extends FragmentPagerAdapter {
    private int pageNumber;
    public FragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.pageNumber=behavior;
    }

    //trả về fragment ở vị trí position
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                FragmentFood food = new FragmentFood();
                return food;
            case 1:
                FragmentMovie movie = new FragmentMovie();
                return movie;
            case 2:
                FragmentTravel travel = new FragmentTravel();
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
        switch (position){
            case 0: return "FOOD";
            case 1: return "MOVIE";
            case 2: return "TRAVEL";
        }
        return null;
    }
}
