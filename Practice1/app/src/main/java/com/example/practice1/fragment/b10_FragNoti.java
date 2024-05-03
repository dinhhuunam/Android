package com.example.practice1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practice1.R;
import com.example.practice1.adapter.b10_MessageAdapter;
import com.example.practice1.model.b10_Message;

import java.util.ArrayList;
import java.util.List;

public class b10_FragNoti extends Fragment {
    b10_MessageAdapter messageAdapter;
    RecyclerView recyclerView;
    List<b10_Message> list;

    public b10_FragNoti() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.b10_frag_noti,container,false);
        list= new ArrayList<>();
        list.add(new b10_Message(R.drawable.plane, "Thanh", "Di choi khong?","16:20"));
        list.add(new b10_Message(R.drawable.moto, "Binh", "Lam bai tap chua?","17:00"));
        list.add(new b10_Message(R.drawable.car, "Hong", "An com chua?","12:00"));
        list.add(new b10_Message(R.drawable.plane, "Hung", "Chu Nhat ranh khong?","06:20"));
        list.add(new b10_Message(R.drawable.moto, "Anh", "oke","08:30"));
        list.add(new b10_Message(R.drawable.car, "Tu", "Bye bye","21:30"));
        recyclerView=view.findViewById(R.id.recycleView);
        LinearLayoutManager manager = new LinearLayoutManager(view.getContext(),RecyclerView.VERTICAL,false);
        messageAdapter= new b10_MessageAdapter(view.getContext(),list);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(messageAdapter);
        return view;
    }
}
