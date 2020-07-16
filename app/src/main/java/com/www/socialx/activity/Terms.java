package com.www.socialx.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.www.socialx.MainActivity;
import com.www.socialx.R;

public class Terms extends AppCompatActivity {

    ImageView back_btn;
    TextView terms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terms);

        //back button takes you to the mainactivity
        back_btn=findViewById(R.id.iv_back_terms);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Terms.this, MainActivity.class);
                startActivity(i);
            }
        });

        //for checking logout dialog
        terms=findViewById(R.id.tv_terms);
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog=new Dialog(Terms.this);
                dialog.setContentView(R.layout.dialog_logout);

                dialog.setCancelable(false);

                // yes/no of dialog box
                TextView logout_no= dialog.findViewById(R.id.tv_logout_no);
                logout_no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                TextView logout_yes= dialog.findViewById(R.id.tv_logout_yes);
                logout_yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
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
