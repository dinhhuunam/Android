package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.fragment.model.FragmentA;
import com.example.fragment.model.FragmentB;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btA,btB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btA=findViewById(R.id.btA);
        btB=findViewById(R.id.btB);
        btA.setOnClickListener(this);
        btB.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //khi sử dụng fragment
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        Fragment fg;
        switch (view.getId()){
            case R.id.btA:
                fg=new FragmentA();
                transaction.add(R.id.frame,fg);
                break;
            case R.id.btB:
                fg=new FragmentB();
                transaction.add(R.id.frame,fg);
                break;
        }
        transaction.commit();
    }
}