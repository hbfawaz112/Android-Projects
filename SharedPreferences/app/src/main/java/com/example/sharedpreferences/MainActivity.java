package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.ArraySet;
import android.view.View;
import android.widget.EditText;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click(View v)
    {
        SharedPreferences sharedPref =this.getSharedPreferences("file", Context.MODE_PRIVATE);
        SharedPreferences.Editor e = sharedPref.edit();
        EditText name=(EditText) findViewById(R.id.editText);
        EditText id=(EditText) findViewById(R.id.editText2);
        e.putString("name1",name.getText().toString());
        e.putInt("age1", Integer.parseInt(id.getText().toString()));
// string set
        Set<String> S=new ArraySet<String>();
        S.add("hello");
        S.add("I am");
        e.putStringSet("set1", S);
        e.commit();

        Intent I= new Intent(this,Main2Activity.class);
        startActivity(I);
    }
}
