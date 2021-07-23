package com.example.hp.all_in_one;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CheckBox extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
    }
    public void  click(View view){
        Boolean checked =((android.widget.CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBox:
                if(checked)
                    Toast.makeText(getApplicationContext(),"checkBox1 checheked",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"checkBox1 no checheked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBox2:
                if(checked)
                    Toast.makeText(getApplicationContext(),"checkBox2 checheked",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"checkBox2 no checheked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBox3:
                if(checked)
                    Toast.makeText(getApplicationContext(),"checkBox3 checheked",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"checkBox3 no checheked",Toast.LENGTH_SHORT).show();
                break;
        }

    }


    public void Check(View view) {
        String m="checked is : ";
        android.widget.CheckBox c1=findViewById(R.id.checkBox);
        android.widget.CheckBox c2=findViewById(R.id.checkBox2);
        android.widget.CheckBox c3=findViewById(R.id.checkBox3);


        if(c1.isChecked())
            m=m+"1";


        if(c2.isChecked())
            m=m+" , 2";


        if(c3.isChecked())
            m=m+" , 3";


        Toast.makeText(this,m,Toast.LENGTH_LONG).show();
    }

    public void noCheck(View view){
        String m="no checked is : ";
        android.widget.CheckBox c1=findViewById(R.id.checkBox);
        android.widget.CheckBox c2=findViewById(R.id.checkBox2);
        android.widget.CheckBox c3=findViewById(R.id.checkBox3);

        if(!c1.isChecked())
            m=m+"1";


        if(!c2.isChecked())
            m=m+" , 2";


        if(!c3.isChecked())
            m=m+" , 3";


        Toast.makeText(this,m,Toast.LENGTH_LONG).show();
    }
}
