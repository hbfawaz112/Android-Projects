package com.example.bbmc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
//class of stock activity :

public class Stock extends AppCompatActivity {

    LinearLayout main;
    List<Donor> ds;
    DatabaseHandler db;
    Spinner s;
    Switch sw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);
        main = (LinearLayout) findViewById(R.id.main);
        sw=(Switch)findViewById(R.id.switch1);
        getSupportActionBar().hide();

        db = new DatabaseHandler(this);
        ds = new ArrayList<Donor>();
        ds = db.getAllDonros(); // [d1,d2,d3,//] d1=(1,hsein,fez,db,ph,blod)
        for (int i = 0; i < ds.size(); i++) {
            LinearLayout child = new LinearLayout(this);
            child.setOrientation(LinearLayout.HORIZONTAL);
            Donor d = ds.get(i);

            TextView textView1 = new TextView(this);

            s = (Spinner) findViewById(R.id.spinner);
            textView1.setText(d.getId() + "   ");

            TextView textView2 = new TextView(this);
            textView2.setText(d.getFname() + "   ");
            TextView textView3 = new TextView(this);
            textView3.setText(d.getLname() + "   ");
            TextView textView4 = new TextView(this);
            textView4.setText(d.getDatabirth() + "  ");
            TextView textView5 = new TextView(this);
            textView5.setText(d.getPhnb() + "   ");
            TextView textView6 = new TextView(this);
            textView6.setText(d.getBlood_type() + "   ");
            TextView textView7 = new TextView(this);
            textView7.setText(d.getIscorona() + "   ");


            child.addView(textView1);
            child.addView(textView2);
            child.addView(textView3);
            child.addView(textView4);
            child.addView(textView5);
            child.addView(textView6);
            child.addView(textView7);

            main.addView(child);
        }
    }

    public void stock(View view) {

        if (sw.isChecked()) {
            //Toast.makeText(this, "ONN", Toast.LENGTH_SHORT).show();
            ds.clear();
            main.removeAllViews();
            ds = db.getAllDonrosIC("yes");
            for (int i = 0; i < ds.size(); i++) {
                LinearLayout child = new LinearLayout(this);
                child.setOrientation(LinearLayout.HORIZONTAL);
                Donor d = ds.get(i);

                TextView textView1 = new TextView(this);

                s = (Spinner) findViewById(R.id.spinner);
                textView1.setText(d.getId() + "   ");

                TextView textView2 = new TextView(this);
                textView2.setText(d.getFname() + "   ");
                TextView textView3 = new TextView(this);
                textView3.setText(d.getLname() + "   ");
                TextView textView4 = new TextView(this);
                textView4.setText(d.getDatabirth() + "  ");
                TextView textView5 = new TextView(this);
                textView5.setText(d.getPhnb() + "   ");
                TextView textView6 = new TextView(this);
                textView6.setText(d.getBlood_type() + "   ");
                TextView textView7 = new TextView(this);
                textView7.setText(d.getIscorona() + "   ");


                child.addView(textView1);
                child.addView(textView2);
                child.addView(textView3);
                child.addView(textView4);
                child.addView(textView5);
                child.addView(textView6);
                child.addView(textView7);

                main.addView(child);
            }
        }


        if (!sw.isChecked()) {
           // Toast.makeText(this, "off", Toast.LENGTH_SHORT).show();
            ds.clear();
            main.removeAllViews();
            ds = db.getAllDonros();
            for (int i = 0; i < ds.size(); i++) {
                LinearLayout child = new LinearLayout(this);
                child.setOrientation(LinearLayout.HORIZONTAL);
                Donor d = ds.get(i);

                TextView textView1 = new TextView(this);

                s = (Spinner) findViewById(R.id.spinner);
                textView1.setText(d.getId() + "   ");

                TextView textView2 = new TextView(this);
                textView2.setText(d.getFname() + "   ");
                TextView textView3 = new TextView(this);
                textView3.setText(d.getLname() + "   ");
                TextView textView4 = new TextView(this);
                textView4.setText(d.getDatabirth() + "  ");
                TextView textView5 = new TextView(this);
                textView5.setText(d.getPhnb() + "   ");
                TextView textView6 = new TextView(this);
                textView6.setText(d.getBlood_type() + "   ");
                TextView textView7 = new TextView(this);
                textView7.setText(d.getIscorona() + "   ");


                child.addView(textView1);
                child.addView(textView2);
                child.addView(textView3);
                child.addView(textView4);
                child.addView(textView5);
                child.addView(textView6);
                child.addView(textView7);

                main.addView(child);
            }
        }
    }


    public void search(View view) {
        String seleted = s.getSelectedItem().toString();
        //Toast.makeText(this,"s "+s ,Toast.LENGTH_LONG).show();
        ds.clear();

        main.removeAllViews();

        ds = db.getAllDonrosBD(seleted);
        for (int i = 0; i < ds.size(); i++) {
            LinearLayout child = new LinearLayout(this);
            child.setOrientation(LinearLayout.HORIZONTAL);
            Donor d = ds.get(i);

            TextView textView1 = new TextView(this);

            s = (Spinner) findViewById(R.id.spinner);
            textView1.setText(d.getId() + "   ");

            TextView textView2 = new TextView(this);
            textView2.setText(d.getFname() + "   ");
            TextView textView3 = new TextView(this);
            textView3.setText(d.getLname() + "   ");
            TextView textView4 = new TextView(this);
            textView4.setText(d.getDatabirth() + "  ");
            TextView textView5 = new TextView(this);
            textView5.setText(d.getPhnb() + "   ");
            TextView textView6 = new TextView(this);
            textView6.setText(d.getBlood_type() + "   ");
            TextView textView7 = new TextView(this);
            textView7.setText(d.getIscorona() + "   ");


            child.addView(textView1);
            child.addView(textView2);
            child.addView(textView3);
            child.addView(textView4);
            child.addView(textView5);
            child.addView(textView6);
            child.addView(textView7);

            main.addView(child);


        }
    }
}