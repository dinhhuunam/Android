package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.practice1.model.b8_FragmentA;
import com.example.practice1.model.b8_FragmentB;
import com.example.practice1.model.b8_FragmentC;

public class b8_MainActivity_BasktashFrag extends AppCompatActivity {

    private FragmentManager manager;
    private FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b8_activity_main_basktash_frag);
        manager=getSupportFragmentManager();
    }
    private void add(Fragment fg, String tag, String name) {
        transaction= manager.beginTransaction();
        transaction.add(R.id.frame,fg,tag);
        transaction.addToBackStack(name);
        transaction.commit();
    }
    public void addA(View view) {
        b8_FragmentA fg= new b8_FragmentA();
        add(fg,"fragA","fa");
    }
    public void addB(View view) {
        b8_FragmentB fg= new b8_FragmentB();
        add(fg,"fragB","fb");
    }
    public void addC(View view) {
        b8_FragmentC fg= new b8_FragmentC();
        add(fg,"fragC","fc");
    }
    private  void remove(Fragment fg, String tag) {
        transaction=manager.beginTransaction();
        fg=manager.findFragmentByTag(tag);
        transaction.remove(fg);
        transaction.commit();
    }
    public void removeA(View view) {
        b8_FragmentA fg= new b8_FragmentA();
        remove(fg,"fragA");
    }
    public void removeB(View view) {
        b8_FragmentB fg= new b8_FragmentB();
        remove(fg,"fragB");
    }
    public void removeC(View view) {
        b8_FragmentC fg= new b8_FragmentC();
        remove(fg,"fragC");
    }
    public void back(View view) {
        manager.popBackStack();
    }
    public void popA(View view) {
        manager.popBackStack("fa",0);
    }

    @Override
    public void onBackPressed() {
        if(manager.getBackStackEntryCount()>0) {
            manager.popBackStack();
        }
        super.onBackPressed();
    }
}