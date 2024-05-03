package com.example.practice1.adapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practice1.b9_MainActivity2;
import com.example.practice1.R;
import com.example.practice1.model.b9_Tour2;

import java.util.ArrayList;
import java.util.List;

public class b9_TourAdapter extends RecyclerView.Adapter<b9_TourAdapter.TourViewHolder>{

//    private Context context;
    private b9_MainActivity2 mainActivity;
    private List<b9_Tour2> list;
//    private List<Tour> listBackup;
    private TourItemListener tourItemListener;

    public b9_TourAdapter(b9_MainActivity2 mainActivity) {
        this.mainActivity= mainActivity;
        list= new ArrayList<>();
    }

//    public TourAdapter(Context context) {
//        this.context = context;
//        list= new ArrayList<>();
//        listBackup=new ArrayList<>();
//    }

//    public List<Tour> getBackup() {
//        return listBackup;
//    }
//    public void filterList(List<Tour> filterList) {
//        list=filterList;
//        notifyDataSetChanged();
//    }


    public void setClickListener(TourItemListener tourItemListener){
        this.tourItemListener=tourItemListener;
    }

    @NonNull
    @Override
    public TourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.b9_item2,parent,false);
        return new TourViewHolder(view);
    }

    public b9_Tour2 getItem(int position) {
        return list.get(position);
    }
    public List<b9_Tour2> getList() {
        return list;
    }

    @Override
    public void onBindViewHolder(@NonNull TourViewHolder holder, int position) {
//        Tour tour= list.get(position);
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
        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder= new AlertDialog.Builder(view.getContext());
                builder.setTitle("Thong bao xoa");
                builder.setMessage("Ban co chac chan muon xoa "+tour.getSchedule()+" khong?");
                builder.setIcon(R.drawable.remove);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                        listBackup.remove(position);
                        list.remove(position);
                        mainActivity.list.remove(position);
//                        mainActivity.list=list;
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
//        if (list!=null) {
//            return list.size();
//        }
//        return 0;
        return  list.size();
    }

    public void add(b9_Tour2 tour) {
        list.add(tour);
//        listBackup.add(tour);
        notifyDataSetChanged();
//        mainActivity.list=list;
        mainActivity.list.add(tour);
    }
    public void update(int position, b9_Tour2 tour) {
        list.set(position,tour);
//        listBackup.set(position,tour);
        notifyDataSetChanged();
//        mainActivity.list=list;
        mainActivity.list.set(position,tour);
    }

    public class TourViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
//public class TourViewHolder extends RecyclerView.ViewHolder{
//        private ImageView img, imgGender ;
//        private TextView tvSchedule, tvTime, tvClock, tvDate;
        private ImageView img ;
        private TextView tvSchedule, tvTime, tvPrice;

        private Button btnRemove;
        public TourViewHolder(@NonNull View view) {
            super(view);
            img= view.findViewById(R.id.item_img);
//            imgGender=view.findViewById(R.id.idGender);
            ////////////???? edSchedule
            tvSchedule= view.findViewById(R.id.txtSchedule);
            tvTime= view.findViewById(R.id.txtTime);
            tvPrice=view.findViewById(R.id.txtPrice);
            btnRemove = view.findViewById(R.id.btnRemove);
            btnRemove.setOnClickListener(this);
//            tvClock=view.findViewById(R.id.txtClock);
//            tvDate=view.findViewById(R.id.txtDate);
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
