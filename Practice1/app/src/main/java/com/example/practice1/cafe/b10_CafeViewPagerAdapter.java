package com.example.practice1.cafe;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class b10_CafeViewPagerAdapter extends FragmentStatePagerAdapter {
    public b10_CafeViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new b10_FragCuli();
            case 1: return new b10_FragMoka();
            case 2: return new b10_FragRobusta();
            default: return new b10_FragCuli();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return "CULI";
            case 1: return "MOKA";
            case 2: return "ROBUSTA";
            default: return "CULI";
        }
    }
}
