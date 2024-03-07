package com.example.tourapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner_pt;
    private Spinner spinner_lt;
    private Spinner spinner_tg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.spinner_lt = findViewById(R.id.spinner_lt);
        this.spinner_pt = findViewById(R.id.spinner_pt);
        this.spinner_tg = findViewById(R.id.spinner_tg);

        String[] lt = TourDetail.getTour_lt();
        String[] pt = TourDetail.getTour_pt();
        String[] tg =TourDetail.getTour_tg();
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                pt);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                lt);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                tg);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinner_pt.setAdapter(adapter1);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinner_lt.setAdapter(adapter2);

        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinner_tg.setAdapter(adapter3);

        this.spinner_pt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                onItemSelectedHandler(parent, view, position, id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void onItemSelectedHandler(AdapterView<?> adapterView, View view, int position, long id) {
        Adapter adapter = adapterView.getAdapter();
        String pt = (String) adapter.getItem(position);

        Toast.makeText(getApplicationContext(), "Selected pt: " + pt ,Toast.LENGTH_SHORT).show();
    }
}