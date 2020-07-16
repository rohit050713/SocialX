package com.www.socialx.activity;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.www.socialx.R;
import com.www.socialx.databinding.ActivityReportProblemBinding;

public class Report_problem extends AppCompatActivity {

    ActivityReportProblemBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_report_problem);
        binding.ivBackReportPrblm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Report_problem.this,Help.class);
                startActivity(i);
            }
        });
    }


}
