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
import com.www.socialx.model.activities_model;

import java.util.ArrayList;

public class activities_adapter extends RecyclerView.Adapter<activities_adapter.Viewholder> {

    Context context;
    ArrayList<activities_model> arrayList;

    public activities_adapter(Context context, ArrayList<activities_model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activities_data,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
      activities_model model= arrayList.get(position);
        holder.title.setText(model.getTitle());
        holder.subtitle.setText(model.getSubtile());
        holder.time.setText(model.getTime());
        holder.main_img.setImageResource(model.getMain_img());
        holder.right_img.setImageResource(model.getRight_img());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
       TextView title,subtitle,time;
       ImageView main_img,right_img;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.tv_activities_title);
            subtitle=itemView.findViewById(R.id.tv_activities_subtitle);
            time=itemView.findViewById(R.id.tv_activities_time);
            main_img=itemView.findViewById(R.id.iv_activities_mainimg);
            right_img=itemView.findViewById(R.id.iv_activities_right_image);

        }
    }
}
