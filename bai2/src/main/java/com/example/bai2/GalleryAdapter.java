package com.example.bai2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {
    private List<String> item;
    private Context context;

private PhotoListener photoListener;

    public GalleryAdapter(List<String> item, Context context, PhotoListener photoListener) {
        this.item = item;
        this.context = context;
        this.photoListener = photoListener;
    }

    public GalleryAdapter(List<String> items) {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item, parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String items = item.get(position);
        Glide.with(context).load(items).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photoListener.onClickPhoto(items);
                Toast.makeText(context, "hello", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{

      ImageView imageView;

        public ViewHolder(@NonNull View itemView){

            super(itemView);

            imageView =itemView.findViewById(R.id.imageView);
        }
    }
    public interface PhotoListener{
        void onClickPhoto(String path);
    }

}
