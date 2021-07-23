package com.example.lab4;

import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int nb_choises=3;
    ImageView country_image;
    AssetManager assets;

    List<String> imagesFLag;
    ArrayList<Button> buttons_names;
    ArrayList<String> temp;

    Button b1,b2, b3, b4,b5,b6,b7,b8,b9;
    TextView t1,t2,t3;
    ImageButton imb;
    LinearLayout l1,l2,l3;

    String top;

    String correct_answer1,correct_answer;

    int counter_question = 1;
    int counter_success = 0;
    int counter_wrong = 0;


    AlertDialog.Builder nb_shoosed,region;
    String[] nb_choix={"3 Buttons","6 Buttons","9 Buttons"};
    String[] regions_names={"Europe","Asia","Africa","America"};
    boolean[] b=new boolean[]{false,false,false,false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

            imb = (ImageButton) findViewById(R.id.imb);
            b1 = (Button) findViewById(R.id.b1);
            b2 = (Button) findViewById(R.id.b2);
            b3 = (Button) findViewById(R.id.b3);
            b4 = (Button) findViewById(R.id.b4);
            b5 = (Button) findViewById(R.id.b5);
            b6 = (Button) findViewById(R.id.b6);
            b7 = (Button) findViewById(R.id.b7);
            b8 = (Button) findViewById(R.id.b8);
            b9 = (Button) findViewById(R.id.b9);


            l1 = (LinearLayout) findViewById(R.id.l1);
            l2 = (LinearLayout) findViewById(R.id.l2);
            l2.setVisibility(View.INVISIBLE);
            l3 = (LinearLayout) findViewById(R.id.l3);
            l3.setVisibility(View.INVISIBLE);


            t1 = (TextView) findViewById(R.id.t1);
            t2 = (TextView) findViewById(R.id.t2);
            t3 = (TextView) findViewById(R.id.t3);

            country_image = (ImageView) findViewById(R.id.im);
            assets = this.getAssets();
            imagesFLag = new ArrayList<String>();
            temp = new ArrayList<String>();


        if(savedInstanceState!=null){
            t1.setText(savedInstanceState.getString("t1"));
            t2.setText(savedInstanceState.getString("t2"));
            t3.setText(savedInstanceState.getString("t3"));
            counter_success=savedInstanceState.getInt("counter_succes");
            counter_question=savedInstanceState.getInt("counter Question");
            correct_answer=savedInstanceState.getString("correct");
            correct_answer1=savedInstanceState.getString("correct1");
            counter_wrong=savedInstanceState.getInt("couter wrong");
            temp=savedInstanceState.getStringArrayList("temp");
            nb_choises=savedInstanceState.getInt("nb_choices");
            top=savedInstanceState.getString("top");
        }else {
            top = ("Question " + counter_question + " of 10");
            t1.setText(top);
            t2.setText("Guess the country");
            nextflag();
        }
    }
    public void nextflag() {
        imb.setClickable(false);
        b2.setClickable(true);
        b3.setClickable(true);
        b1.setClickable(true);
        try {
            if (counter_question == 1) {
                String[] images = assets.list("png");
                for (int i = 0; i < images.length; i++) {
                    if (!imagesFLag.contains(images[i]))
                        imagesFLag.add(images[i]);
                }
            }
            if (b[0] == false && b[1] == false && b[2] == false && b[3] == false) {
                int index_of_image = new Random().nextInt(imagesFLag.size());
                correct_answer1 = imagesFLag.get(index_of_image);
                correct_answer = split(correct_answer1);
                Drawable image = Drawable.createFromStream(assets.open("png/" + imagesFLag.get(index_of_image)), "png/" + imagesFLag.get(index_of_image));
                country_image.setImageDrawable(image);
                imagesFLag.remove(index_of_image);
                setButtons();
            }
            else {
                if (b[0] == true) {
                    if (counter_question == 1) {
                        for (int i = 0; i < imagesFLag.size(); i++) {
                            if (imagesFLag.get(i).contains(regions_names[0])) {
                                temp.add(imagesFLag.get(i));
                            }
                        }
                    }
                }
                if (b[1] == true) {
                    if (counter_question == 1) {
                        for (int i = 0; i < imagesFLag.size(); i++) {
                            if (imagesFLag.get(i).contains(regions_names[1])) {
                                temp.add(imagesFLag.get(i));
                            }
                        }
                    }
                }
                if (b[2] == true) {
                    if (counter_question == 1) {
                        for (int i = 0; i < imagesFLag.size(); i++) {
                            if (imagesFLag.get(i).contains(regions_names[2])) {
                                temp.add(imagesFLag.get(i));
                            }
                        }
                    }
                }
                if (b[3] == true) {
                    if (counter_question == 1) {
                        for (int i = 0; i < imagesFLag.size(); i++) {
                            if (imagesFLag.get(i).contains(regions_names[3])) {
                                temp.add(imagesFLag.get(i));
                            }
                        }
                    }
                }
                int index_of_image = new Random().nextInt(temp.size());
                correct_answer1 = temp.get(index_of_image);
                correct_answer = split(correct_answer1);
                Drawable image = Drawable.createFromStream(assets.open("png/" + temp.get(index_of_image)), "png/" + temp.get(index_of_image));
                country_image.setImageDrawable(image);
                temp.remove(index_of_image);
                setButtons();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String split(String s) {
        return s.split("-")[1].split("\\.")[0];
    }

    public void setButtons() {
        buttons_names=new ArrayList<Button>();
        int pos = new Random().nextInt(nb_choises);
        /*

        ////--------for three buttons-------\\\\

        int pos = new Random().nextInt(3);
        Button child1 = (Button) l1.getChildAt(pos);
        child1.setText(correct_answer);
        String text1, text2;
        for (int i = 0; i < 3; i++) {
            if (i != pos) {
                text1=imagesFLag.get(new Random().nextInt(imagesFLag.size()));
                text2 = split(text1);
                Button b=(Button)l1.getChildAt(i);
                b.setText(text2);
            }
        }*/
        if(nb_choises==3){
            for(int i=0;i<3;i++){
                buttons_names.add((Button) l1.getChildAt(i));
            }
        }
        if(nb_choises==6){
            for(int i=0;i<3;i++){
                buttons_names.add((Button) l1.getChildAt(i));
            }
            for(int i=0;i<3;i++){
                buttons_names.add((Button) l2.getChildAt(i));
            }
        }
        if(nb_choises==9){
            for(int i=0;i<3;i++){
                buttons_names.add((Button) l1.getChildAt(i));
            }
            for(int i=0;i<3;i++){
                buttons_names.add((Button) l2.getChildAt(i));
            }
            for(int i=0;i<3;i++){
                buttons_names.add((Button) l3.getChildAt(i));
            }
        }
        buttons_names.get(pos).setText(correct_answer);
        String text1, text2;
        if(b[0]==false && b[1]==false && b[2]==false && b[3]==false) {
            for (int i = 0; i < buttons_names.size(); i++) {
                if (i != pos) {
                    text1 = imagesFLag.get(new Random().nextInt(imagesFLag.size()));
                    text2 = split(text1);
                    buttons_names.get(i).setText(text2);
                    imagesFLag.remove(text1);
                }
            }
        }
        if(b[0]==true || b[1]==true || b[2]==true || b[3]==true){
            for (int i = 0; i < buttons_names.size(); i++) {
                if (i != pos) {
                    text1 = temp.get(new Random().nextInt(temp.size()));
                    text2 = split(text1);
                    buttons_names.get(i).setText(text2);
                    temp.remove(text1);
                }
            }
        }
    }
    public void send(View v){
        if(((Button)v).getText().equals(correct_answer)){
            t3.setText("CORRECT!!!");
            counter_success++;
        }
        else{
            t3.setText("FALSE!!! \n it's "+correct_answer);
            counter_wrong++;
        }
        imb.setClickable(true);
        b1.setClickable(false);
        b2.setClickable(false);
        b3.setClickable(false);
    }

    public void next(View v){
        if(counter_question<10){
            counter_question++;
            top=("Question "+counter_question+" of 10");
            t1.setText(top);
            t3.setText("");
            nextflag();
        }
        else{
            AlertDialog.Builder Alert=new AlertDialog.Builder(this);
            Alert.setMessage(counter_wrong + " Wrongs clicks, " + (int) counter_success*100/10 + "% correct" );
            Alert.setTitle("The end");
            Alert.setNeutralButton("reset", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    reset();
                }
            });
            Alert.create().show();
        }
    }
    public void reset(){
        counter_question=1;
        counter_success=0;
        counter_wrong=0;
        top=("Question "+counter_question+" of 10");
        t1.setText(top);
        t3.setText("");
        if(!temp.isEmpty()){
            temp.clear();
        }
        nextflag();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.Nb_chois) {
            nb_shoosed = new AlertDialog.Builder(this);
            nb_shoosed.setTitle("choose the number of probabilities");

            nb_shoosed.setSingleChoiceItems(nb_choix, 0, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (which == 0) {
                        nb_choises = 3;
                    }
                    if (which == 1) {
                        nb_choises = 6;
                    }
                    if (which == 2) {
                        nb_choises = 9;
                    }
                }
            });
            nb_shoosed.setNegativeButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (nb_choises == 3) {
                        setButtons();
                        l2.setVisibility(View.INVISIBLE);
                        l3.setVisibility(View.INVISIBLE);
                    }
                    if (nb_choises == 6) {
                        setButtons();
                        l2.setVisibility(View.VISIBLE);
                        l3.setVisibility(View.INVISIBLE);
                    }
                    if (nb_choises == 9) {
                        setButtons();
                        l2.setVisibility(View.VISIBLE);
                        l3.setVisibility(View.VISIBLE);
                    }
                }
            });
            nb_shoosed.create().show();

        }
        if (id == R.id.regions) {
            region = new AlertDialog.Builder(this);
            region.setTitle("REGIONS");
            region.setMultiChoiceItems(regions_names, b, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    if (isChecked) {
                        b[which] = true;
                    } else
                        try {
                            b[which] = false;
                        } catch (Exception e) {

                        }
                }
            });
            region.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    reset();
                    nextflag();
                }
            });
            region.create().show();

        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter Question",counter_question);
        outState.putString("correct",correct_answer);
        outState.putString("correct1",correct_answer1);
        outState.putInt("counter_succes",counter_success);
        outState.putInt("couter wrong",counter_wrong);
        outState.putStringArrayList("temp",temp);
        outState.putInt("nb_choices",nb_choises);
        outState.putString("top",top);
        outState.putString("t1",t1.getText().toString());
        outState.putString("t2",t2.getText().toString());
        outState.putString("t3",t3.getText().toString());
    }
}
