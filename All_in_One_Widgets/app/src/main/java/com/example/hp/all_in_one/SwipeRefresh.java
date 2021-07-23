package com.example.hp.all_in_one;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SwipeRefresh extends AppCompatActivity {
    ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh);
        arrayList=new ArrayList<>();
        SwipeRefreshLayout s=findViewById(R.id.swipe);
        s.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fonction1();
            }
        });
    }
    private void fonction1(){
        for(int j = 0; j < 20; j++)
            arrayList.add("text " +j);
        SwipeRefreshLayout s=findViewById(R.id.swipe);
        ListView l=findViewById(R.id.listView1);
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        l.setAdapter(arrayAdapter);
        Toast.makeText(getApplicationContext(), "refreshed", Toast.LENGTH_LONG).show();
        s.setRefreshing(false);
    }
}
