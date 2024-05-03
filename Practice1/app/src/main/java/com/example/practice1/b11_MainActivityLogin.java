package com.example.practice1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practice1.model.b11_Account;

public class b11_MainActivityLogin extends AppCompatActivity implements View.OnClickListener {
    private TextView username, password;
    private Button btnLogin, btnRegister;
    private final static int REQUEST_CODE=1000;
    private b11_Account user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b11_activity_main_login);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        btnLogin=findViewById(R.id.btnLogin);
        btnRegister=findViewById(R.id.btnRegister);
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:
                Intent login= new Intent(b11_MainActivityLogin.this, b11_HomeActivityStartActivityForResult.class);
                b11_Account account= new b11_Account(username.getText().toString(),password.getText().toString());
                login.putExtra("account", account);
                login.putExtra("user",user);
                startActivity(login);
                break;
            case R.id.btnRegister:
                Intent intent= new Intent(b11_MainActivityLogin.this,b11_RegisterActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE && requestCode==RESULT_OK) {
            if (data==null) {
                Toast.makeText(this,"Nguoi dung huy dang ky", Toast.LENGTH_SHORT).show();
            } else {
                user= (b11_Account) data.getSerializableExtra("data");
                username.setText(user.getUsername());
                password.setText(user.getPassword());
            }
        } else {
            user=null;
        }
    }
}