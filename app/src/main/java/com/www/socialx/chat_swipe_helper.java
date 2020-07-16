package com.www.socialx;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.www.socialx.activity.Chat;

import static androidx.recyclerview.widget.ItemTouchHelper.*;


public class chat_swipe_helper extends ItemTouchHelper.Callback {

    //for button state
    enum ButtonsState {
        GONE,
        LEFT_VISIBLE,
        RIGHT_VISIBLE
    }
    private RectF buttonInstance = null;
    private boolean swipeBack= false;
    private ButtonsState buttonShowedState = ButtonsState.GONE;
    private static final float buttonWidth = 300;
    private RecyclerView.ViewHolder currentItemViewHolder = null;

    private ChatSwipeControllerActions buttonsActions = null;
    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        return makeMovementFlags(0,LEFT);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

    }

    // for holding the item in recycler view from whole item swiped
    @Override
    public int convertToAbsoluteDirection(int flags, int layoutDirection) {
      if(swipeBack){
          swipeBack = buttonShowedState != ButtonsState.GONE;
          return 0;
      }
        return super.convertToAbsoluteDirection(flags, layoutDirection);
    }

    // on touch listener on recycler view then swipe back will come

    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        if (actionState == ACTION_STATE_SWIPE) {
            if (buttonShowedState != ButtonsState.GONE) {
//                if (buttonShowedState == ButtonsState.LEFT_VISIBLE) dX = Math.max(dX, buttonWidth);
                if (buttonShowedState == ButtonsState.RIGHT_VISIBLE) dX = Math.min(dX, -buttonWidth);
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);


            }
            else {
                setTouchListener(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

            }
        }

        if (buttonShowedState == ButtonsState.GONE) {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }

        currentItemViewHolder = viewHolder;
    }


    private void setTouchListener(final Canvas c, final RecyclerView recyclerView, final RecyclerView.ViewHolder viewHolder, final float dX, final float dY, final int actionState, final boolean isCurrentlyActive) {
        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                swipeBack= event.getAction() == MotionEvent.ACTION_CANCEL || event.getAction() == MotionEvent.ACTION_UP;
                // for checking how much the item is swiped
                if(swipeBack){
                    if(dX < -buttonWidth)
                        buttonShowedState = ButtonsState.RIGHT_VISIBLE;
                    if(dX > buttonWidth)
                        buttonShowedState = ButtonsState.LEFT_VISIBLE;

                    if(buttonShowedState != ButtonsState.GONE){
                        setTouchDownListener(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
                        setItemsClickable(recyclerView,false);
                    }
                }
                return false;
            }


        });

    }
    // for no glitches we should disable on touch listeners on item if button is not gone
    private void setTouchDownListener(final Canvas c, final RecyclerView recyclerView, final RecyclerView.ViewHolder viewHolder, final float dX, final float dY, final int actionState, final boolean isCurrentlyActive){
        recyclerView.setOnTouchListener(new View.OnTouchListener() {
                                            @Override
                                            public boolean onTouch(View v, MotionEvent event) {
                                                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                                                    setTouchUpListener(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
                                                }
                                                return false;
                                            }
        });
    }

    // if recycler view is scrolled up or down it will reset the screen and item clicked
            private void setTouchUpListener(final Canvas c, final RecyclerView recyclerView, final RecyclerView.ViewHolder viewHolder, final float dX, final float dY,final int actionState, final boolean isCurrentlyActive) {
                recyclerView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if(event.getAction() == MotionEvent.ACTION_UP){
                            chat_swipe_helper.super.onChildDraw(c, recyclerView, viewHolder, 0F, dY, actionState, isCurrentlyActive);
                           // if anyother item is touched while the button is opened then the screen will be reset
                            recyclerView.setOnTouchListener(new View.OnTouchListener() {
                                @Override
                                public boolean onTouch(View v, MotionEvent event) {
                                    return false;
                                }
                            });
                            setItemsClickable(recyclerView,false);
                            swipeBack= false;

                            if ( buttonsActions != null && buttonInstance != null && buttonInstance.contains(event.getX(), event.getY())) {
                                if (buttonShowedState == ButtonsState.LEFT_VISIBLE) {
                                    buttonsActions.onLeftClicked(viewHolder.getAdapterPosition());
                                }
                                else if (buttonShowedState == ButtonsState.RIGHT_VISIBLE) {
                                    buttonsActions.onRightClicked(viewHolder.getAdapterPosition());
                                }
                            }
                            buttonShowedState = ButtonsState.GONE;
                            currentItemViewHolder = null;


                        }
                        return false;
                    }


                });

            }


    private void setItemsClickable(RecyclerView recyclerView, boolean isClickable) {
        for (int i = 0; i < recyclerView.getChildCount(); ++i) {
            recyclerView.getChildAt(i).setClickable(isClickable);
        }
    }

    // for drawing buttons in canvas
 private void drawButtons(Canvas c , RecyclerView.ViewHolder viewHolder){
        float buttonWidthWithoutPadding = buttonWidth;
//     float buttonWidthWithoutPadding1 = buttonWidth -20;


     float corner = 16;
        View itemView= viewHolder.itemView;
     Paint p=new Paint();
// first button
     RectF rightButton= new RectF(itemView.getRight() - buttonWidthWithoutPadding, itemView.getTop(), itemView.getRight(), itemView.getBottom());
     p.setColor(Color.rgb(255,69,0));
     c.drawRoundRect(rightButton, corner, corner, p);
     drawText(context,"DELETE", c, rightButton, p);

//     // second button
//     RectF rightButton2= new RectF(itemView.getRight()-buttonWidthWithoutPadding, itemView.getTop(), itemView.getRight(), itemView.getBottom());
//     p.setColor(Color.rgb(255,69,0));
//     c.drawRoundRect(rightButton2, corner, corner, p);
//     drawText(context,"MORE", c, rightButton2, p);
     // which button selected
     if (buttonShowedState == ButtonsState.RIGHT_VISIBLE) {
         buttonInstance = rightButton;
     }
 }

 // for drawing text in the button
    private void drawText(Context context,String text, Canvas c, RectF button, Paint p) {
        float textSize = 30;
//        p.setColor(Color.WHITE);
//        p.setAntiAlias(true);
//        p.setTextSize(textSize);
//
        float textWidth = p.measureText(text);
//        c.drawText(text, button.centerX()-(textWidth/2), button.centerY()+(textSize/2), p);

        // for 1st icon
       p.setColor(Color.WHITE);
       p.setAntiAlias(true);
        Drawable d= ContextCompat.getDrawable(context,R.drawable.chat_small_delete);
        Bitmap bitmap= DrawableToBitmap(d);
        c.drawBitmap(bitmap,button.centerX()-50, button.centerY()-(textSize/2),p);

        // for second icon


        Drawable d2= ContextCompat.getDrawable(context,R.drawable.chat_small_more_icon);
        Bitmap bitmap2= DrawableToBitmap(d2);
        c.drawBitmap(bitmap2,button.centerX()+60, button.centerY()-(textSize/2),p);



    }
    //for drawing again
    public void onDraw(Canvas c) {
        if (currentItemViewHolder != null) {
            drawButtons(c, currentItemViewHolder);
        }
    }
    // for action button
    Context context;
    public chat_swipe_helper(Context context,ChatSwipeControllerActions buttonsActions) {
        this.buttonsActions = buttonsActions;
        this.context=context;
    }

    // for bitmap icon
    private Bitmap DrawableToBitmap(Drawable d){
        if( d instanceof BitmapDrawable)
            return ((BitmapDrawable)d).getBitmap();
        Bitmap bitmap= Bitmap.createBitmap(d.getIntrinsicWidth(),d.getIntrinsicHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bitmap);
        d.setBounds(0,0,canvas.getWidth(),canvas.getHeight());
        d.draw(canvas);
        return bitmap;
    }

}
