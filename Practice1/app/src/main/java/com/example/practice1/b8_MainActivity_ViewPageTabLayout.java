package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.practice1.model.b8_FragmentAdapter;
import com.google.android.material.tabs.TabLayout;

public class b8_MainActivity_ViewPageTabLayout extends AppCompatActivity implements View.OnClickListener{

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Button btPre, btNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b8_activity_main_view_page_tab_layout);
        viewPager=findViewById(R.id.viewPager);
        tabLayout=findViewById(R.id.tabLayout);
        btNext=findViewById(R.id.btNext);
        btPre=findViewById(R.id.btPre);
        btPre.setOnClickListener(this);
        btNext.setOnClickListener(this);
        FragmentManager manager=getSupportFragmentManager();
        b8_FragmentAdapter adapter= new b8_FragmentAdapter(manager,3);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        setTabLayoutTitleColor();
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        tabLayout.setTabTextColors(Color.BLACK,getResources().getColor(R.color.colorPink));
                        btNext.setBackgroundColor(getResources().getColor(R.color.colorPink));
                        btPre.setBackgroundColor(getResources().getColor(R.color.colorPink));
                        break;
                    case 1:
                        tabLayout.setTabTextColors(Color.BLACK,getResources().getColor(R.color.colorGreen));
                        btNext.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                        btPre.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                        break;
                    case 2:
                        tabLayout.setTabTextColors(Color.BLACK,getResources().getColor(R.color.colorBlue));
                        btNext.setBackgroundColor(getResources().getColor(R.color.colorBlue));
                        btPre.setBackgroundColor(getResources().getColor(R.color.colorBlue));
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btNext:
                if(viewPager.getCurrentItem()==2) {
                    return;
                } else {
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    setTabLayoutTitleColor();
                }
                break;
            case R.id.btPre:
                if(viewPager.getCurrentItem()==0) {
                    return;
                } else {
                    viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
                    setTabLayoutTitleColor();
                }
                break;
        }
    }

    private void setTabLayoutTitleColor() {
        switch (viewPager.getCurrentItem()) {
            case 0:
                tabLayout.setTabTextColors(Color.BLACK,getResources().getColor(R.color.colorPink));
                break;
            case 1:
                tabLayout.setTabTextColors(Color.BLACK,getResources().getColor(R.color.colorGreen));
                break;
            case 2:
                tabLayout.setTabTextColors(Color.BLACK,getResources().getColor(R.color.colorBlue));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if(viewPager.getCurrentItem()==0)
            super.onBackPressed();
        else
            viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
    }
}