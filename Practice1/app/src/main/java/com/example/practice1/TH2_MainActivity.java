package com.example.practice1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.practice1.adapter.B12_ViewPagerAdapter;
import com.example.practice1.adapter.TH2_ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TH2_MainActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;
    private ViewPager viewPager;
    private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.th2_activity_main);
        navigationView=findViewById(R.id.bottom_nav);
        viewPager=findViewById(R.id.viewPager);
        fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(b12_MainActivityDB.this,"test",Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(TH2_MainActivity.this,TH2_AddActivity.class);
                startActivity(intent);
            }
        });
        TH2_ViewPagerAdapter adapter= new TH2_ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        navigationView.getMenu().findItem(R.id.mListView).setChecked(true);
                        break;
                    case 1:
                        navigationView.getMenu().findItem(R.id.mInfo).setChecked(true);
                        break;
                    case 2:
                        navigationView.getMenu().findItem(R.id.mSearch).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mListView:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.mInfo:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.mSearch:
                        viewPager.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });
    }
}