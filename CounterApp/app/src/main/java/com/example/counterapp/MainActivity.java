package com.example.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView welcome_text, counter_text;
    Button increment,decrement,reset;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        increment = findViewById(R.id.increment);
        decrement = findViewById(R.id.decrement);
        counter_text = findViewById(R.id.couter_text);
        welcome_text = findViewById(R.id.welcome_text);
        reset = findViewById(R.id.reset);

        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter_text.setText(""+getIncrement());
            }
        });

        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter_text.setText(""+getDecrement());
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter_text.setText(""+getReset());
            }
        });
    }
    public int getIncrement(){
        String res = counter_text.getText().toString();
        counter = Integer.parseInt(res);
        counter = Integer.parseInt(res);
        return ++counter;
    }
    public int getDecrement(){
        String res = counter_text.getText().toString();
        counter = Integer.parseInt(res);
        counter = Integer.parseInt(res);
        return --counter;
    }
    public int getReset(){
        return 0;
    }
}