package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
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

public class B12_UpdateDeleteActivity extends AppCompatActivity implements View.OnClickListener {
    public Spinner sp;
    private EditText eTitle, ePrice, eDate;
    private Button btUpdate, btBack, btRemove;
    private B12_Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b12_activity_update_delete);
        initView();
        btBack.setOnClickListener(this);
        btUpdate.setOnClickListener(this);
        eDate.setOnClickListener(this);
        btRemove.setOnClickListener(this);
        Intent intent= getIntent();
        item=(B12_Item) intent.getSerializableExtra("item");
        eTitle.setText(item.getTitle());
        ePrice.setText(item.getPrice());
        eDate.setText(item.getDate());
        int p=0;
        for(int i=0;i<sp.getCount();i++) {
            if(sp.getItemAtPosition(i).toString().equals(item.getCategory())) {
                p=i;
                break;
            }
        }
        sp.setSelection(p);
    }
    private void initView() {
        sp= findViewById(R.id.spCategory);
        eTitle=findViewById(R.id.tvTitle);
        ePrice=findViewById(R.id.tvPrice);
        eDate=findViewById(R.id.tvDate);
        btUpdate=findViewById(R.id.btUpdate);
        btBack=findViewById(R.id.btBack);
        btRemove=findViewById(R.id.btRemove);
        sp.setAdapter(new ArrayAdapter<String>(this,R.layout.b12_item_spinner,
                getResources().getStringArray(R.array.category)));

    }

    @Override
    public void onClick(View view) {
        B12_SQLiteHelper db= new B12_SQLiteHelper(this);
        if (view==eDate) {
            final Calendar c = Calendar.getInstance();
            int year= c.get(Calendar.YEAR);
            int month= c.get(Calendar.MONTH);
            int day= c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog= new DatePickerDialog(B12_UpdateDeleteActivity.this, new DatePickerDialog.OnDateSetListener() {
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
        if(view == btBack) {
            finish();
        }
        if(view==btUpdate) {
            String title = eTitle.getText().toString();
            String price = ePrice.getText().toString();
            String category = sp.getSelectedItem().toString();
            String date = eDate.getText().toString();
            if(!title.isEmpty() && price.matches("\\d+")) {
                int id= item.getId();
                B12_Item item= new B12_Item(id,title,category,price,date);
                db = new B12_SQLiteHelper(this);
                db.update(item);
                finish();
            }
        }
        if(view==btRemove) {
            int id=item.getId();
            AlertDialog.Builder builder= new AlertDialog.Builder(view.getContext());
            builder.setTitle("Thong bao xoa");
            builder.setMessage("Ban co chac muon xoa "+item.getTitle()+" khong?");
            builder.setIcon(R.drawable.remove);
            builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    B12_SQLiteHelper db= new B12_SQLiteHelper(getApplicationContext());
                    db.delete(id);
                    finish();
                }
            });
            builder.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            AlertDialog dialog= builder.create();
            dialog.show();
        }
    }
}