package com.example.recycleviewdemo.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleviewdemo.R;

import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CartViewHolder> {
    private Context context;
    private List<Cat>mList;

    public CatAdapter(List<Cat> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position){
        Cat cat = mList.get(position);
        if (cat==null){
            return;
        }
        holder.img.setImageResource(cat.getImg());
        holder.tv.setText(cat.getName());
    }

    @Override
    public int getItemCount() {
        if(mList!=null){
            return mList.size();
        }
        return 0;
    }

    public class CartViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView tv;
        private CardView cardView;
        public CartViewHolder(@NonNull View view) {
            super(view);
            img=view.findViewById(R.id.img);
            tv=view.findViewById(R.id.tname);
            cardView=view.findViewById(R.id.cview);
        }
    }
}
