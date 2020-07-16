package com.www.socialx.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.www.socialx.ChatSwipeControllerActions;
import com.www.socialx.R;
import com.www.socialx.adapter.chat_adapter;
import com.www.socialx.adapter.chat_mylist_adapter;
import com.www.socialx.chat_swipe_helper;
import com.www.socialx.databinding.ActivityChatBinding;
import com.www.socialx.model.chat_model;

import java.util.ArrayList;

import static androidx.recyclerview.widget.ItemTouchHelper.LEFT;
import static androidx.recyclerview.widget.ItemTouchHelper.RIGHT;

public class Chat extends AppCompatActivity {

    chat_swipe_helper swipe_helper=null;
    ActivityChatBinding binding;
    ArrayList<chat_model> values=new ArrayList<>();
    String title[]={"Air Hostess Group","Alison Group","Jasmine Ellison","Working at urs","New Delhi Group","Sophie","Kinmberly","Sophie","Kinmberly","Sophie","Kinmberly"};
    String subtitle[]={"This group is only for air hostess","Lorem ipsum dolor sit amet, consectetur ","Lorem ipsum dolor sit amet, consectetur ","Lorem ipsum dolor sit amet, consectetur ",
            "Lorem ipsum dolor sit amet, consectetur ","Lorem ipsum dolor sit amet, consectetur ","Lorem ipsum dolor sit amet, consectetur ","Lorem ipsum dolor sit amet, consectetur "
    ,"Lorem ipsum dolor sit amet, consectetur ","Lorem ipsum dolor sit amet, consectetur ","Lorem ipsum dolor sit amet, consectetur "};
    String time[]={"14h","14h","14h","14h","14h","14h","14h","14h","14h","14h","14h"};
    String number[]={"5","5","5","5","5","5","5","5","5","5","5"};
    int main_img[]={R.mipmap.air_hostess,R.mipmap.invite_data_circular_image,R.mipmap.muted_account_img1,R.mipmap.muted_account_img2,
            R.mipmap.muted_account_img1,R.mipmap.muted_account_img2, R.mipmap.muted_account_img1,R.mipmap.muted_account_img2, R.mipmap.muted_account_img1,
            R.mipmap.muted_account_img2,R.mipmap.muted_account_img1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_chat);

        for(int i=0;i<main_img.length;i++){
            chat_model model= new chat_model(title[i],subtitle[i],time[i],number[i],main_img[i]);
            values.add(model);
        }

        binding.chatsRecycler.setLayoutManager(new LinearLayoutManager(this));
        final chat_adapter adapter=new chat_adapter(this,values);
        binding.chatsRecycler.setAdapter(adapter);



        //for bottom navigation item click listeners
        //for telescope
        binding.layoutTelescope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.textTelescope.setVisibility(View.VISIBLE);
                binding.imageTelescope.setVisibility(View.GONE);
                //all other textview visibility is gone
                binding.textChat.setVisibility(View.GONE);
                binding.textHome.setVisibility(View.GONE);
                binding.textFriends.setVisibility(View.GONE);
                binding.textDiscover.setVisibility(View.GONE);
                //all other image view should be visible
                binding.imageChat.setVisibility(View.VISIBLE);
                binding.imageHome.setVisibility(View.VISIBLE);
                binding.imageFriends.setVisibility(View.VISIBLE);
                binding.imageDiscover.setVisibility(View.VISIBLE);


            }
        });
        //for chat
         binding.layoutChat.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 binding.textChat.setVisibility(View.VISIBLE);
                 binding.imageChat.setVisibility(View.GONE);
                 //all other texview visibility is gone
                 binding.textTelescope.setVisibility(View.GONE);
                 binding.textHome.setVisibility(View.GONE);
                 binding.textFriends.setVisibility(View.GONE);
                 binding.textDiscover.setVisibility(View.GONE);
                 //all other image view should be visible
                 binding.imageTelescope.setVisibility(View.VISIBLE);
                 binding.imageHome.setVisibility(View.VISIBLE);
                 binding.imageFriends.setVisibility(View.VISIBLE);
                 binding.imageDiscover.setVisibility(View.VISIBLE);
             }
         });
         //for home
        binding.layoutHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.textHome.setVisibility(View.VISIBLE);
                binding.imageHome.setVisibility(View.GONE);
                //all other texview visibility is gone
                binding.textTelescope.setVisibility(View.GONE);
                binding.textChat.setVisibility(View.GONE);
                binding.textFriends.setVisibility(View.GONE);
                binding.textDiscover.setVisibility(View.GONE);
                //all other image view should be visible
                binding.imageTelescope.setVisibility(View.VISIBLE);
                binding.imageChat.setVisibility(View.VISIBLE);
                binding.imageFriends.setVisibility(View.VISIBLE);
                binding.imageDiscover.setVisibility(View.VISIBLE);
            }
        });





//             // FOR SWIPE OPTION
        final chat_swipe_helper swipe_helper = new chat_swipe_helper(this,new ChatSwipeControllerActions(){
            @Override
            public void onRightClicked(int position) {


            }
        });
        ItemTouchHelper itemTouchHelper= new ItemTouchHelper(swipe_helper);
        itemTouchHelper.attachToRecyclerView(binding.chatsRecycler);


        binding.chatsRecycler.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                swipe_helper.onDraw(c);
            }
        });
    }




}
