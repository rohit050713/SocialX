package com.www.socialx.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.www.socialx.R;
import com.www.socialx.databinding.ActivityFilterBinding;

public class Filter extends AppCompatActivity {

    ActivityFilterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_filter);
     //filter button
       binding.btnFilterApply.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i=new Intent(Filter.this,Community_search.class);
               startActivity(i);
           }
       });
       // back button
        binding.ivBackFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Filter.this,Contact_us.class);
                startActivity(intent);
            }
        });
    }
}
