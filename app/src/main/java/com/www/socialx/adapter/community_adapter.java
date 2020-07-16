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
import com.www.socialx.model.community_model;

import java.security.acl.LastOwnerException;
import java.util.ArrayList;

public class community_adapter extends RecyclerView.Adapter<community_adapter.ViewHolder> {

  Context context;
  ArrayList<community_model> arrayList;

    public community_adapter(Context context, ArrayList<community_model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.community_data,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      community_model model= arrayList.get(position);
      holder.tv_community.setText(model.getTv_community());
      holder.iv_community.setImageResource(model.getIv_community());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       TextView tv_community;
       ImageView iv_community;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_community=itemView.findViewById(R.id.tv_community);
            iv_community=itemView.findViewById(R.id.iv_community_image);

        }
    }
}
