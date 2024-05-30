package com.example.recycleviewdemo.model;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleviewdemo.R;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder>{
    private Context context;
    private List<Cat> listBackUp;
    private List<Cat> mList;
    private CatItemListener mCatItem;
    public CatAdapter(Context context) {
        this.context = context;
        mList=new ArrayList<>();
        listBackUp=new ArrayList<>();
    }
    public List<Cat> getBackUp(){
        return listBackUp;
    }

    public void setmList(List<Cat> mList) {
        this.mList = mList;
    }
    public void filterList(List<Cat> filterlist){
        mList=filterlist;
        notifyDataSetChanged();
    }
    public void setClickListener(CatItemListener mCatItem){
        this.mCatItem=mCatItem;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new CatViewHolder(view);
    }
    public Cat getItem(int position){
        return mList.get(position);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        Cat cat=mList.get(position);
        if(cat==null)
            return;
        holder.img.setImageResource(cat.getImg());
        holder.tvName.setText(cat.getName());
        holder.tvDescribe.setText(cat.getDescribe());
        holder.tvPrice.setText(cat.getPrice()+"");

        //bắt sự kiện nút remove trên 1 viewholder
        holder.btRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                builder.setTitle("Thông báo xóa");
                builder.setMessage("Bạn có chắc chắn muốn xóa "+cat.getName()+" này không?");
                builder.setIcon(R.drawable.remove);
                //Đồng ý xóa
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //xóa ra khỏi danh sách
                        listBackUp.remove(position);
                        mList.remove(position);
                        notifyDataSetChanged();
                    }
                });
                //không xóa
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override  public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });
    }
    //phương thức để thêm vào adapter
    public void add(Cat c){
        listBackUp.add(c);

        mList.add(c);
        notifyDataSetChanged();
    }
    //phương thức để sửa
    public void update(int position,Cat cat){
        listBackUp.set(position,cat);
        mList.set(position,cat);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mList!=null)
            return mList.size();
        return 0;
    }
    public class CatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView img;
        private TextView tvName,tvDescribe,tvPrice;
        private Button btRemove;
        public CatViewHolder(@NonNull View view) {
            super(view);
            img=view.findViewById(R.id.img);
            tvName=view.findViewById(R.id.txtName);
            tvDescribe=view.findViewById(R.id.txtDescribe);
            tvPrice=view.findViewById(R.id.txtPrice);
            btRemove=view.findViewById(R.id.btnRemove);
            view.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            if(mCatItem!=null){
                mCatItem.onItemClick(view,getAdapterPosition());
            }
        }
    }
    //tạo 1 interface tạo sự kiện click chuột vào 1 đối tượng
    public interface CatItemListener{
        void onItemClick(View view,int position);
    }
}