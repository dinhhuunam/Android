package com.example.recycleview_th;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements UserAdapter.UserItemListener{
    private RecyclerView recyclerView;
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.rcv_user);
        adapter=new UserAdapter(this);


        //Quản lý layout manager
        LinearLayoutManager manager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        adapter.setData(getListUser());
        adapter.setUserItemListener(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
    private List<User> getListUser(){
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.cat1,"Cat 1"));
        list.add(new User(R.drawable.cat2,"Cat 2"));
        list.add(new User(R.drawable.cat3,"Cat 3"));
        list.add(new User(R.drawable.cat4,"Cat 4"));
        list.add(new User(R.drawable.cat5,"Cat 5"));
        list.add(new User(R.drawable.cat6,"Cat 6"));
        return list;
    }

    @Override
    public void onItemClick(View view, int position) {
        User u = getListUser().get(position);
        Toast.makeText(this, u.getName(), Toast.LENGTH_SHORT).show();
    }
}