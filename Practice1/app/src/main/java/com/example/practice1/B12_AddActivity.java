package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.practice1.dal.B12_SQLiteHelper;
import com.example.practice1.model.B12_Item;

import java.util.Calendar;

public class B12_AddActivity extends AppCompatActivity implements View.OnClickListener {

    public Spinner sp;
    private EditText eTitle, ePrice, eDate;
    private Button btUpdate, btCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b12_activity_add);
        initView();
        btCancel.setOnClickListener(this);
        btUpdate.setOnClickListener(this);
        eDate.setOnClickListener(this);
    }

    private void initView() {
        sp= findViewById(R.id.spCategory);
        eTitle=findViewById(R.id.tvTitle);
        ePrice=findViewById(R.id.tvPrice);
        eDate=findViewById(R.id.tvDate);
        btUpdate=findViewById(R.id.btUpdate);
        btCancel=findViewById(R.id.btCancel);
        sp.setAdapter(new ArrayAdapter<String>(this,R.layout.b12_item_spinner,
                getResources().getStringArray(R.array.category)));

    }

    @Override
    public void onClick(View view) {
        if (view==eDate) {
            final Calendar c = Calendar.getInstance();
            int year= c.get(Calendar.YEAR);
            int month= c.get(Calendar.MONTH);
            int day= c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog= new DatePickerDialog(B12_AddActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                    String date="";
                    if(m+1>9 && d>9) {
                        date=d+"/"+(m+1)+"/"+y;
                    } else if(m+1<9 && d>9) {
                        date=d+"/0"+(m+1)+"/"+y;
                    } else if(m+1>9 && d<9) {
                        date="0"+d+"/"+(m+1)+"/"+y;
                    } else {
                        date="0"+d+"/0"+(m+1)+"/"+y;
                    }

                    eDate.setText(date);
                }
            },year,month,day);
            dialog.show();
        }
        if (view==btCancel) {
            finish();
        }
        if (view==btUpdate) {
            String title = eTitle.getText().toString();
            String price = ePrice.getText().toString();
            String category = sp.getSelectedItem().toString();
            String date = eDate.getText().toString();
            if(!title.isEmpty() && price.matches("\\d+")) {
                B12_Item item= new B12_Item(title,category,price,date);
                B12_SQLiteHelper db = new B12_SQLiteHelper(this);
                db.addItem(item);
                finish();
            }
        }
    }
}