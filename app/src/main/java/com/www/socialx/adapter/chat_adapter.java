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
import com.www.socialx.model.chat_model;

import java.util.ArrayList;

public class chat_adapter extends RecyclerView.Adapter<chat_adapter.ViewHolder> {

    Context context;
    private ArrayList<chat_model> arrayList;

    public chat_adapter(Context context, ArrayList<chat_model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_data,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    chat_model model= arrayList.get(position);

    holder.title.setText(model.getTitle());
    holder.subtitle.setText(model.getSubtitle());
    holder.time.setText(model.getTime());
    holder.number.setText(model.getNumber());
    holder.image.setImageResource(model.getImage());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       TextView title,subtitle,time,number;
       ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.tv_chat_title);
            subtitle=itemView.findViewById(R.id.tv_chat_subtitle);
            time=itemView.findViewById(R.id.tv_chat_time);
            number=itemView.findViewById(R.id.tv_chat_number);
            image=itemView.findViewById(R.id.iv_chat_mainimg);


        }
    }
}
