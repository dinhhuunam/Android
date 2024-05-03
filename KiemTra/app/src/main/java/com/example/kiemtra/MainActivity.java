package com.example.kiemtra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdaptor myAdaptor;
    private EditText tenSach;
    private EditText thoiGian;
    private CheckBox khoaHoc,tieuThuyet,thieuNhi;
    private Button btnAdd, btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initView();
        myAdaptor = new MyAdaptor(this);
        LinearLayoutManager manager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(myAdaptor);


        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        thoiGian.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    private void initView() {
        tenSach=findViewById(R.id.ten_sach);
        khoaHoc=findViewById(R.id.kh);
        tieuThuyet=findViewById(R.id.tt);
        thieuNhi=findViewById(R.id.tn);
        thoiGian=findViewById(R.id.tg);
        btnAdd=findViewById(R.id.btAdd);
        btnUpdate=findViewById(R.id.btUpdate);

    }
}