package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.practice1.dal.B12_SQLiteHelper;
import com.example.practice1.dal.TH2_SQLiteHelper;
import com.example.practice1.model.B12_Item;
import com.example.practice1.model.TH2_Song;

import java.util.Calendar;

public class TH2_AddActivity extends AppCompatActivity implements View.OnClickListener {
    public Spinner spAlbum, spType;
    private EditText eName, eSinger;
    private RadioGroup radioGroup;
    private RadioButton radioBtnFavorite, radioBtnNoFavorite;
    private Button btAdd, btCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.th2_activity_add);
        initView();
        btCancel.setOnClickListener(this);
        btAdd.setOnClickListener(this);
//        eDate.setOnClickListener(this);
    }

    private void initView() {
        spAlbum= findViewById(R.id.spAlbum);
        spType=findViewById(R.id.spType);
        eName=findViewById(R.id.tvName);
        eSinger=findViewById(R.id.tvSingle);
//        ePrice=findViewById(R.id.tvPrice);
//        eDate=findViewById(R.id.tvDate);
        btAdd=findViewById(R.id.btAdd);
        btCancel=findViewById(R.id.btCancel);
        radioGroup=findViewById(R.id.radioGroup);
        radioBtnFavorite=findViewById(R.id.radioBtnFavorite);
        radioBtnNoFavorite = findViewById(R.id.radioBtnNoFavorite);
        spAlbum.setAdapter(new ArrayAdapter<String>(this,R.layout.th2_item_spinner,
                getResources().getStringArray(R.array.album)));
        spType.setAdapter(new ArrayAdapter<String>(this,R.layout.th2_item_spinner,
                getResources().getStringArray(R.array.type)));

    }

    @Override
    public void onClick(View view) {
//        if (view==eDate) {
//            final Calendar c = Calendar.getInstance();
//            int year= c.get(Calendar.YEAR);
//            int month= c.get(Calendar.MONTH);
//            int day= c.get(Calendar.DAY_OF_MONTH);
//            DatePickerDialog dialog= new DatePickerDialog(B12_AddActivity.this, new DatePickerDialog.OnDateSetListener() {
//                @Override
//                public void onDateSet(DatePicker datePicker, int y, int m, int d) {
//                    String date="";
//                    if(m+1>9 && d>9) {
//                        date=d+"/"+(m+1)+"/"+y;
//                    } else if(m+1<9 && d>9) {
//                        date=d+"/0"+(m+1)+"/"+y;
//                    } else if(m+1>9 && d<9) {
//                        date="0"+d+"/"+(m+1)+"/"+y;
//                    } else {
//                        date="0"+d+"/0"+(m+1)+"/"+y;
//                    }
//
//                    eDate.setText(date);
//                }
//            },year,month,day);
//            dialog.show();
//        }
        if (view==btCancel) {
            finish();
        }
        if (view==btAdd) {
            String name = eName.getText().toString();
            String single = eSinger.getText().toString();
            String album = spAlbum.getSelectedItem().toString();
            String type = spType.getSelectedItem().toString();
            int radioId= radioGroup.getCheckedRadioButtonId();
            String isFavorite="";
//            try {
                if(radioId == R.id.radioBtnFavorite) {
                    isFavorite = "true";
//                    Toast.makeText(getApplicationContext(),"favorite",Toast.LENGTH_SHORT).show();
//                    tour.setImgGender(R.drawable.male);
                } else {
                    isFavorite = "false";
//                    tour.setImgGender(R.drawable.female);
                }
//                img = imgs[Integer.parseInt(i)];
                // neu co price thi parse price Double.parseDoule tai day
//                tour.setImg(img);
//                    Toast.makeText(getApplicationContext(),schedule,Toast.LENGTH_SHORT).show();
                if(!name.isEmpty() && !single.isEmpty()) {
                    TH2_Song item= new TH2_Song(name,single,album,type,isFavorite);
                    TH2_SQLiteHelper db = new TH2_SQLiteHelper(this);
                    db.addItem(item);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(),"Nhap lai",Toast.LENGTH_SHORT).show();
                }

//            } catch (NumberFormatException e) {
//                Toast.makeText(getApplicationContext(),"Nhap lai",Toast.LENGTH_SHORT).show();
//            }
//            String date = eDate.getText().toString();
//            if(!name.isEmpty() && price.matches("\\d+")) {
//            if(!name.isEmpty() && !single.isEmpty()) {
//                TH2_Song item= new TH2_Song(name,single,album,type);
//                B12_SQLiteHelper db = new B12_SQLiteHelper(this);
//                db.addItem(item);
//                finish();
//            }
        }
    }
}