package com.www.socialx.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.www.socialx.R;
import com.www.socialx.adapter.community_search_adapter;
import com.www.socialx.databinding.ActivityCommunitySearchBinding;
import com.www.socialx.model.community_search_model;

import java.util.ArrayList;

public class Community_search extends AppCompatActivity {

    ActivityCommunitySearchBinding binding;
    String title[]={"Nature","Gaming","Music","Gaming"};
    String subtitle1[]={"Tourism","Tourism","Tourism","Tourism"};
    String subtitle2[]={"Nature","Nature","Nature","Nature"};
    String subtitle3[]={"Plants","Plants","Plants","Plants"};
    ArrayList<community_search_model> values=new ArrayList<>();

    int img1[]={R.mipmap.community_search_data_tourism,R.mipmap.community_search_data_tourism,R.mipmap.community_search_data_tourism,R.mipmap.community_search_data_tourism};
    int img2[]={R.mipmap.community_search_data_nature,R.mipmap.community_search_data_nature,R.mipmap.community_search_data_nature,R.mipmap.community_search_data_nature};
    int img3[]={R.mipmap.community_search_data_plants,R.mipmap.community_search_data_plants,R.mipmap.community_search_data_plants,R.mipmap.community_search_data_plants};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_community_search);

        //for recycler view
        for (int i=0;i<img1.length;i++){
            community_search_model model= new community_search_model(title[i],subtitle1[i],subtitle2[i],subtitle3[i],img1[i],img2[i],img3[i]);
            values.add(model);
        }
        binding.communitySearchRecycler.setLayoutManager(new LinearLayoutManager(this));
        community_search_adapter adapter=new community_search_adapter(this,values);
        binding.communitySearchRecycler.setAdapter(adapter);

    }
}
