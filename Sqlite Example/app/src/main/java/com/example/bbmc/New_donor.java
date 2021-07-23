package com.example.bbmc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import static android.text.method.TextKeyListener.clear;

//class of new donor activity
public class New_donor extends AppCompatActivity {

    EditText t1,t2,t3,t4,t5;
    Spinner s1;
    RadioButton rb1,rb2;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // System.out.print("******************mne donor******************");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_donor);
        db = new DatabaseHandler(this);
        getSupportActionBar().hide();

        t1 = (EditText)findViewById(R.id.id);
        t2 = (EditText)findViewById(R.id.firstname);
        t3 = (EditText)findViewById(R.id.lastname);
        t4 = (EditText)findViewById(R.id.editTextDate);
        t5 = (EditText)findViewById(R.id.editTextPhone);

        s1 = (Spinner)findViewById(R.id.spinner);

        rb1 = (RadioButton)findViewById(R.id.yes);
        rb2 = (RadioButton)findViewById(R.id.no);



    }

    public void clear(){
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        rb1.setChecked(false);
        rb2.setChecked(false);


    }

    public void add(View view) {
        //System.out.print("******************"+t1.getText().toString()+"******************");
        String id = t1.getText().toString().trim();
        //System.out.print("******************"+id+"******************");
        String fname = t2.getText().toString().trim();
        String lname = t3.getText().toString().trim();
        String dbb = t4.getText().toString().trim();
        String phnb = t5.getText().toString().trim();

        String selected_bloodtype = s1.getSelectedItem().toString();

        String ischecked;
        if(rb1.isChecked()){
            ischecked="yes";
        }
        else{
            ischecked="no";
        }
        Toast.makeText(this, "Data inserted", Toast.LENGTH_LONG).show();
        db.add_donor(id,fname,lname,dbb,phnb,selected_bloodtype,ischecked);
       //Toast.makeText(this, "Data inserted", Toast.LENGTH_LONG).show();

            clear();

    }
}