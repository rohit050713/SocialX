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
import com.www.socialx.model.community_search_model;

import java.util.ArrayList;

public class community_search_adapter extends RecyclerView.Adapter<community_search_adapter.ViewHolder> {
   Context context;
    ArrayList<community_search_model> arrayList;

    public community_search_adapter(Context context, ArrayList<community_search_model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.community_search_data,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     community_search_model model= arrayList.get(position);
     holder.title.setText(model.getTitle());
     holder.subtitle1.setText(model.getSubtitle1());
        holder.subtitle2.setText(model.getSubtitle2());
        holder.subtitle3.setText(model.getSubtitle3());

        holder.img1.setImageResource(model.getImg1());
        holder.img2.setImageResource(model.getImg2());
        holder.img3.setImageResource(model.getImg3());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       TextView title,subtitle1,subtitle2,subtitle3;
       ImageView img1,img2,img3;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.tv_community_search_main);
            subtitle1=itemView.findViewById(R.id.tv_community1);
            subtitle2=itemView.findViewById(R.id.tv_community2);
            subtitle3=itemView.findViewById(R.id.tv_community3);

            img1=itemView.findViewById(R.id.iv_community_image1);
            img2=itemView.findViewById(R.id.iv_community_image2);
            img3=itemView.findViewById(R.id.iv_community_image3);




        }
    }
}
