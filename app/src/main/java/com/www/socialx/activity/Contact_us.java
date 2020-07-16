package com.www.socialx.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.www.socialx.R;
import com.www.socialx.databinding.ActivityContactUsBinding;

public class Contact_us extends AppCompatActivity {

    ActivityContactUsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_contact_us);
       // for back button on click
        binding.ivBackContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Contact_us.this,Help.class);
                startActivity(i);
            }
        });


     //for dialog delete account
       binding.tvContactUs.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               final Dialog dialog=new Dialog(Contact_us.this);
               dialog.setContentView(R.layout.dialog_delete_account);
               dialog.setCancelable(false);
               //for cancel button
               TextView cancel= dialog.findViewById(R.id.tv_delete_account_cancel);
               cancel.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       dialog.dismiss();
                   }
               });
               //for delete button
               TextView delete= dialog.findViewById(R.id.tv_delete_account_delete);
               delete.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent intent=new Intent(Contact_us.this,Event.class);
                       startActivity(intent);
                   }
               });
               if(dialog.getWindow()!=null){
                   dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
               }
               dialog.show();
           }
       });
    }
}
