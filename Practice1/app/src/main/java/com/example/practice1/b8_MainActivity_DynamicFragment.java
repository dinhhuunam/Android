package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.practice1.model.b8_FragmentA;
import com.example.practice1.model.b8_FragmentB;

public class b8_MainActivity_DynamicFragment extends AppCompatActivity implements View.OnClickListener {

    private Button btA, btB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b8_activity_main_dynamic_fragment);
        btA=findViewById(R.id.btA);
        btB=findViewById(R.id.btB);
        btA.setOnClickListener(this);
        btB.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        Fragment fg;
        switch (view.getId()) {
            case R.id.btA:
                fg= new b8_FragmentA();
                transaction.add(R.id.frame,fg);
                break;
            case R.id.btB:
                fg= new b8_FragmentB();
                transaction.add(R.id.frame,fg);
                break;
        }
        transaction.commit();
    }
}