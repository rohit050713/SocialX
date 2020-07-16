package com.www.socialx.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.www.socialx.R;
import com.www.socialx.adapter.community_adapter;
import com.www.socialx.databinding.ActivityCommunityFilterBinding;
import com.www.socialx.model.community_model;

import java.util.ArrayList;

public class Community_filter extends AppCompatActivity {

    ActivityCommunityFilterBinding binding;
    int image[]={R.mipmap.community_data_balloons,R.mipmap.community_data_travelling,R.mipmap.community_data_travelling};
    String tv[]={"Ballons","Travelling","Travelling"};
    ArrayList<community_model> values=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_community_filter);

       //for recycler view
       for(int i=0;i<image.length;i++){
           community_model model= new community_model(tv[i],image[i]);
           values.add(model);
       }
       binding.communityRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        community_adapter adapter=new community_adapter(this,values);
        binding.communityRecycler.setAdapter(adapter);

        binding.ivCommunitySortIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Community_filter.this,Filter.class);
                startActivity(intent);
            }
        });

    }
}
