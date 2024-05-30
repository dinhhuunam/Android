package com.example.recycleview_th;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{
    private Context context;
    private List<User> mList;
    private UserItemListener userItemListener;
    public UserAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<User> list){
        this.mList = list;
        //notifyDataSetChanged();
    }

    public UserItemListener getUserItemListener() {
        return userItemListener;
    }

    public void setUserItemListener(UserItemListener userItemListener) {
        this.userItemListener = userItemListener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mList.get(position);
        if(user==null)
            return;
        holder.img.setImageResource(user.getResourceId());
        holder.tv.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        if(mList!=null)
            return mList.size();
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView img;
        private TextView tv;
        public UserViewHolder(@NonNull View view) {
            super(view);
            img=view.findViewById(R.id.img_user);
            tv=view.findViewById(R.id.tv_name);
        }

        @Override
        public void onClick(View view) {
            if(userItemListener!=null){
                userItemListener.onItemClick(view,getAdapterPosition());
            }
        }
    }
    public interface UserItemListener{
        void onItemClick(View view,int position);
    }
}