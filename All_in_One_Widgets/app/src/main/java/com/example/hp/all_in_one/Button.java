package com.example.hp.all_in_one;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Button extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
    /*   Button b=(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i=new Intent(getApplicationContext(),Main2Activity.class);
               startActivity(i);
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(),"long click",Toast.LENGTH_LONG).show();
                return false;
            }
        });

     //   Button b1=new Button(this);
       // b1.setText("test");
        //setContentView(b1);

        Button b1=(Button)findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Main3Activity.class);
                startActivity(i);
            }
        });
        Button b2=(Button)findViewById(R.id.button3);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Main4Activity.class);
                startActivity(i);
            }
        });*/

        android.widget.Button b=findViewById(R.id.button);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"funtcion is On Click",Toast.LENGTH_LONG).show();
            }
        });

        android.widget.Button b1=findViewById(R.id.button2);
        b1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(),"funtcion is On Long Click",Toast.LENGTH_LONG).show();
                return false;
            }
        });

        android.widget.Button b2=findViewById(R.id.button3);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"create new button",Toast.LENGTH_LONG).show();
                android.widget.Button b=new android.widget.Button(getApplicationContext());
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"this is new Button",Toast.LENGTH_LONG).show();
                    }
                });
                b.setText("new Button");
                b.setWidth(10);
                b.setHeight(10);
                b.setBackgroundColor(Color.BLUE);
                RelativeLayout l =findViewById(R.id.realativelAYOUTtOaDD);

                l.addView(b);
            }
        });
    }
}
