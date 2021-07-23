package com.example.hp.all_in_one;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.github.arturogutierrez.Badges;
import com.github.arturogutierrez.BadgesNotSupportedException;

public class Badge extends AppCompatActivity {
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badge);
        count=0;
    }
    public void add(View view){
        try {
            Badges.setBadge(getApplicationContext(), ++count);
        }catch (BadgesNotSupportedException e){
            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
        }
    }
    public void sous(View view) throws BadgesNotSupportedException {
        try{
           Badges.setBadge(getApplicationContext(),--count);
        }catch (BadgesNotSupportedException e){
            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
        }
    }
    public void remove(View view) throws BadgesNotSupportedException {
        try{
            Badges.removeBadge(getApplicationContext());
        }catch (BadgesNotSupportedException e){
            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
        }
    }
}
