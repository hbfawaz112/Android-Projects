package com.example.hp.all_in_one;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SeekBar extends AppCompatActivity {
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);

        android.widget.SeekBar s=findViewById(R.id.seekBar);
        t=findViewById(R.id.textView9);
        s.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(android.widget.SeekBar seekBar, int progress, boolean fromUser) {
                t.setText(progress +"%");
            }

            @Override
            public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
                t.setVisibility(View.VISIBLE);
            }

            @Override
            public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
                t.setVisibility(View.INVISIBLE);
            }
        });

        android.widget.SeekBar s1=findViewById(R.id.seekBar2);
        t=findViewById(R.id.textView9);
        s1.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(android.widget.SeekBar seekBar, int progress, boolean fromUser) {
                t.setText(progress +"%");
            }

            @Override
            public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
                t.setVisibility(View.VISIBLE);
            }

            @Override
            public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
                t.setVisibility(View.INVISIBLE);
            }
        });
    }
}
