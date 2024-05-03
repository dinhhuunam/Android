package com.example.crud_th1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.BookAdapter;


public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private RecyclerView recyclerView;
    private BookAdapter adapter;
    private EditText edName, edNXB;
    private CheckBox cb1,cb2,cb3;
    private Button btAdd,btUpdate;
    private int currentPosition;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        adapter = new BookAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        searchView.setOnQueryTextListener(this);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
                String name = edName.getText().toString();
                String nxb = edNXB.getText().toString();
                List<String> list = new ArrayList<>();
                if(cb1.isChecked()) {
                    list.add("Khoa hoc");
                }
                if(cb2.isChecked()) {
                    list.add("Tieu thuyet");
                }
                if(cb3.isChecked()) {
                    list.add("Thieu nhi");
                }
                try {
                    book.setTen(name);
                    book.setNxb(nxb);
                    book.setTheloai(list);
                    adapter.add(book);
                }catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Loi nhap", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
                String name = edName.getText().toString();
                String nxb = edNXB.getText().toString();
                try {

                    book.setTen(name);
                    book.setNxb(nxb);
                    adapter.add(book);
                    adapter.update(currentPosition,book);
                    btAdd.setEnabled(true);
                    btUpdate.setEnabled(false);
                }catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Loi nhap", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void initView() {
        recyclerView = findViewById(R.id.recycleView);
        edName = findViewById(R.id.edName);
        edNXB = findViewById(R.id.edNXB);
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        btAdd = findViewById(R.id.btAdd);
        btUpdate = findViewById(R.id.btUpdate);
        btUpdate.setEnabled(false);
        searchView = findViewById(R.id.search);
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
        List<Book> filterList = new ArrayList<>();
        for(Book c : adapter.getBackup()) {
            if(c.getTen().toLowerCase().contains(s.toLowerCase())){
                filterList.add(c);
            }
        }
        if (filterList.isEmpty()) {
            Toast.makeText(this, "Not found", Toast.LENGTH_SHORT).show();
        }else {
//            adapter.filterList(filterList);
        }
    }
}