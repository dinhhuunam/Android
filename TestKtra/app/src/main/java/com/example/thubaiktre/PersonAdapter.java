package com.example.thubaiktre;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private Context context;
    private ArrayList<Nguoi> personList;

    private ArrayList<Nguoi> searchList;
    private PersonItemListener personItemListener;

    public ArrayList<Nguoi> getListSearch() {
        return searchList;
    }

    public PersonAdapter(Context context) {
        this.context = context;
        personList = new ArrayList<>();
        searchList = new ArrayList<>();
    }

    public void filterList(ArrayList<Nguoi> filterlist) {
        personList = filterlist;
        notifyDataSetChanged();
    }

    public void setClickListener(PersonItemListener personItemListener) {
        this.personItemListener = personItemListener;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder personViewHolder, int position) {
        Nguoi nguoi = personList.get(position);
        if (nguoi == null) {
            return;
        }
        personViewHolder.avatar.setImageResource(nguoi.getImg());
        personViewHolder.tvJob.setText(nguoi.getCongviec());
        personViewHolder.tvNgay.setText(nguoi.getNgay());
        personViewHolder.btnRmove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Thông báo xóa!");
                builder.setMessage("Bạn có muốn xóa " + nguoi.getTen() + " không ?");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        searchList.remove(position);
                        personList.remove(position);
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (personList != null) {
            return personList.size();
        }
        return 0;
    }

    public void add(Nguoi nguoi) {
        searchList.add(nguoi);
        personList.add(nguoi);
        notifyDataSetChanged();
    }

    public void edit(int position, Nguoi nguoi) {
        searchList.set(position,nguoi);
        personList.set(position, nguoi);
        notifyDataSetChanged();
    }

    public Nguoi getItem(int i) {
        return personList.get(i);
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView avatar;
        private TextView tvJob, tvNgay;
        private Button btnRmove;

        public PersonViewHolder(@NonNull View view) {
            super(view);
            avatar = view.findViewById(R.id.avata);
            tvJob = view.findViewById(R.id.congviec);
            tvNgay = view.findViewById(R.id.ngay);
            btnRmove = view.findViewById(R.id.btnRemove);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (personItemListener != null) {
                personItemListener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    public interface PersonItemListener {
        void onItemClick(View view, int position);
    }
}
