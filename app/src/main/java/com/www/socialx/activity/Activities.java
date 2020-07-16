package com.www.socialx.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.www.socialx.R;
import com.www.socialx.adapter.activities_adapter;
import com.www.socialx.databinding.ActivityActivitiesBinding;
import com.www.socialx.model.activities_model;

import java.util.ArrayList;

public class Activities extends AppCompatActivity {

    ActivityActivitiesBinding binding;
    ArrayList<activities_model> values=new ArrayList<>();
    String title[]={"Jasmine Ellison","Jasmine Ellison","Jasmine Ellison","Jasmine Ellison"};
    String subtitle[]={"Liked your post","John doe comment on your feed","Liked your post","John doe comment on your feed"};
    String time[]={"1:30 PM","1:30 PM","1:30 PM","1:30 PM"};

    int main_img[]={R.mipmap.muted_account_img1,R.mipmap.muted_account_img2,R.mipmap.muted_account_img1,R.mipmap.muted_account_img2};
    int right_img[]={R.mipmap.activities_right_image,R.mipmap.activities_right_image,R.mipmap.activities_right_image,R.mipmap.activities_right_image};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_activities);
//recycler
       for(int i=0;i<main_img.length;i++){
           activities_model model=new activities_model(title[i],subtitle[i],time[i],main_img[i],right_img[i]);
           values.add(model);
       }
       binding.activitiesRecycler.setLayoutManager(new LinearLayoutManager(this));
        activities_adapter adapter=new activities_adapter(this,values);
       binding.activitiesRecycler.setAdapter(adapter);

//back button
        binding.ivBackActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Activities.this,Chat.class);
                startActivity(i);
            }
        });
    }
}
