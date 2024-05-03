package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.practice1.adapter.b9_FragAdapter;
import com.example.practice1.fragment.b9_FragAdd;
import com.example.practice1.fragment.b9_FragSearch;
import com.example.practice1.model.b9_Tour2;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class b9_MainActivity2 extends AppCompatActivity {

    public List<b9_Tour2> list= new ArrayList<>();
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private b9_FragAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b9_activity_main2);
        tabLayout=findViewById(R.id.tab);
        viewPager=findViewById(R.id.viewPager);

//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.add(R.id.fragAdd, new b9_FragAdd());
//        transaction.add(R.id.fragSearch, new b9_FragSearch());
//        transaction.commit();

//        adapter=new b9_FragAdapter(getSupportFragmentManager(), b9_FragAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapter=new b9_FragAdapter(getSupportFragmentManager(), 2);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

//        TabLayout.Tab tab1 = tabLayout.newTab();
//        TabLayout.Tab tab2 = tabLayout.newTab();
//        tabLayout.addTab(tab1);
//        tabLayout.addTab(tab2);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_search);
//        TabLayout.Tab tab0 = tabLayout.getTabAt(0);
//        if (tab0 != null) {
//            tab0.setIcon(R.drawable.ic_home);
//        }
//
//        TabLayout.Tab tab1 = tabLayout.getTabAt(1);
//        if (tab1 != null) {
//            tab1.setIcon(R.drawable.ic_search);
//        }
    }
}