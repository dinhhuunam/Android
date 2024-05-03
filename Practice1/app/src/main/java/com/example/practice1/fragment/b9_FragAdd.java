package com.example.practice1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practice1.b9_MainActivity2;
import com.example.practice1.R;
import com.example.practice1.adapter.b9_SpinnerAdapter;
import com.example.practice1.adapter.b9_TourAdapter;
import com.example.practice1.model.b9_Tour2;

public class b9_FragAdd extends Fragment implements b9_TourAdapter.TourItemListener{
//public class FragAdd extends Fragment implements TourAdapter.TourItemListener, View.OnClickListener{
    private b9_TourAdapter adapter;
    private Spinner spinner;
//    private EditText eSchedule, eTime, eClock, eDate;
    private EditText eSchedule, eTime, ePrice;
    private Button btnAdd, btnUpdate;
    private int positionCurrent;
    private RecyclerView recyclerView;
//    private RadioGroup radioGroup;
//    private RadioButton radioBtnMale, radioBtnFemale;
//    private CheckBox checkBox1, checkBox2, checkBox3;
//    private RatingBar ratingBar;
    private int[] imgs = {R.drawable.car, R.drawable.plane, R.drawable.moto};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.b9_frag_add,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        ////////updated
//        adapter = new TourAdapter(this);
        adapter= new b9_TourAdapter((b9_MainActivity2) getActivity());
        GridLayoutManager manager = new GridLayoutManager(view.getContext(),1);
//        LinearLayoutManager manager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);
        // updated
//        eClock.setOnClickListener(this);
//        eDate.setOnClickListener(this);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                b9_Tour2 tour= new b9_Tour2();
                String i = spinner.getSelectedItem().toString();
                String schedule = eSchedule.getText().toString();
                String time = eTime.getText().toString();
                String price = ePrice.getText().toString();
//                String clock = eClock.getText().toString();
//                String date= eDate.getText().toString();
                int img=R.drawable.car;
//                int radioId= radioGroup.getCheckedRadioButtonId();
                try {
//                    if(radioId == R.id.radioBtnMale) {
//                        // note update
//                        Toast.makeText(getContext(),"male",Toast.LENGTH_SHORT).show();
//                        tour.setImgGender(R.drawable.male);
//                    } else {
//                        tour.setImgGender(R.drawable.female);
//                    }
                    img = imgs[Integer.parseInt(i)];
                    // neu co price thi parse price Double.parseDoule tai day
//                    tour.setImg(img);
//                    Toast.makeText(getApplicationContext(),schedule,Toast.LENGTH_SHORT).show();
//                    if(!schedule.equals("") && !time.equals("")) {
//                        tour.setSchedule(schedule);
//                        tour.setTime(time);
//                        tour.setPrice(Double.parseDouble(price));
//                        tour.setClock(clock);
//                        tour.setDate(date);
//                        adapter.add(tour);
                        adapter.add(new b9_Tour2(img,schedule,time,Double.parseDouble(price)));
//                    } else {
//                        Toast.makeText(getContext(),"Nhap lai",Toast.LENGTH_SHORT).show();
//                    }

                } catch (NumberFormatException e) {
                    Toast.makeText(getContext(),"Nhap lai",Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                b9_Tour2 tour= new b9_Tour2();
                String i = spinner.getSelectedItem().toString();
                String schedule = eSchedule.getText().toString();
                String time = eTime.getText().toString();
                String price = ePrice.getText().toString();
//                String clock = eClock.getText().toString();
//                String date = eDate.getText().toString();
                int img=R.drawable.car;
//                int radioId= radioGroup.getCheckedRadioButtonId();


                try {
//                    if(radioId == R.id.radioBtnMale) {
//                        tour.setImgGender(R.drawable.male);
//                    } else {
//                        tour.setImgGender(R.drawable.female);
//                    }
                    img = imgs[Integer.parseInt(i)];
                    // neu co price thi parse price Double.parseDoule tai day
//                    tour.setImg(img);
//                    Toast.makeText(getApplicationContext(),schedule,Toast.LENGTH_SHORT).show();
//                    if(!schedule.equals("") && !time.equals("")) {
//                        tour.setSchedule(schedule);
//                        tour.setTime(time);
//                        tour.setPrice(Double.parseDouble(price));
//                        tour.setClock(clock);
//                        tour.setDate(date);
                        adapter.update(positionCurrent,new b9_Tour2(img,schedule,time,Double.parseDouble(price)));
                        btnAdd.setEnabled(true);
//                        btnUpdate.setEnabled(false);
                        btnUpdate.setVisibility(View.INVISIBLE);
//                    } else {
//                        Toast.makeText(getContext(),"Nhap lai",Toast.LENGTH_SHORT).show();
//                    }

                } catch (NumberFormatException e) {
                    Toast.makeText(getContext(),"Nhap lai",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void initView(View view) {
        spinner = view.findViewById(R.id.imgSpinner);
        b9_SpinnerAdapter adapter = new b9_SpinnerAdapter(getContext(),imgs);
        spinner.setAdapter(adapter);

        recyclerView= view.findViewById(R.id.recycleView);
        eSchedule= view.findViewById(R.id.edSchedule);
        eTime = view.findViewById(R.id.edTime);
        ePrice=view.findViewById(R.id.edPrice);
        btnAdd = view.findViewById(R.id.btnAdd);
        btnUpdate=view.findViewById(R.id.btnUpdate);
//        btnUpdate.setEnabled(false);
        btnUpdate.setVisibility(View.INVISIBLE);
//        searchView=findViewById(R.id.search);
//        eClock= view.findViewById(R.id.edClock);
//        eDate= view.findViewById(R.id.edDate);
//        radioGroup=view.findViewById(R.id.radioGroup);
//        radioBtnMale=view.findViewById(R.id.radioBtnMale);
//        radioBtnFemale = view.findViewById(R.id.radioBtnFemale);
//        checkBox1=findViewById(R.id.checkbox1);
//        checkBox2=findViewById(R.id.checkbox2);
//        checkBox3=findViewById(R.id.checkbox3);
//        ratingBar=findViewById(R.id.rating);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getContext(),"sua lai",Toast.LENGTH_SHORT).show();
        btnAdd.setEnabled(false);
        btnUpdate.setVisibility(View.VISIBLE);
//        btnUpdate.setEnabled(true);
        positionCurrent = position;
        b9_Tour2 tour=adapter.getItem(position);
        int img= tour.getImg();
//        int imgGenderr = tour.getImgGender();
        int p=0;
        for(int i=0;i<imgs.length;i++) {
            if(img==imgs[i]) {
                p=i;
                break;
            }
        }
        spinner.setSelection(p);
        eSchedule.setText(tour.getSchedule());
        eTime.setText(tour.getTime());
        ePrice.setText(tour.getPrice()+"");
//        eClock.setText(tour.getClock());
//        eDate.setText(tour.getDate());
//        if(imgGenderr == R.drawable.male) {
//            radioBtnMale.setChecked(true);
//        } else {
//            radioBtnFemale.setChecked(true);
//        }
    }

//    public void onClick(View view) {
//        Calendar c = Calendar.getInstance();
//        if(view == eClock ) {
//            int hh= c.get(Calendar.HOUR_OF_DAY);
//            int mm= c.get(Calendar.MINUTE);
//            // updated
//            TimePickerDialog dialog= new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
//                @Override
//                public void onTimeSet(TimePicker timePicker, int h, int m) {
//                    eClock.setText(h+":"+m);
//                }
//            },hh,mm,false);
//            dialog.show();
//        }
//        if(view == eDate ) {
//            int dd= c.get(Calendar.DAY_OF_MONTH);
//            int mm = c.get(Calendar.MONTH);
//            int yy= c.get(Calendar.YEAR);
//            DatePickerDialog dialog= new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
//                @Override
//                public void onDateSet(DatePicker datePicker, int y, int m, int d) {
//                    eDate.setText(d+"/"+(m+1)+"/"+y);
//                }
//            },yy,mm,dd);
//            dialog.show();
//        }
//    }
}
