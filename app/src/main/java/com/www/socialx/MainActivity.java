package com.www.socialx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.www.socialx.activity.Community_filter;
import com.www.socialx.activity.Myrewards;
import com.www.socialx.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
      // textview of main activity(about us)
       binding.tvAboutus.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i=new Intent(MainActivity.this, Myrewards.class);
               startActivity(i);
           }
       });
       //back button of main activity(about us)
       binding.ivBackAboutUs.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(MainActivity.this, Community_filter.class);
               startActivity(intent);
           }
       });
    }
}
