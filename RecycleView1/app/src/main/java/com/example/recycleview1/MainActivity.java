package com.example.recycleview1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Bear> bearList = new ArrayList<>();
        bearList.add(new Bear("Cat 1",R.drawable.cat1));
        bearList.add(new Bear("Cat 2",R.drawable.cat2));
        bearList.add(new Bear("Cat 3",R.drawable.cat3));
        bearList.add(new Bear("Cat 4",R.drawable.cat4));
        bearList.add(new Bear("Cat 5",R.drawable.cat5));
        bearList.add(new Bear("Cat 6",R.drawable.cat6));
        bearList.add(new Bear("Cat 7",R.drawable.cat6));
        bearList.add(new Bear("Cat 8",R.drawable.cat6));
        bearList.add(new Bear("Cat 9",R.drawable.cat6));
        bearList.add(new Bear("Cat 10",R.drawable.cat6));

        recyclerView=findViewById(R.id.recycleView);

        MyAdapter myAdapter = new MyAdapter(bearList);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
    }
}