package com.www.socialx.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.www.socialx.R;
import com.www.socialx.adapter.muted_account_adapter;
import com.www.socialx.databinding.ActivityMutedAccountBinding;
import com.www.socialx.model.muted_account_model;

import java.util.ArrayList;

public class Muted_account extends AppCompatActivity {

    ActivityMutedAccountBinding binding;
    ArrayList<muted_account_model> values=new ArrayList<>();
    String title[]={"Sophie","Kinmberly","Sophie","Kinmberly","Sophie","Kinmberly","Sophie","Kinmberly"};
    String btn_title[]={"Unmute","Unmute","Unmute","Unmute","Unmute","Unmute","Unmute","Unmute"};
    int main_img[]={R.mipmap.muted_account_img1,R.mipmap.muted_account_img2,R.mipmap.muted_account_img1,R.mipmap.muted_account_img2,
            R.mipmap.muted_account_img1,R.mipmap.muted_account_img2,R.mipmap.muted_account_img1,R.mipmap.muted_account_img2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_muted_account);
       //recycler view
        for(int i=0;i<main_img.length;i++){
            muted_account_model model=new muted_account_model(title[i],btn_title[i],main_img[i]);
            values.add(model);
        }

        binding.mutedAccountRecycler.setLayoutManager(new LinearLayoutManager(this));
        muted_account_adapter adapter=new muted_account_adapter(this,values);
        binding.mutedAccountRecycler.setAdapter(adapter);
    }
}
