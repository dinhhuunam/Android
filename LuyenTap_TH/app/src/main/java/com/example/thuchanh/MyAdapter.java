package com.example.thuchanh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thuchanh.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private Context context;
    private List<Employee> employees;
    private EmployeeListener eItem;

    public MyAdapter(Context context) {
        this.context = context;
        employees = new ArrayList<>();
    }

    public void setClickListener(EmployeeListener eItem){
        this.eItem=eItem;
    }

    public Employee getEmployee(int position){
        return employees.get(position);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Employee employee=employees.get(position);
        if(employee==null)
            return;
        int imgId=employee.getGt()==Employee.MALE ? R.drawable.cat1 :  R.drawable.cat2;
        holder.textView.setText(employee.getMaNV()+"-"+employee.getTenNv());

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                employees.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    public void add(Employee employee){
        employees.add(employee);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if(employees!=null){
            return employees.size();
        }
        return 0;
    }

    public void update(int position, Employee employee){
        employees.set(position,employee);
        notifyDataSetChanged();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private CardView cardView;
        private ImageView imageView;
        private TextView textView;
        private Button btnDelete;

        public MyViewHolder(@NonNull View view) {
            super(view);
            cardView=view.findViewById(R.id.card_view);
            imageView=view.findViewById(R.id.img);
            textView=view.findViewById(R.id.text_view);
            btnDelete=view.findViewById(R.id.btnRemove);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(eItem!=null){
                eItem.onItemClick(view,getAdapterPosition());
            }
        }
    }
    public interface EmployeeListener{
        void onItemClick(View view,int position);
    }
}
