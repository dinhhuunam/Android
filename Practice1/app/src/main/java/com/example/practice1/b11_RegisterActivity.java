package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.practice1.model.b11_Account;

public class b11_RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView username, password;
    private Button btnCancel, btnRegister;
    private final static int REQUEST_CODE=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b11_activity_register);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        btnCancel=findViewById(R.id.btnCancel);
        btnRegister=findViewById(R.id.btnRegister);
        btnCancel.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRegister:
                b11_Account account= new b11_Account(username.getText().toString(),password.getText().toString());
                Intent intent= new Intent();
                intent.putExtra("data",account);
                setResult(RESULT_OK);
                finish();
                break;
            case R.id.btnCancel:
                setResult(RESULT_CANCELED,null);
                finish();
                break;
        }
    }
}