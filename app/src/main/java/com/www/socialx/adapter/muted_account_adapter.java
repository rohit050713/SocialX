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
import com.www.socialx.model.muted_account_model;

import java.util.ArrayList;

public class muted_account_adapter extends RecyclerView.Adapter<muted_account_adapter.ViewHolder> {
  Context context;
  ArrayList<muted_account_model> arrayList;

    public muted_account_adapter(Context context, ArrayList<muted_account_model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.muted_account_data,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      muted_account_model model= arrayList.get(position);
      holder.title.setText(model.getTitle());
      holder.btn_title.setText(model.getBtn_title());
      holder.main_img.setImageResource(model.getMain_image());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       ImageView main_img;
       TextView title,btn_title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            main_img=itemView.findViewById(R.id.iv_mainimg_muted_account);
            title=itemView.findViewById(R.id.tv_title_muted_account);
            btn_title=itemView.findViewById(R.id.tv2_muted_account);
        }
    }
}
