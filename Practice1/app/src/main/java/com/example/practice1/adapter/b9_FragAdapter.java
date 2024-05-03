package com.example.practice1.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


import com.example.practice1.fragment.b9_FragAdd;
import com.example.practice1.fragment.b9_FragSearch;

public class b9_FragAdapter extends FragmentStatePagerAdapter {
//    private int numPage=2;
    private int numPage;
    public b9_FragAdapter(@NonNull FragmentManager fm, int numPage) {
        super(fm,numPage);
        this.numPage=numPage;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new b9_FragAdd();
            case 1:
                return new b9_FragSearch();
//            default:
//                return null;
        }
        return null;
    }

    @Override
    public int getCount() {
        return numPage;
    }
}
