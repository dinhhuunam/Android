package com.example.practice1.model;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practice1.R;

import java.util.ArrayList;
import java.util.List;

public class b6_TourAdapter extends RecyclerView.Adapter<b6_TourAdapter.TourViewHolder>{

    private Context context;
//    private MainActivity mainActivity;
    private List<b6_Tour> list;
    private List<b6_Tour> listBackup;
    private TourItemListener tourItemListener;

//    public TourAdapter(MainActivity mainActivity) {
//        this.mainActivity= mainActivity;
//        list= new ArrayList<>();
//    }
    public b6_TourAdapter(Context context) {
        this.context = context;
        list= new ArrayList<>();
        listBackup=new ArrayList<>();
    }

    public List<b6_Tour> getBackup() {
        return listBackup;
    }
    public void filterList(List<b6_Tour> filterList) {
        list=filterList;
        notifyDataSetChanged();
    }


    public void setClickListener(TourItemListener tourItemListener){
        this.tourItemListener=tourItemListener;
    }

    @NonNull
    @Override
    public TourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.b6_item,parent,false);
        return new TourViewHolder(view);
    }

    public b6_Tour getItem(int position) {
        return list.get(position);
    }

    @Override
    public void onBindViewHolder(@NonNull TourViewHolder holder, int position) {
        b6_Tour tour= list.get(position);
        if (tour==null)
            return;
        holder.img.setImageResource(tour.getImg());
        holder.imgGender.setImageResource(tour.getImgGender());
        holder.tvSchedule.setText(tour.getSchedule());
        holder.tvTime.setText(tour.getTime());
        holder.tvClock.setText(tour.getClock());
        holder.tvDate.setText(tour.getDate());
        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder= new AlertDialog.Builder(context);
                builder.setTitle("Thong bao xoa");
                builder.setMessage("Ban co chac chan muon xoa "+tour.getSchedule()+" khong?");
                builder.setIcon(R.drawable.remove);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listBackup.remove(position);
                        list.remove(position);
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        if (list!=null) {
            return list.size();
        }
        return 0;
    }

    public void add(b6_Tour tour) {
        list.add(tour);
        listBackup.add(tour);
        notifyDataSetChanged();
    }
    public void update(int position, b6_Tour tour) {
        list.set(position,tour);
        listBackup.set(position,tour);
        notifyDataSetChanged();
    }

    public class TourViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView img, imgGender ;
        private TextView tvSchedule, tvTime, tvClock, tvDate;

        private Button btnRemove;
        public TourViewHolder(@NonNull View view) {
            super(view);
            img= view.findViewById(R.id.idCard);
            imgGender=view.findViewById(R.id.idGender);
            tvSchedule= view.findViewById(R.id.txtSchedule);
            tvTime= view.findViewById(R.id.txtTime);
            btnRemove = view.findViewById(R.id.btnRemove);
            tvClock=view.findViewById(R.id.txtClock);
            tvDate=view.findViewById(R.id.txtDate);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(tourItemListener!=null) {
                tourItemListener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    public interface TourItemListener {
        void onItemClick(View view, int position);
    }
}
