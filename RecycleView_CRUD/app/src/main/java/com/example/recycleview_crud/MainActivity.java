package com.example.recycleview_crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.recycleview_crud.model.Cat;
import com.example.recycleview_crud.model.CatAdapter;
import com.example.recycleview_crud.model.SpinnerAdapter;

public class MainActivity extends AppCompatActivity implements CatAdapter.CatItemListener {
    private Spinner sp;
    private RecyclerView recyclerView;
    private CatAdapter adapter;
    private EditText eName,eDesc,ePrice;
    private Button btAdd,btUpdate;
    private int pcurr; //vị trí hiện tại chọn
    private int[] imgs={R.drawable.cat1,R.drawable.cat2,
            R.drawable.cat3,R.drawable.cat4,R.drawable.cat5,R.drawable.cat6};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        adapter=new CatAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);


        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cat cat = new Cat();
                String i=sp.getSelectedItem().toString();
                String name=eName.getText().toString();
                String desc=eDesc.getText().toString();
                String p=ePrice.getText().toString();
                int img=R.drawable.cat1;
                double price=0;
                try {
                    img=imgs[Integer.parseInt(i)];
                    price=Double.parseDouble(p);
                    cat.setImg(img);
                    cat.setName(name);
                    cat.setDescribe(desc);
                    cat.setPrice(price);
                    adapter.add(cat);
                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Nhập lại",Toast.LENGTH_LONG).show();
                }
            }
        });
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cat cat = new Cat();
                String i=sp.getSelectedItem().toString();
                String name=eName.getText().toString();
                String desc=eDesc.getText().toString();
                String p=ePrice.getText().toString();
                int img=R.drawable.cat1;
                double price=0;
                try {
                    img=imgs[Integer.parseInt(i)];
                    price=Double.parseDouble(p);
                    cat.setImg(img);
                    cat.setName(name);
                    cat.setDescribe(desc);
                    cat.setPrice(price);
                    adapter.udate(pcurr,cat);
                    btAdd.setEnabled(true);
                    btUpdate.setEnabled(false);
                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Nhập lại",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void initView() {
        sp=findViewById(R.id.img);
        SpinnerAdapter adapter=new SpinnerAdapter(this);
        sp.setAdapter(adapter);
        recyclerView=findViewById(R.id.recycleView);
        eName=findViewById(R.id.name);
        eDesc=findViewById(R.id.describe);
        ePrice=findViewById(R.id.price);
        btAdd=findViewById(R.id.btAdd);
        btUpdate=findViewById(R.id.btUpdate);
        btUpdate.setEnabled(false);
    }

    @Override
    public void onItemClick(View view, int position) {
        btAdd.setEnabled(false);
        btUpdate.setEnabled(true);

        pcurr=position;
        Cat cat=adapter.getItem(position);
        int img=cat.getImg();
        int p=0;
        for(int i=0;i<imgs.length;i++){
            if(img==imgs[i]){
                p=i;
                break;
            }
        }
        sp.setSelection(p);
        eName.setText(cat.getName());
        eDesc.setText(cat.getDescribe());
        ePrice.setText(cat.getPrice()+"");
    }
}