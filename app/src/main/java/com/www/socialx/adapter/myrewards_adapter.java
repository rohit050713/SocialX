package com.www.socialx.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.www.socialx.R;
import com.www.socialx.model.myrewards_model;

import java.util.ArrayList;

public class myrewards_adapter extends RecyclerView.Adapter<myrewards_adapter.ViewHolder> {

    public myrewards_adapter(Context context, ArrayList arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    private Context context;
    private ArrayList arrayList;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_rewards_data,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        myrewards_model model= (myrewards_model) arrayList.get(position);
        holder.main_image.setImageResource(model.getMainimage());
        holder.reward_point_image.setImageResource(model.getIv_rewards_point());
        holder.title.setText(model.getTitle());
        holder.date.setText(model.getDate());
        holder.time.setText(model.getTime());
        holder.points.setText(model.getRewardspoint());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView main_image,reward_point_image;
        TextView title,date,time,points;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            main_image=itemView.findViewById(R.id.iv_mainimg);
            reward_point_image=itemView.findViewById(R.id.iv_rewards_point);
            title=itemView.findViewById(R.id.tv_title);
            date=itemView.findViewById(R.id.tv_date);
            time=itemView.findViewById(R.id.tv_time);
            points=itemView.findViewById(R.id.rewards_point);


        }
    }
}
