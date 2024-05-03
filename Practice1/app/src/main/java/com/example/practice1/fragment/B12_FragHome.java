package com.example.practice1.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practice1.B12_UpdateDeleteActivity;
import com.example.practice1.R;
import com.example.practice1.adapter.B12_RecycleViewAdapter;
import com.example.practice1.dal.B12_SQLiteHelper;
import com.example.practice1.model.B12_Item;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class B12_FragHome extends Fragment implements B12_RecycleViewAdapter.ItemListener {
    private RecyclerView recyclerView;
    private B12_RecycleViewAdapter adapter;
    private B12_SQLiteHelper db;
    private TextView tvTong;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.b12_frag_home,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recycleView);
        tvTong=view.findViewById(R.id.tvTong);
        adapter=new B12_RecycleViewAdapter();
        db= new B12_SQLiteHelper(getContext());
//        List<B12_Item> list=db.getByDate("09/04/2024");
        Date currentDate= new Date();
        SimpleDateFormat f= new SimpleDateFormat("dd/MM/yyyy");
        List<B12_Item> list=db.getByDate(f.format(currentDate));
//        Toast.makeText(getActivity(),"Hi",Toast.LENGTH_SHORT).show();
        adapter.setList(list);
        tvTong.setText("Tong tien: "+tong(list));
        LinearLayoutManager manager= new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setItemListener(this);
    }

    private int tong(List<B12_Item> list) {
        int t=0;
        for(B12_Item i: list) {
            t+=Integer.parseInt(i.getPrice());
        }
        return t;
    }

    @Override
    public void onItemClick(View view, int position) {
        B12_Item item=adapter.getItem(position);
        Intent intent= new Intent(getActivity(), B12_UpdateDeleteActivity.class);
        intent.putExtra("item",item);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
//        List<B12_Item> list=db.getByDate("09/04/2024");
        Date currentDate= new Date();
        SimpleDateFormat f= new SimpleDateFormat("dd/MM/yyyy");
        List<B12_Item> list=db.getByDate(f.format(currentDate));
        adapter.setList(list);
        tvTong.setText("Tong tien: "+tong(list));
    }
}
