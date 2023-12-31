package com.inatboxtvapkindirinfo.inat.adapaters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.inatboxtvapkindirinfo.inat.R;


import java.util.ArrayList;


public class inatboxtvapkindir5_AdapterVideoList extends RecyclerView.Adapter< inatboxtvapkindir5_AdapterVideoList.MyViewHolder> {

    ArrayList< inatboxtvapkindir5_ModelVideo > videosList = new ArrayList< inatboxtvapkindir5_ModelVideo >();
    Context context;

    public inatboxtvapkindir5_AdapterVideoList(Context context, ArrayList< inatboxtvapkindir5_ModelVideo > videosList){
        this.context = context;
        this.videosList = videosList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.inatboxtvapkindir5_row_video, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final inatboxtvapkindir5_ModelVideo item = videosList.get(position);

        Glide.with(context).load(item.getData()).into(holder.imgView_thumbnail);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), inatboxtvapkindir5_play.class);
                intent.putExtra("videoId", item.getId());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return videosList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgView_thumbnail;
        TextView tv_title, tv_duration;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgView_thumbnail = itemView.findViewById(R.id.imageView_thumbnail);
        }
    }
}
