package com.example.bbmc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
//Dashboard class who take the data :

public class Dashboard extends AppCompatActivity {
DatabaseHandler db1 ;
    ProgressBar pb;
    TextView counter;
    List<Donor> l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().hide();

        db1 = new DatabaseHandler(this);
        pb = (ProgressBar)findViewById(R.id.progressBar);
        counter = (TextView)findViewById(R.id.counter);

        int cc=db1.count_donors();

        pb.setMax(20);
        pb.setProgress(cc);
        counter.setText("Donors Count : " +cc);


         //l = new ArrayList<Donor>();
        //l=db1.getAllDonros();


    }
//onclick on information text to go to information page
    public void Information(View view) {
        Intent I = new Intent(getApplicationContext(),Infortmation.class);
        startActivity(I);
    }

//onclick on newdonor btn to go to newdonor
    public void add_donor(View view) {
        Intent I = new Intent(getApplicationContext(),New_donor.class);
        startActivity(I);

    }


//onclick on check btn to go to alldonor page
    public void specific(View view) {
        Intent I = new Intent(getApplicationContext(),All_donor.class);
        startActivity(I);
    }


//onclick on check btn to go to stock page
    public void stock(View view) {
        Intent I = new Intent(getApplicationContext(),Stock.class);
        startActivity(I);
    }



    public void mapss(View view) {
        Intent I = new Intent(getApplicationContext(),MapsActivity.class);
        startActivity(I);



    }
}
