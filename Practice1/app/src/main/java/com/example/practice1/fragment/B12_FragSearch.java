package com.example.practice1.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practice1.B12_AddActivity;
import com.example.practice1.R;
import com.example.practice1.adapter.B12_RecycleViewAdapter;
import com.example.practice1.dal.B12_SQLiteHelper;
import com.example.practice1.model.B12_Item;

import java.util.Calendar;
import java.util.List;

public class B12_FragSearch extends Fragment implements View.OnClickListener{
    private RecyclerView recyclerView;
    private TextView tvTong;
    private Button btSearch;
    private SearchView searchView;
    private EditText eFrom, eTo;
    private Spinner spCategory;
    private B12_RecycleViewAdapter adapter;
    B12_SQLiteHelper db;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.b12_frag_search,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        adapter= new B12_RecycleViewAdapter();
        db= new B12_SQLiteHelper(getContext());
        List<B12_Item> list=db.getAll();
        adapter.setList(list);
        tvTong.setText("Tong tien: "+tong(list)+"k");
        LinearLayoutManager manager= new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                List<B12_Item> list = db.searchByTitle(s);
                tvTong.setText("Tong tien: "+tong(list)+"k");
                adapter.setList(list);
                return true;
            }
        });
        eFrom.setOnClickListener(this);
        eTo.setOnClickListener(this);
        btSearch.setOnClickListener(this);
        spCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String cate=spCategory.getItemAtPosition(position).toString();
                List<B12_Item> list;
                if(!cate.equals("All")) {
                    list=db.searchByCategory(cate);
                } else {
                    list=db.getAll();
                }
                adapter.setList(list);
                tvTong.setText("Tong tien: "+tong(list)+"k");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initView(View view) {
        recyclerView=view.findViewById(R.id.recycleView);
        tvTong=view.findViewById(R.id.tvTong);
        btSearch=view.findViewById(R.id.btSearch);
        searchView=view.findViewById(R.id.search);
        eFrom=view.findViewById(R.id.eFrom);
        eTo=view.findViewById(R.id.eTo);
        spCategory=view.findViewById(R.id.spinnerCategory);
        String[] arr=getResources().getStringArray(R.array.category);
        String[] arr1=new String[arr.length+1];
        arr1[0]="All";
        for(int i=0;i<arr.length;i++) {
            arr1[i+1]=arr[i];
        }
        spCategory.setAdapter(new ArrayAdapter<String>(getContext(),R.layout.b12_item_spinner,arr1));


    }
    private int tong(List<B12_Item> list) {
        int t=0;
        for(B12_Item i: list) {
            t+=Integer.parseInt(i.getPrice());
        }
        return t;
    }

    @Override
    public void onClick(View view) {
        if(view==eFrom) {
            final Calendar c = Calendar.getInstance();
            int year= c.get(Calendar.YEAR);
            int month= c.get(Calendar.MONTH);
            int day= c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog= new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                    String date="";
                    if(m+1>9 && d>9) {
                        date=d+"/"+(m+1)+"/"+y;
                    } else if(m+1<9 && d>9) {
                        date=d+"/0"+(m+1)+"/"+y;
                    } else if(m+1>9 && d<9) {
                        date="0"+d+"/"+(m+1)+"/"+y;
                    } else {
                        date="0"+d+"/0"+(m+1)+"/"+y;
                    }

                    eFrom.setText(date);
                }
            },year,month,day);
            dialog.show();
        }
        if(view==eTo) {
            final Calendar c = Calendar.getInstance();
            int year= c.get(Calendar.YEAR);
            int month= c.get(Calendar.MONTH);
            int day= c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog= new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                    String date="";
                    if(m+1>9 && d>9) {
                        date=d+"/"+(m+1)+"/"+y;
                    } else if(m+1<9 && d>9) {
                        date=d+"/0"+(m+1)+"/"+y;
                    } else if(m+1>9 && d<9) {
                        date="0"+d+"/"+(m+1)+"/"+y;
                    } else {
                        date="0"+d+"/0"+(m+1)+"/"+y;
                    }

                    eTo.setText(date);
                }
            },year,month,day);
            dialog.show();
        }
        if(view==btSearch) {
            String from= eFrom.getText().toString();
            String to= eTo.getText().toString();
            if(!from.isEmpty() && !to.isEmpty()) {
                List<B12_Item> list=db.searchByFromToDate(from,to);
                adapter.setList(list);
                tvTong.setText("Tong tien: "+tong(list)+"k");
            }
        }
    }
}
