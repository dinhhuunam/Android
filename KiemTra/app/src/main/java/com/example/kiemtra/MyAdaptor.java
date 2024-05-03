package com.example.kiemtra;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kiemtra.model.Book;

import java.util.ArrayList;
import java.util.List;

public class MyAdaptor extends RecyclerView.Adapter<MyAdaptor.MyHolderView>{

    private Context context;
    private List<Book> books;

    public MyAdaptor(Context context) {
        this.context = context;
        books =new ArrayList<>();
    }

    @NonNull
    @Override
    public MyHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        return new MyHolderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolderView holder, int position) {
        Book book=books.get(position);
        if(book==null)
            return;
        holder.tenSach.setText(book.getTenSach());

    }

    @Override
    public int getItemCount() {
        if(books !=null){
            return books.size();
        }
        return 0;
    }

    public class MyHolderView extends RecyclerView.ViewHolder {
        private CardView cardView;
        private TextView tenSach;
        private CheckBox theLoai;
        private TextView thoiGian;
        private Button btnDelete;
        public MyHolderView(@NonNull View view) {
            super(view);
            cardView = view.findViewById(R.id.card_view);
            tenSach = view.findViewById(R.id.sach);
            thoiGian= view.findViewById(R.id.thoigian);
        }
    }
}
