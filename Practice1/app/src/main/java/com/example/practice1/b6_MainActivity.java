package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.practice1.model.b6_SpinnerAdapter;
import com.example.practice1.model.b6_Tour;
import com.example.practice1.model.b6_TourAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class b6_MainActivity extends AppCompatActivity implements b6_TourAdapter.TourItemListener,
        SearchView.OnQueryTextListener, View.OnClickListener{

    private Spinner sp;
    private RecyclerView recyclerView;
    private b6_TourAdapter adapter;
    private EditText eSchedule, eTime, eClock, eDate;
    private Button btnAdd, btnUpdate;
    private int positionCurrent;
    private SearchView searchView;
    private RadioGroup radioGroup;
    private RadioButton radioBtnMale, radioBtnFemale;
    private CheckBox checkBox1, checkBox2, checkBox3;
    private RatingBar ratingBar;

    private int[] imgs = {R.drawable.car, R.drawable.plane, R.drawable.moto};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b6_activity_main);
        initView();
        adapter= new b6_TourAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this,RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
//        recyclerView.smoothScrollToPosition(adapter.getItemCount());
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);
        searchView.setOnQueryTextListener(this);
        eClock.setOnClickListener(this);
        eDate.setOnClickListener(this);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b6_Tour tour= new b6_Tour();
                String i = sp.getSelectedItem().toString();
                String schedule = eSchedule.getText().toString();
                String time = eTime.getText().toString();
                String clock = eClock.getText().toString();
                String date= eDate.getText().toString();
                int img=R.drawable.car;
                int radioId= radioGroup.getCheckedRadioButtonId();
                try {
                    if(radioId == R.id.radioBtnMale) {
                        Toast.makeText(getApplicationContext(),"male",Toast.LENGTH_SHORT).show();
                        tour.setImgGender(R.drawable.male);
                    } else {
                        tour.setImgGender(R.drawable.female);
                    }
                    img = imgs[Integer.parseInt(i)];
                    // neu co price thi parse price Double.parseDoule tai day
                    tour.setImg(img);
//                    Toast.makeText(getApplicationContext(),schedule,Toast.LENGTH_SHORT).show();
                    if(!schedule.equals("") && !time.equals("")) {
                        tour.setSchedule(schedule);
                        tour.setTime(time);
                        tour.setClock(clock);
                        tour.setDate(date);
                        adapter.add(tour);
                    } else {
                        Toast.makeText(getApplicationContext(),"Nhap lai",Toast.LENGTH_SHORT).show();
                    }

                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(),"Nhap lai",Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b6_Tour tour= new b6_Tour();
                String i = sp.getSelectedItem().toString();
                String schedule = eSchedule.getText().toString();
                String time = eTime.getText().toString();
                String clock = eClock.getText().toString();
                String date = eDate.getText().toString();
                int img=R.drawable.car;
                int radioId= radioGroup.getCheckedRadioButtonId();


                try {
                    if(radioId == R.id.radioBtnMale) {
                        tour.setImgGender(R.drawable.male);
                    } else {
                        tour.setImgGender(R.drawable.female);
                    }
                    img = imgs[Integer.parseInt(i)];
                    // neu co price thi parse price Double.parseDoule tai day
                    tour.setImg(img);
//                    Toast.makeText(getApplicationContext(),schedule,Toast.LENGTH_SHORT).show();
                    if(!schedule.equals("") && !time.equals("")) {
                        tour.setSchedule(schedule);
                        tour.setTime(time);
                        tour.setClock(clock);
                        tour.setDate(date);
                        adapter.update(positionCurrent,tour);
                        btnAdd.setEnabled(true);
                        btnUpdate.setEnabled(false);
                    } else {
                        Toast.makeText(getApplicationContext(),"Nhap lai",Toast.LENGTH_SHORT).show();
                    }

                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(),"Nhap lai",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initView() {
        sp = findViewById(R.id.imgSpinner);
        b6_SpinnerAdapter adapter = new b6_SpinnerAdapter(this);
        sp.setAdapter(adapter);

        recyclerView= findViewById(R.id.recycleView);
        eSchedule= findViewById(R.id.edSchedule);
        eTime = findViewById(R.id.edTime);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate=findViewById(R.id.btnUpdate);
        btnUpdate.setEnabled(false);
        searchView=findViewById(R.id.search);
        eClock= findViewById(R.id.edClock);
        eDate= findViewById(R.id.edDate);
        radioGroup=findViewById(R.id.radioGroup);
        radioBtnMale=findViewById(R.id.radioBtnMale);
        radioBtnFemale = findViewById(R.id.radioBtnFemale);
//        checkBox1=findViewById(R.id.checkbox1);
//        checkBox2=findViewById(R.id.checkbox2);
//        checkBox3=findViewById(R.id.checkbox3);
//        ratingBar=findViewById(R.id.rating);
    }

    @Override
    public void onItemClick(View view, int position) {
        btnAdd.setEnabled(false);
        btnUpdate.setEnabled(true);
        positionCurrent = position;
        b6_Tour tour=adapter.getItem(position);
        int img= tour.getImg();
        int imgGenderr = tour.getImgGender();
        int p=0;
        for(int i=0;i<imgs.length;i++) {
            if(img==imgs[i]) {
                p=i;
                break;
            }
        }
        sp.setSelection(p);
        eSchedule.setText(tour.getSchedule());
        eTime.setText(tour.getTime());
        eClock.setText(tour.getClock());
        eDate.setText(tour.getDate());
        if(imgGenderr == R.drawable.male) {
            radioBtnMale.setChecked(true);
        } else {
            radioBtnFemale.setChecked(true);
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        filter(s);
        return false;
    }

    private void filter(String s) {
        List<b6_Tour> filterlist= new ArrayList<>();
        for(b6_Tour i: adapter.getBackup()) {
            if(i.getSchedule().toLowerCase().contains(s.toLowerCase())) {
                filterlist.add(i);
            }
        }
        if(filterlist.isEmpty()) {
            Toast.makeText(this,"No data found",Toast.LENGTH_SHORT).show();
        } else {
            adapter.filterList(filterlist);
        }
    }

    @Override
    public void onClick(View view) {
        Calendar c = Calendar.getInstance();
        if(view == eClock ) {
            int hh= c.get(Calendar.HOUR_OF_DAY);
            int mm= c.get(Calendar.MINUTE);
            TimePickerDialog dialog= new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int h, int m) {
                    eClock.setText(h+":"+m);
                }
            },hh,mm,false);
            dialog.show();
        }
        if(view == eDate ) {
            int dd= c.get(Calendar.DAY_OF_MONTH);
            int mm = c.get(Calendar.MONTH);
            int yy= c.get(Calendar.YEAR);
            DatePickerDialog dialog= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                    eDate.setText(d+"/"+(m+1)+"/"+y);
                }
            },yy,mm,dd);
            dialog.show();
        }
    }
}