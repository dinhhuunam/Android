package com.example.caculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView kq;
    private EditText edit1,edit2;
    private Button btAdd;
    private Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        String nn1=edit1.getText().toString();
        String nn2=edit2.getText().toString();
        double n1,n2;
        try {
            n1 = Double.parseDouble(nn1);
            n2 = Double.parseDouble(nn2);

            btAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s = tinhtoan(n1,n2,"+");
                    kq.setText(s);
                    Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                }
            });
        }catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(),"Nhập lại",Toast.LENGTH_LONG).show();
        }
    }
    private String tinhtoan(double x,double y,String p){
        String s="";
        switch (p){
            case "+": s="Tong:"+(x+y);
                    break;
            case "-": s="Tru:"+(x-y);
                break;
            case "*": s="Nhan:"+(x*y);
                break;
            case "/":
                if(y==0)
                    s="Khong chia cho 0";
                else
                    s="Thuong:"+(x/y);
                break;
        }
        return s;
    }
    private void initView() {
        kq=findViewById(R.id.kq);
        edit1=findViewById(R.id.e1);
        edit2=findViewById(R.id.e2);
        btAdd=findViewById(R.id.bt);
        sp=findViewById(R.id.sp);
    }
}