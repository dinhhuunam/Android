package com.example.practice1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practice1.R;
import com.example.practice1.model.b9_Tour2;

import java.util.ArrayList;
import java.util.List;

public class b9_SearchAdapter extends RecyclerView.Adapter<b9_SearchAdapter.SearchViewHolder> {

    private List<b9_Tour2> list;
//    private List<Tour2> listBackup;

    public b9_SearchAdapter() {
        list= new ArrayList<>();
//        listBackup=new ArrayList<>();
    }

    public void setList(List<b9_Tour2> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    public List<b9_Tour2> getList() {
        return list;
    }

//    public List<Tour2> getBackup() {
//        return listBackup;
//    }
//    public void filterList(List<Tour2> filterList) {
//        list=filterList;
//        notifyDataSetChanged();
//    }

    public b9_Tour2 getItem(int position) {
        return list.get(position);
    }
    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.b9_item_search,parent,false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        b9_Tour2 tour= list.get(position);
        if (tour==null)
            return;
        holder.img.setImageResource(tour.getImg());
//        holder.imgGender.setImageResource(tour.getImgGender());
        holder.tvSchedule.setText(tour.getSchedule());
        holder.tvTime.setText(tour.getTime());
        holder.tvPrice.setText(tour.getPrice()+"");
//        holder.tvClock.setText(tour.getClock());
//        holder.tvDate.setText(tour.getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {

//        private ImageView img, imgGender ;
//        private TextView tvSchedule, tvTime, tvClock, tvDate;

        private ImageView img ;
        private TextView tvSchedule, tvTime, tvPrice;
        public SearchViewHolder(@NonNull View view) {
            super(view);
            img= view.findViewById(R.id.item_img);
//            imgGender=view.findViewById(R.id.idGender);
            tvSchedule= view.findViewById(R.id.txtSchedule);
            tvTime= view.findViewById(R.id.txtTime);
            tvPrice=view.findViewById(R.id.txtPrice);
//            tvClock=view.findViewById(R.id.txtClock);
//            tvDate=view.findViewById(R.id.txtDate);
//            view.setOnClickListener(this);
        }
    }
}
