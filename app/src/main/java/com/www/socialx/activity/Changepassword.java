package com.www.socialx.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;

import com.www.socialx.R;
import com.www.socialx.databinding.ActivityChangepasswordBinding;

import java.util.regex.Pattern;

public class Changepassword extends AppCompatActivity {
//regex for password without space
    private static final Pattern password= Pattern.compile("^[a-zA-Z0-9~!@#$%^&*()_+=-]{6,}$");
    private ActivityChangepasswordBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_changepassword);

       //back button takes you to about me activity
       binding.ivBackChangePassword.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i=new Intent(Changepassword.this,Aboutme.class);
               startActivity(i);
           }
       });

       //validate old password
       binding.etOldPasword.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {
               String old_pwd= binding.etOldPasword.getText().toString().trim();
               if(old_pwd.isEmpty()){
                   binding.tvOldpassworderror.setText("*Please enter valid old password.");
                   binding.tvOldpassworderror.setVisibility(View.VISIBLE);
               }
             else  if(!password.matcher(old_pwd).matches()){
                   binding.tvOldpassworderror.setText("*Please enter valid old password.");
                   binding.tvOldpassworderror.setVisibility(View.VISIBLE);
               }
               else{
                   binding.tvOldpassworderror.setVisibility(View.INVISIBLE);
               }
           }

           @Override
           public void afterTextChanged(Editable s) {

           }
       });

       //validation new password
       binding.etNewPassword.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {
            String new_pwd=binding.etNewPassword.getText().toString().trim();
            if(new_pwd.isEmpty()){
                binding.tvNewpassworderror.setText("*Please enter at least 6 character.");
                binding.tvNewpassworderror.setVisibility(View.VISIBLE);
            }
           else if(!password.matcher(new_pwd).matches()){
                binding.tvNewpassworderror.setText("*Please enter at least 6 character.");
                binding.tvNewpassworderror.setVisibility(View.VISIBLE);
            }
            else {
                binding.tvNewpassworderror.setVisibility(View.INVISIBLE);
            }
           }

           @Override
           public void afterTextChanged(Editable s) {

           }
       });

       //validation confirm password
       binding.etConfirmPassword.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {
          String cnf_pwd=binding.etConfirmPassword.getText().toString().trim();
          String new_pwd=binding.etNewPassword.getText().toString().trim();
          if(cnf_pwd.isEmpty()){
              binding.tvConfirmpassworderror.setText("*Please retype new password.");
              binding.tvConfirmpassworderror.setVisibility(View.VISIBLE);
          }
          else if(!cnf_pwd.equals(new_pwd)){
              binding.tvConfirmpassworderror.setText("*Please retype new password.");
              binding.tvConfirmpassworderror.setVisibility(View.VISIBLE);
          }
          else{
              binding.tvConfirmpassworderror.setVisibility(View.INVISIBLE);
          }
           }

           @Override
           public void afterTextChanged(Editable s) {

           }
       });
    }

    public boolean old_pwd(){
        String old_pwd= binding.etOldPasword.getText().toString().trim();
        if(old_pwd.isEmpty()){
            binding.tvOldpassworderror.setText("*Please enter valid old password.");
            binding.tvOldpassworderror.setVisibility(View.VISIBLE);
            return false;
        }
      else  if(!password.matcher(old_pwd).matches()){
            binding.tvOldpassworderror.setText("*Please enter valid old password.");
            binding.tvOldpassworderror.setVisibility(View.VISIBLE);
            return false;
        }
        else{
            binding.tvOldpassworderror.setVisibility(View.INVISIBLE);
            return true;
        }
    }

    public boolean new_pwd(){
        String new_pwd=binding.etNewPassword.getText().toString().trim();
        if(new_pwd.isEmpty()){
            binding.tvNewpassworderror.setText("*Please enter at least 6 character.");
            binding.tvNewpassworderror.setVisibility(View.VISIBLE);
            return false;
        }
      else  if(!password.matcher(new_pwd).matches()){
            binding.tvNewpassworderror.setText("*Please enter at least 6 character.");
            binding.tvNewpassworderror.setVisibility(View.VISIBLE);
            return false;
        }
        else {
            binding.tvNewpassworderror.setVisibility(View.INVISIBLE);
            return true;
        }
    }
    public boolean cnf_pwd(){
        String cnf_pwd=binding.etConfirmPassword.getText().toString().trim();
        String new_pwd=binding.etNewPassword.getText().toString().trim();
        if(cnf_pwd.isEmpty()){
            binding.tvConfirmpassworderror.setText("*Please retype new password.");
            binding.tvConfirmpassworderror.setVisibility(View.VISIBLE);
            return false;
        }
       else if(!cnf_pwd.equals(new_pwd)){
            binding.tvConfirmpassworderror.setText("*Please retype new password.");
            binding.tvConfirmpassworderror.setVisibility(View.VISIBLE);
            return false;
        }
        else{
            binding.tvConfirmpassworderror.setVisibility(View.INVISIBLE);
            return true;
        }
    }
    //update button
    public void update(View view){
        if(!old_pwd() | !new_pwd() | !cnf_pwd()){
           return;
        }
        else{
            Intent i=new Intent(Changepassword.this,Myrewards.class);
            startActivity(i);
        }
    }
}
