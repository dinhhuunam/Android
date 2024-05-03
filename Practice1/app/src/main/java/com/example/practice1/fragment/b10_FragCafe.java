package com.example.practice1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.practice1.R;
import com.example.practice1.cafe.b10_CafeViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class b10_FragCafe extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.b10_frag_cafe, container,false);
        tabLayout=view.findViewById(R.id.tabLayout);
        viewPager=view.findViewById(R.id.viewPager);
        b10_CafeViewPagerAdapter adapter = new b10_CafeViewPagerAdapter(getChildFragmentManager(),3);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}
