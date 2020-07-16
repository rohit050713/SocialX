package com.www.socialx.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.www.socialx.R;
import com.www.socialx.adapter.invite_adapter;
import com.www.socialx.model.invite_model;

import java.util.ArrayList;

public class Aboutme extends AppCompatActivity {

    ImageView back_btn;
    TextView about_me;
    //for invite dialog
    RecyclerView recyclerView;
    ArrayList<invite_model> values=new ArrayList<>();
    private int images[]={R.mipmap.invite_data_circular_image,R.mipmap.invite_data_circular_image,R.mipmap.invite_data_circular_image,R.mipmap.invite_data_circular_image,
            R.mipmap.invite_data_circular_image,R.mipmap.invite_data_circular_image,R.mipmap.invite_data_circular_image};
    private String title[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_me);

        //for getting values in the recycler view of invite dialog
        title=getResources().getStringArray(R.array.invite_title);
        for(int i=0;i<images.length;i++){
            invite_model model=new invite_model(images[i],title[i]);
            values.add(model);
        }

        //back button takes you to the terms activity
        back_btn=findViewById(R.id.iv_back_about_me);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Terms.class);
                startActivity(i);
            }
        });

        //for checking the invite dialog
        about_me=findViewById(R.id.tv_about_me);
        about_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog=new Dialog(Aboutme.this);
                dialog.setContentView(R.layout.dialog_invite);
                dialog.setCancelable(false);
                //send function
                TextView invite_send= dialog.findViewById(R.id.tv_invite_send);
                invite_send.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                //recycler view
                recyclerView= dialog.findViewById(R.id.invite_recyclerview);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                invite_adapter adapter=new invite_adapter(getApplicationContext(),values);
                recyclerView.setAdapter(adapter);
                if(dialog.getWindow()!=null){
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                }
                dialog.show();
            }
        });

    }
}
