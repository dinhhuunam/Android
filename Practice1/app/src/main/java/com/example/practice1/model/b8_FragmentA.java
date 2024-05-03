package com.example.practice1.model;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.practice1.R;

public class b8_FragmentA extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.b8_fragment_a,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText tName=view.findViewById(R.id.tName);
        Button bt = view.findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=tName.getText().toString();
                tName.setText("Hello "+name+"!");
                tName.setBackgroundColor(Color.BLUE);
            }
        });
        tName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tName.setBackgroundColor(Color.TRANSPARENT);
                tName.setText("");
            }
        });
    }
}
