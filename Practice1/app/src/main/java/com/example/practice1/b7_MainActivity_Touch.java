package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class b7_MainActivity_Touch extends AppCompatActivity {

    private EditText e1, e2, e3, e4;
    private ImageView img;
    private float xDown=0, yDown=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b7_activity_main_touch);
        initView();
        img.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                switch (action){
                    case MotionEvent.ACTION_DOWN:
                        xDown=motionEvent.getX();
                        yDown=motionEvent.getY();
                        e1.setText(xDown+"");
                        e2.setText(yDown+"");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float moveX= motionEvent.getX();
                        float moveY = motionEvent.getY();
                        e3.setText(moveX+"");
                        e4.setText(moveY+"");
                        float dx = moveX-xDown;
                        float dy = moveY-yDown;
                        img.setX(img.getX()+dx);
                        img.setY(img.getY()+dy);
                        break;
                }
                return true;
            }
        });
    }

    private void initView() {
        e1= findViewById(R.id.txt1);
        e2= findViewById(R.id.txt2);
        e3= findViewById(R.id.txt3);
        e4= findViewById(R.id.txt4);
        img= findViewById(R.id.img);
    }
}