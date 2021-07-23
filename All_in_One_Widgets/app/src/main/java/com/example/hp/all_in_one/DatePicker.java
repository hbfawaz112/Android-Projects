package com.example.hp.all_in_one;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ScrollView;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DatePicker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);
        ScrollView s=findViewById(R.id.scrollview2);


        android.widget.DatePicker d=findViewById(R.id.datePicker1);
        Calendar gregorianCalendar = new GregorianCalendar();
        int day = gregorianCalendar.get(Calendar.DAY_OF_MONTH);
        int month =  gregorianCalendar.get(Calendar.MONTH);
        int year = gregorianCalendar.get(Calendar.YEAR);
        d.init(year, month, day, new android.widget.DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(android.widget.DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                android.widget.DatePicker d=findViewById(R.id.datePicker2);
                d.updateDate(year,monthOfYear,dayOfMonth);
            }
        });
    }
}
