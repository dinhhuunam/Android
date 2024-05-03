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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.practice1.dal.B12_SQLiteHelper;
import com.example.practice1.dal.TH2_SQLiteHelper;
import com.example.practice1.model.B12_Item;
import com.example.practice1.model.TH2_Song;

import java.util.Calendar;

public class TH2_UpdateDeleteActivity extends AppCompatActivity implements View.OnClickListener{

    public Spinner spAlbum, spType;
    private EditText eName, eSinger;
    private RadioGroup radioGroup;
    private RadioButton radioBtnFavorite, radioBtnNoFavorite;
    private TH2_Song item;
    private Button btUpdate, btBack, btRemove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.th2_activity_update_delete);
        initView();
        btBack.setOnClickListener(this);
        btUpdate.setOnClickListener(this);
//        eDate.setOnClickListener(this);
        btRemove.setOnClickListener(this);
        Intent intent= getIntent();
        item=(TH2_Song) intent.getSerializableExtra("item");
        eName.setText(item.getName());
        eSinger.setText(item.getSingle());
//        String isFavorite = item.getIsFavorite();
//        eDate.setText(item.getDate());
        int p=0;
        for(int i=0;i<spAlbum.getCount();i++) {
            if(spAlbum.getItemAtPosition(i).toString().equals(item.getAlbum())) {
                p=i;
                break;
            }
        }
        spAlbum.setSelection(p);

        for(int i=0;i<spType.getCount();i++) {
            if(spType.getItemAtPosition(i).toString().equals(item.getType())) {
                p=i;
                break;
            }
        }
        spType.setSelection(p);

        if(item.getIsFavorite().equals("true")) {
//            Toast.makeText(getApplicationContext(),"Yeu thich",Toast.LENGTH_SHORT).show();
            radioBtnFavorite.setChecked(true);
        } else {
//            Toast.makeText(getApplicationContext(),"Khong Yeu thich",Toast.LENGTH_SHORT).show();
            radioBtnNoFavorite.setChecked(true);
        }
    }
    private void initView() {
        spType= findViewById(R.id.spType);
        spAlbum= findViewById(R.id.spAlbum);
        eName=findViewById(R.id.tvName);
        eSinger=findViewById(R.id.tvSingle);
//        eDate=findViewById(R.id.tvDate);
        btUpdate=findViewById(R.id.btUpdate);
        btBack=findViewById(R.id.btBack);
        btRemove=findViewById(R.id.btRemove);
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
        TH2_SQLiteHelper db= new TH2_SQLiteHelper(this);
//        if (view==eDate) {
//            final Calendar c = Calendar.getInstance();
//            int year= c.get(Calendar.YEAR);
//            int month= c.get(Calendar.MONTH);
//            int day= c.get(Calendar.DAY_OF_MONTH);
//            DatePickerDialog dialog= new DatePickerDialog(B12_UpdateDeleteActivity.this, new DatePickerDialog.OnDateSetListener() {
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
        if(view == btBack) {
            finish();
        }
        if(view==btUpdate) {
            String name = eName.getText().toString();
            String single = eSinger.getText().toString();
            String album = spAlbum.getSelectedItem().toString();
            String type = spType.getSelectedItem().toString();
            int radioId= radioGroup.getCheckedRadioButtonId();
//            String date = eDate.getText().toString();
            String isFavorite="";
            if(radioId == R.id.radioBtnFavorite) {
                isFavorite = "true";
//                    Toast.makeText(getApplicationContext(),"favorite",Toast.LENGTH_SHORT).show();
//                    tour.setImgGender(R.drawable.male);
            } else {
                isFavorite = "false";
//                    tour.setImgGender(R.drawable.female);
            }

//            if(!title.isEmpty() && price.matches("\\d+")) {
            if(!name.isEmpty() && !single.isEmpty()) {
                int id= item.getId();
                TH2_Song item= new TH2_Song(id,name,single,album,type,isFavorite);
                db = new TH2_SQLiteHelper(this);
                db.update(item);
                finish();
            }
        }
        if(view==btRemove) {
            int id=item.getId();
            AlertDialog.Builder builder= new AlertDialog.Builder(view.getContext());
            builder.setTitle("Thong bao xoa");
            builder.setMessage("Ban co chac muon xoa "+item.getName()+" khong?");
            builder.setIcon(R.drawable.remove);
            builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    TH2_SQLiteHelper db= new TH2_SQLiteHelper(getApplicationContext());
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