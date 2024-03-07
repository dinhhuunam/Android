package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    private Spinner sp1,sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp1=findViewById(R.id.sp1);
        String[] list1=getResources().getStringArray(R.array.country);
        ArrayAdapter<String> adapter1=new ArrayAdapter<>(this,R.layout.item,list1);
        sp1.setAdapter(adapter1);

        sp=findViewById(R.id.sp);
        String[] list={"PTIT","HUST","NEU","FTU"};
        ArrayAdapter<String>adapter = new ArrayAdapter<>(this,R.layout.item,list);
        sp.setAdapter(adapter);
    }
}