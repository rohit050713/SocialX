package com.www.socialx.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.www.socialx.R;
import com.www.socialx.adapter.myrewards_adapter;
import com.www.socialx.databinding.ActivityMyrewardsBinding;
import com.www.socialx.model.myrewards_model;

import java.util.ArrayList;

public class Myrewards extends AppCompatActivity {

    private ActivityMyrewardsBinding binding;
    private ArrayList<myrewards_model> values=new ArrayList<>();
    int main_img[]={R.mipmap.my_rewards_data__holi_dhanaka,R.mipmap.my_rewards_data__holi_dhanaka,R.mipmap.my_rewards_data__holi_dhanaka,R.mipmap.my_rewards_data__holi_dhanaka};
    int reward_img[]={R.mipmap.my_rewards_data_trophy,R.mipmap.my_rewards_data_trophy,R.mipmap.my_rewards_data_trophy,R.mipmap.my_rewards_data_trophy};
    String title[],date[],time[],point[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_myrewards);
      //for getting value for textview
       title=getResources().getStringArray(R.array.title);
        date=getResources().getStringArray(R.array.date);
        time=getResources().getStringArray(R.array.time);
        point=getResources().getStringArray(R.array.point);
//recycler view
        binding.recyclerviewReward.setLayoutManager(new LinearLayoutManager(this));

       for(int i=0;i<main_img.length;i++){
           myrewards_model model= new myrewards_model(main_img[i],reward_img[i],title[i],date[i],time[i],point[i]);
           values.add(model);
       }
        myrewards_adapter adapter=new myrewards_adapter(this,values);
       binding.recyclerviewReward.setAdapter(adapter);

       //back button takes you to change password activity
        binding.ivBackRewards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Myrewards.this,Changepassword.class);
                startActivity(i);
            }
        });
    }
}
