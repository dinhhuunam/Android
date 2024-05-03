package model;

import android.annotation.SuppressLint;
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

import com.example.crud_th1.R;

import java.util.ArrayList;
import java.util.List;

public class CellPhoneAdapter extends RecyclerView.Adapter<CellPhoneAdapter.CellPhoneViewHolder> {

    private Context context;
    private List<CellPhone> mList;
    private List<CellPhone> listBackup;
    private PhoneItemListener itemListener;

    public CellPhoneAdapter(Context context) {
        this.context = context;
        this.mList = new ArrayList<>();
        this.listBackup = new ArrayList<>();
    }
    public List<CellPhone> getBackup() {
        return listBackup;
    }
    public void setClickListener(PhoneItemListener itemListener) {
        this.itemListener = itemListener;
    }
    @NonNull
    @Override
    public CellPhoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new CellPhoneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CellPhoneViewHolder holder, @SuppressLint("RecyclerView") int position) {
        CellPhone phone = mList.get(position);
        if(phone==null) return;
        holder.img.setImageResource(phone.getImg());
        holder.tvName.setText(phone.getName());
        holder.tvOrigin.setText(phone.getOrigin());
        holder.tvPrice.setText(phone.getPrice()+"$");

        holder.btRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Confirm");
                builder.setMessage("Ban co muon xoa dien thoai "+ phone.getName()+" nay khong ?");
                builder.setIcon(R.drawable.delete);
                builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mList.remove(position);
                        listBackup.remove(position);
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
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
        if(mList!=null)
            return mList.size();
        return 0;
    }

    public void add(CellPhone phone) {
        mList.add(phone);
        listBackup.add(phone);
        notifyDataSetChanged();
    }

    public void update(int position, CellPhone phone){
        mList.set(position,phone);
        listBackup.set(position,phone);
        notifyDataSetChanged();
    }
    public CellPhone getItem(int position){
        return mList.get(position);
    }

    public void setmList(List<CellPhone> mList){
        this.mList = mList;
    }
    public void filterList(List<CellPhone> filterList) {
        mList = filterList;
        notifyDataSetChanged();
    }

    public class CellPhoneViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView img;
        private TextView tvName, tvCompany, tvOrigin, tvPrice;
        private Button btRemove;
        public CellPhoneViewHolder(@NonNull View view) {
            super(view);
            img = view.findViewById(R.id.img);
            tvName = view.findViewById(R.id.tvName);
            tvOrigin = view.findViewById(R.id.tvOrigin);
            tvPrice = view.findViewById(R.id.tvPrice);
            btRemove = view.findViewById(R.id.btRemove);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(itemListener != null){
                itemListener.onItemClick(view, getAdapterPosition());
            }
        }
    }
    public interface PhoneItemListener{
        void onItemClick(View view, int position);
    }
}
