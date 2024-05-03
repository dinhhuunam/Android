package model;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crud_th1.R;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private Context context;
    private List<Book> mList;
    private List<Book> listBackup;
//    private CellPhoneAdapter.PhoneItemListener itemListener;
    public BookAdapter(Context context) {
        this.context = context;
        this.mList = new ArrayList<>();
        this.listBackup = new ArrayList<>();
    }
    public Book getItem(int position){
        return mList.get(position);
    }
    public List<Book> getBackup() {
        return listBackup;
    }
//    public void setClickListener(BookAdapter.PhoneItemListener itemListener) {
//        this.itemListener = itemListener;
//    }
    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new BookAdapter.BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Book book = mList.get(position);
        if(book==null) return;

        holder.tvName.setText(book.getTen());
        holder.tvNXB.setText(book.getNxb());
        List<String> list = new ArrayList<>();
        list = book.getTheloai();
        if(list.contains("Khoa hoc")){
            holder.cb1.setChecked(true);
        }else {
            holder.cb1.setChecked(false);
        }
        if(list.contains("Tieu thuyet")){
            holder.cb2.setChecked(true);
        }else {
            holder.cb2.setChecked(false);
        }
        if(list.contains("Thieu nhi")){
            holder.cb3.setChecked(true);
        }else {
            holder.cb3.setChecked(false);
        }

        holder.btRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Confirm");
                builder.setMessage("Ban co muon xoa sach "+ book.getTen()+" nay khong ?");
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
    public void add(Book book) {
        mList.add(book);
        listBackup.add(book);
        notifyDataSetChanged();
    }

    public void update(int position, Book book){
        mList.set(position,book);
        listBackup.set(position,book);
        notifyDataSetChanged();
    }
    public class BookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView tvName, tvNXB;
        private CheckBox cb1,cb2,cb3;
        private Button btRemove;
        public BookViewHolder(@NonNull View view) {
            super(view);
            tvName = view.findViewById(R.id.tvName);
            tvNXB = view.findViewById(R.id.tvNXB);
            cb1 = view.findViewById(R.id.cb1);
            cb2 = view.findViewById(R.id.cb2);
            cb3 = view.findViewById(R.id.cb3);
            btRemove = view.findViewById(R.id.btRemove);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }

//        @Override
//        public void onClick(View view) {
//            if(itemListener != null){
//                itemListener.onItemClick(view, getAdapterPosition());
//            }
//        }
    }
}

