package com.www.socialx.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.SpinnerAdapter;
import android.widget.TimePicker;

import com.www.socialx.R;
import com.www.socialx.databinding.ActivityEditEventBinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Edit_event extends AppCompatActivity {

    private int mYear,mMonth,mDay;
    ActivityEditEventBinding binding;
    String event_category[]={"Singing","Dancing","Theatre"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_edit_event);

       // for spinner
        binding.spinnerChat.setAdapter(new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_dropdown_item,event_category));



        // for date picker dialog or calendar
        binding.linearlayoutEditEventCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c= Calendar.getInstance();
                mYear=c.get(Calendar.YEAR);
                mMonth=c.get(Calendar.MONTH);
                mDay=c.get(Calendar.DAY_OF_MONTH);



                DatePickerDialog datePickerDialog= new DatePickerDialog(Edit_event.this,new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // format the style of the date
                        SimpleDateFormat dateFormat= new SimpleDateFormat("dd MMM yyyy");
                        c.set(year,month,dayOfMonth);
                        String date = dateFormat.format(c.getTime());
                        binding.tvEditEventDate.setText(date);
                    }
                },mYear,mMonth,mDay);
                // for disabling datee after current date

                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                datePickerDialog.show();

            }
        });

        // for time picker dialog or clock for first
        binding.linearlayoutEditEventTime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c= Calendar.getInstance();
                int hour= c.get(Calendar.HOUR_OF_DAY);
                int minute=c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog=new TimePickerDialog(Edit_event.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        binding.tvEditEventTime1.setText(hourOfDay+" : "+minute);
                    }
                },hour,minute,false);
                timePickerDialog.show();
            }
        });

        // for time picker dialog or clock for second box
        binding.linearlayoutEditEventTime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c= Calendar.getInstance();
                int hour= c.get(Calendar.HOUR_OF_DAY);
                int minute=c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog=new TimePickerDialog(Edit_event.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        binding.tvEditEventTime2.setText(hourOfDay+" : "+minute);
                    }
                },hour,minute,false);
                timePickerDialog.show();
            }
        });
    }


}
