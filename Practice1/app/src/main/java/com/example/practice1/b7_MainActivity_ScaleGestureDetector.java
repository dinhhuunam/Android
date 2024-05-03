package com.example.practice1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class b7_MainActivity_ScaleGestureDetector extends AppCompatActivity
        implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, View.OnTouchListener {

    private TextView e1, e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12;
    private ImageView img;
    private GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b7_activity_main_scale_gesture_detector);
        initView();
        img.setOnTouchListener(this);
        detector=new GestureDetector(this, this);
        detector.setOnDoubleTapListener(this);
    }

    private void initView() {
        e1=findViewById(R.id.txt1);
        e2=findViewById(R.id.txt2);
        e3=findViewById(R.id.txt3);
        e4=findViewById(R.id.txt4);
        e5=findViewById(R.id.txt5);
        e6=findViewById(R.id.txt6);
        e7=findViewById(R.id.txt7);
        e8=findViewById(R.id.txt8);
        e9=findViewById(R.id.txt9);
        e10=findViewById(R.id.txt10);
        e11=findViewById(R.id.txt11);
        e12=findViewById(R.id.txt12);
        img=findViewById(R.id.img);
    }


    @Override
    public boolean onDown(@NonNull MotionEvent event) {
        e1.setText("Down touch");
        e2.setText("x:"+event.getX()+"y:"+event.getY());
        return true;
    }

    @Override
    public void onShowPress(@NonNull MotionEvent event) {
        e3.setText("show press");
        e4.setText("x:"+event.getX()+"y:"+event.getY());

    }

    @Override
    public boolean onSingleTapUp(@NonNull MotionEvent event) {
        e5.setText("single tap up");
        e6.setText("x:"+event.getX()+"y:"+event.getY());
        return true;
    }

    @Override
    public boolean onScroll(@Nullable MotionEvent event, @NonNull MotionEvent event1, float v, float v1) {
        e7.setText("scroll");
        e8.setText("x:"+event.getX()+"y:"+event.getY());
        return true;
    }

    @Override
    public void onLongPress(@NonNull MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(@Nullable MotionEvent event, @NonNull MotionEvent motionEvent1, float v, float v1) {
        e9.setText("flying");
        e10.setText("x:"+event.getX()+"y:"+event.getY());
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(@NonNull MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTap(@NonNull MotionEvent event) {
        e11.setText("double tap");
        e12.setText("x:"+event.getX()+"y:"+event.getY());
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(@NonNull MotionEvent event) {

        return false;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        detector.onTouchEvent(event);
        return true;
    }
}