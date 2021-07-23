package com.example.mysql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView t;
    Assyc1 A;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=(TextView)findViewById(R.id.t);
        A=new Assyc1(t);
        A.execute();
    }
}
