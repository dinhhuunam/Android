package com.example.practice1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practice1.R;
import com.example.practice1.model.B12_Item;
import com.example.practice1.model.TH2_Song;

import java.util.ArrayList;
import java.util.List;

public class TH2_RecycleViewAdapter extends RecyclerView.Adapter<TH2_RecycleViewAdapter.HomeViewHolder> {

    private List<TH2_Song> list;
    private ItemListener itemListener;

    public TH2_RecycleViewAdapter() {
        list = new ArrayList<>();
    }

    public void setList(List<TH2_Song> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void setItemListener(ItemListener itemListener) {
        this.itemListener = itemListener;
    }

    public TH2_Song getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.th2_item,parent,false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        TH2_Song item= list.get(position);
        holder.name.setText(item.getName());
        holder.single.setText(item.getSingle());
        holder.type.setText(item.getType());
        holder.album.setText(item.getAlbum());
        if(item.getIsFavorite().equals("true")) {
            holder.isFavorite.setImageResource(R.drawable.ic_favorite);
        } else {
            holder.isFavorite.setImageResource(R.drawable.ic_not_favorite);
        }
//        holder.isFavorite.setImageResource(i);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView name, single, album, type;
        private ImageView isFavorite;
        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.tvName);
            single=itemView.findViewById(R.id.tvSingle);
            album=itemView.findViewById(R.id.tvAlbum);
            type=itemView.findViewById(R.id.tvType);
            isFavorite=itemView.findViewById(R.id.idFavorite);
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
