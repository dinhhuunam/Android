package com.example.thuchanh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thuchanh.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.EmployeeListener {
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private EditText ma,name;
//    private RadioGroup radioGroup;
    private RadioButton radioMale,radioFemale;
    private Button btAdd,btUpdate;
    private int current;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        List<Employee> employees = new ArrayList<>();
//        employees.add(new Employee("123","Nam",Employee.MALE));
//        employees.add(new Employee("123","Nam",Employee.FEMALE));
//        employees.add(new Employee("123","Nam",Employee.FEMALE));
//        employees.add(new Employee("123","Nam",Employee.FEMALE));
//        employees.add(new Employee("123","Nam",Employee.MALE));
        initView();

//        recyclerView.setAdapter(new MyAdapter(this));
//        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

        myAdapter=new MyAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(myAdapter);
        myAdapter.setClickListener(this);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Employee employee=new Employee();
                String maNv=ma.getText().toString();
                String tenNV=name.getText().toString();
                String gt="";
                if(radioMale.isChecked()){
                    gt = "MALE";
                }else{
                    gt="FEMALE";
                }
                Toast.makeText(getApplicationContext(),tenNV,Toast.LENGTH_LONG).show();
                employee.setGt(gt);
                employee.setMaNV(maNv);
                employee.setTenNv(tenNV);
                myAdapter.add(employee);
            }
        });

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Employee employee=new Employee();
                String maNv=ma.getText().toString();
                String tenNV=name.getText().toString();
                String gt="";
                if(radioMale.isChecked()){
                    gt = "MALE";
                }else{
                    gt="FEMALE";
                }
                Toast.makeText(getApplicationContext(),tenNV,Toast.LENGTH_LONG).show();
                employee.setGt(gt);
                employee.setMaNV(maNv);
                employee.setTenNv(tenNV);
                myAdapter.update(current,employee);
                btAdd.setEnabled(true);
                btUpdate.setEnabled(false);
            }
        });
    }

    private void initView() {
        recyclerView = findViewById(R.id.recycleView);
        ma=findViewById(R.id.ma);
        name=findViewById(R.id.name);
        btAdd=findViewById(R.id.btAdd);
        btUpdate=findViewById(R.id.btUpdate);
        radioMale=findViewById(R.id.male);
        radioFemale=findViewById(R.id.female);
        btUpdate.setEnabled(false);
        btAdd.setEnabled(true);
    }

    @Override
    public void onItemClick(View view, int position) {
        btAdd.setEnabled(false);
        btUpdate.setEnabled(true);

        current=position;
        Employee employee=myAdapter.getEmployee(position);

        String maNv = employee.getMaNV();
        String tenNv = employee.getTenNv();
        String gt = employee.getGt();

        if(gt.equals("MALE")){
            radioMale.setChecked(true);
        }else{
            radioFemale.setChecked(true);
        }
        ma.setText(maNv);
        name.setText(tenNv);
    }
}