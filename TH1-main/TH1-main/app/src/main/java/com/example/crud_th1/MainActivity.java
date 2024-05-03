package com.example.crud_th1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import model.CellPhone;
import model.CellPhoneAdapter;
import model.SpinnerAdapter;

public class MainActivity extends AppCompatActivity implements CellPhoneAdapter.PhoneItemListener, SearchView.OnQueryTextListener {
    private Spinner sp;
    private RecyclerView recyclerView;
    private CellPhoneAdapter adapter;
    private EditText edName, edOrigin,edPrice;
    private Button btAdd,btUpdate;
    private int currentPosition;
    private SearchView searchView;
    private int[] imgs = {R.drawable.xemay,R.drawable.oto,R.drawable.maybay};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        adapter = new CellPhoneAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        searchView.setOnQueryTextListener(this);
        adapter.setClickListener(this);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CellPhone phone = new CellPhone();
                String i = sp.getSelectedItem().toString();
                String name = edName.getText().toString();
                String origin = edOrigin.getText().toString();
                String p = edPrice.getText().toString();
                try {
                    double price = Double.parseDouble(p);
                    int img = imgs[Integer.parseInt(i)];
                    phone.setImg(img);
                    phone.setName(name);
                    phone.setOrigin(origin);
                    phone.setPrice(price);
                    adapter.add(phone);
                }catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Loi nhap", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CellPhone phone = new CellPhone();
                String i = sp.getSelectedItem().toString();
                String name = edName.getText().toString();
                String origin = edOrigin.getText().toString();
                String p = edPrice.getText().toString();
                try {
                    double price = Double.parseDouble(p);
                    int img = imgs[Integer.parseInt(i)];
                    phone.setImg(img);
                    phone.setName(name);
                    phone.setOrigin(origin);
                    phone.setPrice(price);
                    adapter.update(currentPosition,phone);
                    btAdd.setEnabled(true);
                    btUpdate.setEnabled(false);
                }catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Loi nhap", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initView() {
        sp = findViewById(R.id.img);
        SpinnerAdapter adapter = new SpinnerAdapter(this);
        sp.setAdapter(adapter);
        recyclerView = findViewById(R.id.recycleView);
        edName = findViewById(R.id.edName);
        edOrigin = findViewById(R.id.edOrigin);
        edPrice = findViewById(R.id.edPrice);
        btAdd = findViewById(R.id.btAdd);
        btUpdate = findViewById(R.id.btUpdate);
        btUpdate.setEnabled(false);
        searchView = findViewById(R.id.search);
    }

    @Override
    public void onItemClick(View view, int position) {
        btAdd.setEnabled(false);
        btUpdate.setEnabled(true);
        currentPosition = position;
        CellPhone phone = adapter.getItem(position);
        int img = phone.getImg();
        int p=0;
        for (int i =0;i<imgs.length;i++){
            if(img == imgs[i]){
                p = i;
                break;
            }
        }
        sp.setSelection(p);
        edName.setText(phone.getName());
        edOrigin.setText(phone.getOrigin());
        edPrice.setText(phone.getPrice()+"");

    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        filter(s);
        return false;
    }

    private void filter(String s) {
        List<CellPhone> filterList = new ArrayList<>();
        for(CellPhone c : adapter.getBackup()) {
            if(c.getName().toLowerCase().contains(s.toLowerCase())){
                filterList.add(c);
            }
        }
        if (filterList.isEmpty()) {
            Toast.makeText(this, "Not found", Toast.LENGTH_SHORT).show();
        }else {
            adapter.filterList(filterList);
        }
    }

}