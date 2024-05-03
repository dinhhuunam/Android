package com.example.practice1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.practice1.adapter.b10_ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class b10_MainActivity_BottomNavigation extends AppCompatActivity {

    private BottomNavigationView navigationView;
    private ViewPager viewPager;
    private FloatingActionButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b10_activity_main_bottom_navigation);
        viewPager=findViewById(R.id.viewPager);
        navigationView=findViewById(R.id.navigation);
        button= findViewById(R.id.fab);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(b10_MainActivity_BottomNavigation.this,"Ban da chon toi", Toast.LENGTH_SHORT).show();
            }
        });
        b10_ViewPagerAdapter adapter=new b10_ViewPagerAdapter(getSupportFragmentManager(),4);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        navigationView.getMenu().findItem(R.id.home).setCheckable(true);
                        break;
                    case 1:
                        navigationView.getMenu().findItem(R.id.noti).setCheckable(true);
                        break;
                    case 2:
                        navigationView.getMenu().findItem(R.id.search).setCheckable(true);
                        break;
                    case 3:
                        navigationView.getMenu().findItem(R.id.cafe).setCheckable(true);
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
                    case R.id.home:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.noti:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.search:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.cafe:
                        viewPager.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });
    }
}