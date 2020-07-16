package com.www.socialx.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.www.socialx.R;
import com.www.socialx.model.invite_model;

import java.util.ArrayList;

public class invite_adapter extends RecyclerView.Adapter<invite_adapter.ViewHolder> {
 private Context context;
 private ArrayList arrayList;

    public invite_adapter(Context context, ArrayList arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.invite_data,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        invite_model model= (invite_model) arrayList.get(position);
        holder.main_img.setImageResource(model.getMain_img());
        holder.title.setText(model.getTitle());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       ImageView main_img;
       TextView title;
       CheckBox checkbox;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            main_img=itemView.findViewById(R.id.iv_invite_main_img);
            title=itemView.findViewById(R.id.tv_invite_title);
            checkbox=itemView.findViewById(R.id.invite_checkbox);
        }
    }
}
