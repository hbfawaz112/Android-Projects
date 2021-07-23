package com.example.hp.all_in_one;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Toast;

public class AlertDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
    }
    public void dialog(View view){

        android.support.v7.app.AlertDialog.Builder alert = new android.support.v7.app.AlertDialog.Builder(this);
        alert.setMessage("This is an alert …");
        alert.setTitle("App Title");
        alert.setNeutralButton("May be", null);
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"You click no",Toast.LENGTH_SHORT).show();
            } });
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(getApplicationContext(),"You click yes",Toast.LENGTH_SHORT).show();
            }

        });
        alert.setCancelable(false);
        alert.create().show();
    }
    //dialog2
    public void dialog2(View view){

        android.support.v7.app.AlertDialog.Builder alert  = new android.support.v7.app.AlertDialog.Builder(this);
//alert.setMessage("This is an alert …");
        alert.setTitle("App Title");
        String[] choices={"sharing","delete", "goahead"};
        alert.setItems(choices, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Selected the item"+which,Toast.LENGTH_SHORT).show();
            }
        });
        alert.setCancelable(false);
        alert.create().show();
    }
    boolean[] b=new boolean[]{true,true,true,true,true,true};
    public void dialog3(View view){
        android.support.v7.app.AlertDialog.Builder alert1  = new android.support.v7.app.AlertDialog.Builder(this);
        alert1.setTitle("App Title");
      final   CharSequence[] items1 = new CharSequence[]{"Africa","Asia","Europe","North_America","Oceania","South_America"};

        alert1.setMultiChoiceItems(items1, b, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) {

                    b[which]=true;
                    Toast.makeText(getApplicationContext(), items1[which].toString(), Toast.LENGTH_LONG).show();
                } else {
                    try {

                        Toast.makeText(getApplicationContext(),"inchecked"+ items1[which].toString(), Toast.LENGTH_LONG).show();
                        b[which]=false;
                    } catch (Exception e) {

                    }
                }
            }
        });
        alert1.setPositiveButton("Ok", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                boolean j=false;
                for (boolean k:b) {
                    if(k==true){
                        j=true;
                    }
                }
                dialog.cancel();
                if(j==false){
                    Toast.makeText(getApplicationContext(),"minum 1 check",Toast.LENGTH_LONG).show();
                    dialog3(null);
                }
            }
        });
        alert1.setCancelable(false);
        alert1.create().show();
    }
    int choi=0;
    public void dialog4(View view){

        android.support.v7.app.AlertDialog.Builder alert  = new android.support.v7.app.AlertDialog.Builder(this);
    alert.setTitle("App Title");
        CharSequence[] items={"3","6","9"};
        alert.setSingleChoiceItems (items, choi,new DialogInterface.OnClickListener (){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                choi = which;
            }
        });
        alert.setPositiveButton("Ok", null);
        alert.setCancelable(false);
        alert.create().show();
    }
}
