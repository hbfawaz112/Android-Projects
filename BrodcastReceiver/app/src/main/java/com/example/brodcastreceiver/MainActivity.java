package com.example.brodcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.renderscript.Int4;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyReceiver myReceiver=new MyReceiver();
        registerReceiver(myReceiver,new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));
    }
}
