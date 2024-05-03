package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.practice1.model.b11_Account;

public class b11_HomeActivityStartActivityForResult extends AppCompatActivity {

    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b11_activity_home_start_activity_for_result);
        txt = findViewById(R.id.tvHello);
        Intent intent=getIntent();
        if(intent.getSerializableExtra("account")!= null && intent.getSerializableExtra("user")!= null) {
            b11_Account log= (b11_Account) intent.getSerializableExtra("account");
            b11_Account user= (b11_Account) intent.getSerializableExtra("user");
            if(log.getUsername().equals(user.getUsername()) && log.getPassword().equals(user.getPassword())) {
                txt.setText("Dang nhap thanh cong!");
            } else {
                txt.setText("Tai khoan khong ton tai");
            }
        }
    }
}