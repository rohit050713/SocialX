package com.www.socialx.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Adapter;

import com.www.socialx.R;
import com.www.socialx.adapter.community_adapter;
import com.www.socialx.databinding.ActivityEventBinding;
import com.www.socialx.model.community_model;

import java.util.ArrayList;

public class Event extends AppCompatActivity {

    ActivityEventBinding binding;
    ArrayList<community_model> values1=new ArrayList<>();
    ArrayList<community_model> values2=new ArrayList<>();
    String subtitle[]={"Shopping","Shopping","Shopping","Shopping"};
    int img1[]={R.mipmap.community_data_balloons,R.mipmap.community_data_balloons,R.mipmap.community_data_balloons,R.mipmap.community_data_balloons};
    int img2[]={R.mipmap.community_data_travelling,R.mipmap.community_data_travelling,R.mipmap.community_data_travelling,R.mipmap.community_data_travelling};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_event);

        //for 1st recycler view
        for(int i=0;i<img1.length;i++){
            community_model model1=new community_model(subtitle[i],img1[i]);
            values1.add(model1);
        }
        binding.eventRecycler1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        community_adapter adapter1=new community_adapter(this,values1);
        binding.eventRecycler1.setAdapter(adapter1);
        //for 2nd recycler view
        for(int i=0;i<img2.length;i++){
            community_model model2=new community_model(subtitle[i],img2[i]);
            values2.add(model2);
        }
        binding.eventRecycler2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        community_adapter adapter2=new community_adapter(this,values2);
        binding.eventRecycler2.setAdapter(adapter2);

    }
}
