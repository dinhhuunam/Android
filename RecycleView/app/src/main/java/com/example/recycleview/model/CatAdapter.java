package com.example.recycleview.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.R;

import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder>{
    private List<Cat> mList;
    private Context context;
    private CatItemListener catItemListener;
    public CatAdapter(List<Cat> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    public CatItemListener getCatItemListener() {
        return catItemListener;
    }

    public void setCatItemListener(CatItemListener catItemListener) {
        this.catItemListener = catItemListener;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        Cat cat = mList.get(position);
        if(cat==null)
            return;
        holder.img.setImageResource(cat.getImg());
        holder.tv.setText(cat.getName());
    }

    @Override
    public int getItemCount() {
        if(mList!=null)
            return mList.size();
        return 0;
    }

    public class CatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView img;
        private TextView tv;
        public CatViewHolder(@NonNull View view) {
            super(view);
            img=view.findViewById(R.id.img);
            tv=view.findViewById(R.id.tname);
            view.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            if(catItemListener!=null){
                catItemListener.onItemClick(view,getAdapterPosition());
            }
        }
    }
    //Tạo 1 interface bắt sự kiện
    public interface CatItemListener{
        public void onItemClick(View view,int position);
    }
}
