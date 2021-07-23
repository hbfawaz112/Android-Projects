package com.example.bbmc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

public class All_donor extends AppCompatActivity {

    EditText t1,t2,t3,t4,t5;
    Spinner s1;
    DatabaseHandler db1;
    RadioButton rb1,rb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_donor);
        getSupportActionBar().hide();

        t1 = findViewById(R.id.id);
        t2 = findViewById(R.id.firstname);
        t3 = findViewById(R.id.lastname);
        t4 = findViewById(R.id.editTextDate);
        t5 = findViewById(R.id.editTextPhone);

        rb1= findViewById(R.id.yes);
        rb2= findViewById(R.id.no);

        s1 = findViewById(R.id.spinner);
        db1 = new DatabaseHandler(this);
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

    public void search(View view) {
    int id1 = Integer.parseInt(t1.getText().toString());
    Donor dd = db1.get_specific_donor(id1);
    t2.setText(dd.getFname());
        t3.setText(dd.getLname());
        t4.setText(dd.getDatabirth());
        t5.setText(dd.getPhnb());

        //Toast.makeText(this,"sss"+ dd.getIscorona(),Toast.LENGTH_LONG).show();
        if(dd.getIscorona().equals("yes")){
           rb1.setChecked(true);
        }
        if(dd.getIscorona().equals("no")){
            rb2.setChecked(true);
        }


      /* String selected= dd.getBlood_type().toString();
        int indexselected=0;
        for (int i=0;i<s1.getCount();i++){
            if (s1.getItemAtPosition(i).toString().equalsIgnoreCase(selected)){
                 i=indexselected;
            }
        }
        s1.setSelection(indexselected);*/


    }

    public void update(View view) {
        String id = t1.getText().toString().trim();
        String fname=t2.getText().toString().trim();
        String lname=t3.getText().toString().trim();
        String db=t4.getText().toString().trim();
        String phnb=t5.getText().toString().trim();

        String blood=s1.getSelectedItem().toString();
        /*String ischecked;
        if(rb1.isChecked()){
            ischecked="yes";
        }
        else{
            ischecked="no";
        }*/
        db1.update(id,fname,lname,db,phnb,blood);
        Toast.makeText(this,"Updated succefully" , Toast.LENGTH_LONG).show();
        clear();

    }

    public void delete(View view) {
        int id1 = Integer.parseInt(t1.getText().toString());
        boolean ok = db1.delete(id1);
        Toast.makeText(this,"Deleted succefully" , Toast.LENGTH_LONG).show();
        clear();;


    }
}