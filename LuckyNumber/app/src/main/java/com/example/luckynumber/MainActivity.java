package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btn;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.textView);
        editText = findViewById(R.id.edit_text);
        btn = findViewById(R.id.btn);

        //Pass data between activity
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = editText.getText().toString();

                // Explicit Intern
                Intent i = new Intent(
                        getApplicationContext(),SecondActivity.class
                );
                //Passing the name to second activity
                i.putExtra("name",userName);
                startActivity(i);

            }
        });
    }
}