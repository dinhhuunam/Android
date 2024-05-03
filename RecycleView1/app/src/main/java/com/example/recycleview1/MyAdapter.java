package com.example.recycleview1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private List<Bear> listBear;

    public MyAdapter(List<Bear> listBear) {
        this.listBear = listBear;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return listBear.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Bear bear = listBear.get(position);
        holder.imageView.setImageResource(bear.getImageId());
        holder.textView.setText(bear.getName());
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        private ImageView imageView;
        private TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_image_view);
            textView = itemView.findViewById(R.id.item_text);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }
}
