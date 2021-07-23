package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.ArraySet;
import android.widget.TextView;

import java.util.Set;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        SharedPreferences sharedPref = this.getSharedPreferences("file", Context.MODE_PRIVATE);
//SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        String name = sharedPref.getString("name1", "aa");
        int age = sharedPref.getInt("age1", 0);
        Set<String> S=new ArraySet<String>();
        sharedPref.getStringSet("set1", S);
        String msg = "Name: " + name + " - Age: " + age+" in the set "+S.toString();
        TextView t=(TextView)findViewById(R.id.Res2);
        t.setText(msg);
    }
}
