package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.fragment.model.FragmentA;
import com.example.fragment.model.FragmentB;
import com.example.fragment.model.FragmentC;

public class MainActivity2 extends AppCompatActivity {
    //2 lớp để quản lý các fragment
    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        manager=getSupportFragmentManager();
    }
    public void add(Fragment fg,String tag,String name){
        //bắt đầu một transaction
        transaction=manager.beginTransaction();
        transaction.add(R.id.frame,fg,tag);
        transaction.addToBackStack(name);
        transaction.commit();
    }
    public void addA(View view){
        FragmentA fg=new FragmentA();
        add(fg,"fragA","fa");
    }
    public void addB(View view){
        FragmentB fg=new FragmentB();
        add(fg,"fragB","fb");
    }
    public void addC(View view){
        FragmentC fg=new FragmentC();
        add(fg,"fragC","fc");
    }
    public void remove(Fragment fg,String tag){
        //bắt đầu một transaction
        transaction=manager.beginTransaction();
        fg=manager.findFragmentByTag(tag);
        transaction.remove(fg);
        transaction.commit();
    }
    public void removeA(View view){
        FragmentA fg=new FragmentA();
        remove(fg,"fragA");
    }
    public void removeB(View view){
        FragmentB fg=new FragmentB();
        remove(fg,"fragB");
    }
    public void removeC(View view){
        FragmentC fg=new FragmentC();
        remove(fg,"fragC");
    }
    public void back(View view){
        manager.popBackStack();
    }
    public void popA(View view){
        manager.popBackStack("fa",0);
    }
    @Override
    public void onBackPressed() {
        if(manager.getBackStackEntryCount()>0)
            manager.popBackStack();
        super.onBackPressed();
    }
}