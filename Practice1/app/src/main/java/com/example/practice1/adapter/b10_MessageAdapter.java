package com.example.practice1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practice1.R;
import com.example.practice1.model.b10_Message;

import java.util.List;

public class b10_MessageAdapter extends RecyclerView.Adapter<b10_MessageAdapter.MesViewHolder>{

    private Context context;
    private List<b10_Message> list;

    public b10_MessageAdapter(Context context, List<b10_Message> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.b10_item_message,parent,false);
        return new MesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MesViewHolder holder, int position) {
        b10_Message s = list.get(position);
        holder.img.setImageResource(s.getImg());
        holder.name.setText(s.getName());
        holder.title.setText(s.getTitle());
        holder.time.setText(s.getTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MesViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView name, title, time;
        public MesViewHolder(@NonNull View itemView) {
            super(itemView);
            img= itemView.findViewById(R.id.img);
            name= itemView.findViewById(R.id.tName);
            title= itemView.findViewById(R.id.tTitle);
            time= itemView.findViewById(R.id.tTime);
        }
    }
}
