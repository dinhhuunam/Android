package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.practice1.model.b11_Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class b11_MainActivityExplicitIntent extends AppCompatActivity {

    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b11_activity_main_explicit_intent);
        bt = findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t =new Intent(b11_MainActivityExplicitIntent.this, b11_SecondActivityExplicit.class);
                String name = "To AN An";
                t.putExtra("name", name);
                int age= 22;
                t.putExtra("age",age);
                String[] subject = {"LTHDT", "LTW", "LTTBDD"};
                t.putExtra("subject",subject);
                b11_Student student = new b11_Student(R.drawable.plane, "Vu Thi Huong",40);
                t.putExtra("student",student);
                List<b11_Student> list = new ArrayList<>();
                list.add(student);
                list.add(new b11_Student(R.drawable.car,"Thu Nguyen", 26));
                list.add(new b11_Student(R.drawable.moto,"Tuan Tran", 28));
                t.putExtra("data",(Serializable) list);
                startActivity(t);
            }
        });
    }
}