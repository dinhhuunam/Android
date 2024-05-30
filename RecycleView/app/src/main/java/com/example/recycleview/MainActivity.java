package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.recycleview.model.Cat;
import com.example.recycleview.model.CatAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CatAdapter.CatItemListener {
    private RecyclerView recyclerView;
    private CatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.rview);
        adapter=new CatAdapter(getList(),this);
        adapter.setCatItemListener(this);
        //Quản lý layout manager
        GridLayoutManager manager=new GridLayoutManager(this,2);
        //LinearLayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    private List<Cat> getList(){
        List<Cat> list = new ArrayList<>();
        list.add(new Cat(R.drawable.cat1,"Mèo con 1"));
        list.add(new Cat(R.drawable.cat2,"Mèo con 2"));
        list.add(new Cat(R.drawable.cat3,"Mèo con 3"));
        list.add(new Cat(R.drawable.cat4,"Mèo con 4"));
        list.add(new Cat(R.drawable.cat5,"Mèo con 5"));
        list.add(new Cat(R.drawable.cat6,"Mèo con 6"));
        list.add(new Cat(R.drawable.cat1,"Mèo con 7"));
        list.add(new Cat(R.drawable.cat2,"Mèo con 8"));
        list.add(new Cat(R.drawable.cat3,"Mèo con 9"));
        list.add(new Cat(R.drawable.cat4,"Mèo con 10"));
        return list;
    }

    @Override
    public void onItemClick(View view, int position) {
        Cat c=getList().get(position);
        Toast.makeText(this, c.getName(), Toast.LENGTH_SHORT).show();
    }
}