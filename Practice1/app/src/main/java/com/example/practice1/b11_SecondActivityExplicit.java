package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.practice1.model.b11_Student;

import java.util.Arrays;
import java.util.List;

public class b11_SecondActivityExplicit extends AppCompatActivity {

    private Button bt;
    private TextView tvName;
    private TextView tvSub, tvStudent, tvList;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b11_activity_second_explicit);
        bt= findViewById(R.id.bt);
        tvName=findViewById(R.id.tvName);
        tvSub=findViewById(R.id.tvSub);
        tvStudent=findViewById(R.id.tvStudent);
        img=findViewById(R.id.img);
        tvList=findViewById(R.id.tvList);
        Intent t= getIntent();
        String name= t.getStringExtra("name");
        int age =t.getIntExtra("age",20);
        String[] sub= t.getStringArrayExtra("subject");
        tvName.setText(name+" - "+age);
        tvSub.setText(Arrays.toString(sub));
        b11_Student student=(b11_Student) t.getSerializableExtra("student");
        img.setImageResource(student.getImg());
        tvStudent.setText("Name: "+ student.getName()+" - "+"Age: "+ student.getAge()+"\n");
        List<b11_Student> list= (List<b11_Student>) t.getSerializableExtra("data");
        String tt="";
        for(b11_Student student1: list) {
            tt+="Name: "+ student1.getName()+" - "+"Age: "+ student1.getAge()+"\n";
        }
        tvList.setText(tt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}