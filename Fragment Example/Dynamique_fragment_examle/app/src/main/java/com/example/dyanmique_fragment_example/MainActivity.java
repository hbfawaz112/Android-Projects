package com.example.dyanmique_fragment_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Fragment1 fr = new Fragment1();
        this.setdefaultfragment(fr);

        Button b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment1 fr1= new Fragment1();
                replacefragment(fr1);
            }
        });

        Button b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment2 fr2= new Fragment2();
                replacefragment(fr2);
            }
        });
        Button b3=(Button)findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment3 fr3= new Fragment3();
                replacefragment(fr3);
            }
        });


    }



    public void setdefaultfragment(Fragment defaultragment)
    {
        this.replacefragment(defaultragment);
    }

    public  void replacefragment(Fragment destination)
    {

        FragmentManager fragmentmenager=this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentmenager.beginTransaction();

        fragmentTransaction.replace(R.id.framelayout,destination);
        fragmentTransaction.commit();

    }


}
