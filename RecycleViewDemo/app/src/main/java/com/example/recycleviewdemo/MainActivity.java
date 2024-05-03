package com.example.recycleviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.recycleviewdemo.model.Cat;
import com.example.recycleviewdemo.model.CatAdapter;

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
        adapter=new CatAdapter(getList());
        adapter.setCatItemListener(this);
        GridLayoutManager manager=new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
    private List<Cat> getList(){
        List<Cat> list = new ArrayList<>();
        list.add(new Cat(R.drawable.cat1,"Meo con 1"));
        list.add(new Cat(R.drawable.cat2,"Meo con 2"));
        list.add(new Cat(R.drawable.cat3,"Meo con 3"));
        list.add(new Cat(R.drawable.cat4,"Meo con 4"));
        list.add(new Cat(R.drawable.cat5,"Meo con 5"));
        list.add(new Cat(R.drawable.cat6,"Meo con 6"));
        return list;
    }

    @Override
    public void onItemClick(View view, int position) {
        Cat c = getList().get(position);
        Toast.makeText(this,c.getName(),Toast.LENGTH_LONG).show();
    }
}