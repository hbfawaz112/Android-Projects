package com.example.hp.all_in_one;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TimePicker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);
        android.widget.TimePicker t=findViewById(R.id.time1);
        Calendar gregorianCalendar = new GregorianCalendar();
        int h = gregorianCalendar.get(Calendar.HOUR_OF_DAY)+1;
        int m =  gregorianCalendar.get(Calendar.MINUTE);
        t.setHour(h);
        t.setMinute(m);

        t.setOnTimeChangedListener(new android.widget.TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(android.widget.TimePicker view, int hourOfDay, int minute) {
                TextView t=findViewById(R.id.textView12);
                t.setText("Hours : "+hourOfDay+", minutes : "+minute);
                //Toast.makeText(getApplicationContext(),minute,Toast.LENGTH_SHORT).show();
            }
        });
        android.widget.TimePicker t1=findViewById(R.id.time2);
        t1.setHour(h);
        t1.setMinute(m);
        t1.setOnTimeChangedListener(new android.widget.TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(android.widget.TimePicker view, int hourOfDay, int minute) {
                TextView t=findViewById(R.id.textView13);
                t.setText("Hours : "+hourOfDay+", minutes : "+minute);
            }
        });
    }
}
