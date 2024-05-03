package com.example.practice1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practice1.R;
import com.example.practice1.model.B12_Item;

import java.util.ArrayList;
import java.util.List;

public class B12_RecycleViewAdapter extends RecyclerView.Adapter<B12_RecycleViewAdapter.HomeViewHolder> {

    private List<B12_Item> list;
    private ItemListener itemListener;

    public B12_RecycleViewAdapter() {
        list = new ArrayList<>();
    }

    public void setList(List<B12_Item> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void setItemListener(ItemListener itemListener) {
        this.itemListener = itemListener;
    }

    public B12_Item getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.b12_item,parent,false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        B12_Item item= list.get(position);
        holder.title.setText(item.getTitle());
        holder.category.setText(item.getCategory());
        holder.price.setText(item.getPrice());
        holder.date.setText(item.getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView title, category, price, date;
        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.tvTitle);
            category=itemView.findViewById(R.id.tvCategory);
            price=itemView.findViewById(R.id.tvPrice);
            date=itemView.findViewById(R.id.tvDate);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (itemListener!=null) {
                itemListener.onItemClick(view,getAdapterPosition());
            }
        }
    }

    public interface ItemListener {
        void onItemClick(View view, int position);
    }
}
