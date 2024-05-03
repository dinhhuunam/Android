package com.example.practice1.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practice1.B12_UpdateDeleteActivity;
import com.example.practice1.R;
import com.example.practice1.adapter.B12_RecycleViewAdapter;
import com.example.practice1.adapter.TH2_RecycleViewAdapter;
import com.example.practice1.dal.B12_SQLiteHelper;
import com.example.practice1.model.B12_Item;

import java.util.List;

public class TH2_FragInfo extends Fragment {
//    private B12_RecycleViewAdapter adapter;
//    private RecyclerView recyclerView;
//    private B12_SQLiteHelper db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.th2_frag_info,container,false);
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        recyclerView= view.findViewById(R.id.recycleView);
//        adapter=new B12_RecycleViewAdapter();
//        db= new B12_SQLiteHelper(getContext());
//
////        B12_Item item = new B12_Item(1,"Mua quan bo","Mua sam","500","08/04/2024");
////        db.addItem(item);
////        B12_Item item2 = new B12_Item(2,"Mua quan bo","Mua sam","500","09/04/2024");
////        db.addItem(item2);
//
//        List<B12_Item> list=db.getAll();
//        adapter.setList(list);
//        LinearLayoutManager manager= new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
//        recyclerView.setLayoutManager(manager);
//        recyclerView.setAdapter(adapter);
//        adapter.setItemListener(this);
//    }
//
//    @Override
//    public void onItemClick(View view, int position) {
//        B12_Item item=adapter.getItem(position);
//        Intent intent= new Intent(getActivity(), B12_UpdateDeleteActivity.class);
//        intent.putExtra("item",item);
//        startActivity(intent);
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        List<B12_Item> list=db.getAll();
//        adapter.setList(list);
//    }
}
