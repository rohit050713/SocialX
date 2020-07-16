package com.www.socialx.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.www.socialx.R;
import com.www.socialx.databinding.ActivityPrivacyBinding;

public class Privacy extends AppCompatActivity {

    ActivityPrivacyBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_privacy);

        //clicking textview blocked account
        binding.tvBlockedAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Privacy.this,Activities.class);
                startActivity(i);
            }
        });

        //clicking textview muted account
        binding.tvPrivacyMutedAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Privacy.this,Muted_account.class);
                startActivity(intent);
            }
        });

        // back button
        binding.ivBackPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Privacy.this,Edit_event.class);
                startActivity(i);
            }
        });
    }
}
