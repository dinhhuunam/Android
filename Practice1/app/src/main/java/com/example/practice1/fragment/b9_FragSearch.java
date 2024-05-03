package com.example.practice1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practice1.b9_MainActivity2;
import com.example.practice1.R;
import com.example.practice1.adapter.b9_SearchAdapter;
import com.example.practice1.model.b9_Tour2;

import java.util.ArrayList;
import java.util.List;

public class b9_FragSearch extends Fragment {
    private b9_SearchAdapter adapter;
    private SearchView searchView;
    private RecyclerView recyclerView;
    private List<b9_Tour2> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.b9_frag_search,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        searchView=view.findViewById(R.id.search);
        recyclerView= view.findViewById(R.id.recycleViewSearch);
        adapter=new b9_SearchAdapter();
        GridLayoutManager manager = new GridLayoutManager(view.getContext(),1);
//        LinearLayoutManager manager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
//        recyclerView.smoothScrollToPosition(adapter.getItemCount());
        recyclerView.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filter(s);
                return false;
            }

        });
    }
    private void filter(String s) {
        List<b9_Tour2> filterlist= new ArrayList<>();
        for(b9_Tour2 i: list) {
            if(i.getSchedule().toLowerCase().contains(s.toLowerCase())) {
                filterlist.add(i);
            }
        }
        if(filterlist.isEmpty()) {
            Toast.makeText(getContext(),"No data found",Toast.LENGTH_SHORT).show();
        } else {
//                    adapter.filterList(filterlist);
            adapter.setList(filterlist);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        list=((b9_MainActivity2)getActivity()).list;
    }
}
