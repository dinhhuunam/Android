package com.example.thubaiktre;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements PersonAdapter.PersonItemListener, SearchView.OnQueryTextListener {

    private RecyclerView recyclerView;
    private PersonAdapter personAdapter;
    private EditText eName, eJob, eSex, eDate;
    private Button btnAdd, btnEdit;
    private int positionCur;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        personAdapter = new PersonAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(personAdapter);
        personAdapter.add(new Nguoi("22/2/2024","quet nha","nam","a"));
        eDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChonNgay();
            }
        });
        personAdapter.setClickListener(this);
        searchView.setOnQueryTextListener(this);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nguoi nguoi = new Nguoi();
                String name = eName.getText().toString();
                String job = eJob.getText().toString();
                String sex = eSex.getText().toString();
                String date = eDate.getText().toString();

                nguoi.setTen(name);
                nguoi.setCongviec(job);
                nguoi.setGioitinh(sex);
                nguoi.setNgay(date);
                if("nam".equalsIgnoreCase(sex)){
                    nguoi.setImg(R.drawable.nam);
                } else if("nu".equalsIgnoreCase(sex)){
                    nguoi.setImg(R.drawable.nu);
                } else nguoi.setImg((R.drawable.ic_launcher_foreground));
                personAdapter.add(nguoi);
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nguoi nguoi = new Nguoi();
                String name = eName.getText().toString();
                String job = eJob.getText().toString();
                String sex = eSex.getText().toString();
                String date = eDate.getText().toString();

                nguoi.setTen(name);
                nguoi.setCongviec(job);
                nguoi.setGioitinh(sex);
                nguoi.setNgay(date);
                if("nam".equalsIgnoreCase(sex)){
                    nguoi.setImg(R.drawable.nam);
                } else if("nu".equalsIgnoreCase(sex)){
                    nguoi.setImg(R.drawable.nu);
                } else nguoi.setImg((R.drawable.ic_launcher_foreground));
                personAdapter.edit(positionCur,nguoi);
                btnAdd.setEnabled(true);
                btnEdit.setEnabled(false);
            }
        });
    }

    private void AnhXa() {
        recyclerView = (RecyclerView) findViewById(R.id.listviewPerson);
        eName = (EditText) findViewById(R.id.ten);
        eJob = (EditText) findViewById(R.id.congviec);
        eSex = (EditText) findViewById(R.id.gioitinh);
        eDate = (EditText) findViewById(R.id.ngay);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnEdit = (Button) findViewById(R.id.btnEdit);
        btnEdit.setEnabled(false);
        searchView = (SearchView) findViewById(R.id.searchName);
    }

    private void ChonNgay() {
        Calendar calendar = Calendar.getInstance();
        int nam = calendar.get(Calendar.YEAR);
        int thang = calendar.get(Calendar.MONTH);
        int ngay = calendar.get(Calendar.DATE);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(i,i1,i2);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                eDate.setText(simpleDateFormat.format(calendar.getTime()));
            }
        },nam,thang,ngay);
        datePickerDialog.show();
    }

    @Override
    public void onItemClick(View view, int position) {
        btnAdd.setEnabled(false);
        btnEdit.setEnabled(true);
        positionCur = position;
        Nguoi nguoi = personAdapter.getItem(position);
        eName.setText(nguoi.getTen());
        eJob.setText(nguoi.getCongviec());
        eSex.setText(nguoi.getGioitinh());
        eDate.setText(nguoi.getNgay());
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
        ArrayList<Nguoi> filterlist = new ArrayList<>();
        for(Nguoi i : personAdapter.getListSearch()){
            if(i.getTen().toLowerCase().contains(s.toLowerCase())){
                filterlist.add(i);
            }
        }
        if(filterlist.isEmpty()){
            Toast.makeText(this, "Khong co nguoi nao!", Toast.LENGTH_SHORT).show();
        } else {
            personAdapter.filterList(filterlist);
        }
    }
}