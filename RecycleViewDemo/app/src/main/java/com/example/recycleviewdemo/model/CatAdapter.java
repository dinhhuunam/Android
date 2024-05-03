package com.example.recycleviewdemo.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleviewdemo.R;

import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CartViewHolder> {
    //private Context context;
    private List<Cat>mList;
    private CatItemListener catItemListener;
    public CatAdapter(List<Cat> mList) {
        this.mList = mList;
    }
//    public CatAdapter(Context context, List<Cat> mList) {
//        this.context = context;
//        this.mList = mList;
//    }

    public CatItemListener getCatItemListener() {
        return catItemListener;
    }
    public void setCatItemListener(CatItemListener catItemListener) {
        this.catItemListener = catItemListener;
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
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context.getApplicationContext(),cat.getName(),Toast.LENGTH_LONG).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        if(mList!=null){
            return mList.size();
        }
        return 0;
    }

    public class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView img;
        private TextView tv;
        private CardView cardView;
        public CartViewHolder(@NonNull View view) {
            super(view);
            img=view.findViewById(R.id.img);
            tv=view.findViewById(R.id.tname);
            cardView=view.findViewById(R.id.cview);
            view.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            if(catItemListener!=null){
                catItemListener.onItemClick(view,getAdapterPosition());
            }
        }
    }

    public interface CatItemListener{
        public void onItemClick(View view,int position);
    }
}
