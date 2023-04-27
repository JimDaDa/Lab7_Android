package com.example.a51900491_lab7;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserPhoneAdapter extends RecyclerView.Adapter<UserPhoneAdapter.ViewHolder>{
    private List<UserPhone> dataList= new ArrayList<>();

    public UserPhoneAdapter(List<UserPhone> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_phone, parent,false);
        return new UserPhoneAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserPhone userPhone = dataList.get(position);
        holder.name.setText(userPhone.name);
        holder.phoneNumber.setText(userPhone.phoneNumber);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{
        private LinearLayout linearLayout;
        private TextView name, phoneNumber;
        public ViewHolder(@NonNull View itemView){

            super(itemView);
           linearLayout = itemView.findViewById(R.id.linearLayout);
           name = itemView.findViewById(R.id.name);
           phoneNumber = itemView.findViewById(R.id.phoneNumber);
         linearLayout.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.add(this.getAdapterPosition(), 101, 0, "Call");
        }
    }


}
