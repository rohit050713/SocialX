package com.www.socialx.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.www.socialx.R;
import com.www.socialx.model.chat_model;

import java.util.ArrayList;
import java.util.List;

public class chat_mylist_adapter extends ArrayAdapter<chat_model> {
   Context context;
   int resource;
   ArrayList<chat_model> arrayList;

    public chat_mylist_adapter(Context context, int resource,ArrayList<chat_model> arrayList) {
        super(context, resource, arrayList);
        this.context=context;
        this.resource=resource;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    chat_model model = arrayList.get(position);



      convertView = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        TextView title= convertView.findViewById(R.id.tv_chat_title);
        TextView subtitle= convertView.findViewById(R.id.tv_chat_subtitle);
        TextView time= convertView.findViewById(R.id.tv_chat_time);
        TextView number= convertView.findViewById(R.id.tv_chat_number);
        ImageView image= convertView.findViewById(R.id.iv_chat_mainimg);

        title.setText(model.getTitle());
        subtitle.setText(model.getSubtitle());
        time.setText(model.getTime());
        number.setText(model.getNumber());
        image.setImageResource(model.getImage());

        return convertView;

    }
}
