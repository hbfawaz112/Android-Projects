package com.example.hp.all_in_one;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SavingData extends AppCompatActivity {
     private  android.widget.EditText cle;
     private  android.widget.EditText valuer;
     private TextView print;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saving_data);

        print=findViewById(R.id.textView16);
        cle =  findViewById(R.id.editText3);
        valuer = findViewById(R.id.editText4);
        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                print.setText("");
                read="";
            }
        });
    }

    public void WSP(View view){
         SharedPreferences sharedPref =this.getSharedPreferences("file", Context.MODE_PRIVATE);
         SharedPreferences.Editor e =  sharedPref.edit();
         e.putString(cle.getText().toString(),valuer.getText().toString());
         e.commit();
        Toast.makeText(getApplicationContext(),"add le clee "+cle.getText().toString(),Toast.LENGTH_SHORT).show();
    }
    String read="" ;
    public void RSP(View view){

        SharedPreferences sharedPref = this.getSharedPreferences("file",  Context.MODE_PRIVATE);
        read += sharedPref.getString(cle.getText().toString(), "not found")+" ; ";
        print.setText(read);
    }

    public void WE(View view){
        if(!isExternalStorageWritable()) return;
        try{
            // 1. path : String
            String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) + File.separator + "myFolder";
            //2. reference of the folder and check if it exists
            File outputDir = new File(path);
            if(!outputDir.exists()) outputDir.mkdir();
            //3. reference to a file inside this folder
            File f = new File(outputDir, "/" + "myfile");
            FileOutputStream output = new FileOutputStream(f, true);
            output.write(("hello").getBytes());
            output.close();
        }catch(Exception io){

        }
    }
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state))
            return true;
        return false;
    }
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state))
            return true;
        return false;
    }

    public void RE(View view){
        String filename = "myfile";
        if(!isExternalStorageReadable()){
            return;
        }
        try{// path
            String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+ File.separator + "myFolder";
            //reference to the folder
            File outputDir = new File(path);
            if(!outputDir.exists()) return;
            // reference to the file
            File f = new File(outputDir,"/" + filename);
            FileInputStream input = new FileInputStream(f);
               byte[] buffer = new byte[4096];
                String s="";
               while(input.read(buffer)!= -1){

                for(byte b:buffer){  s += (char)b; }
                }
                print.setText(s);
            input.close();
        }catch (IOException e){

        }
    }
    public void WI(View view){
        String filename = "myfile";
        String str = valuer.getText().toString();
        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(filename, Context.MODE_APPEND);
            outputStream.write(str.getBytes());
            outputStream.close();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),"faible to save",Toast.LENGTH_SHORT).show();
        }

    }
    public void RI(View view) throws IOException {
        FileInputStream input = openFileInput("myfile");
        byte[] buffer = new byte[4096];
        String s = "";
        while(input.read(buffer)!= -1){
           for(byte b:buffer){s += (char)b; }
        }
        input.close();
        print.setText(s);
    }
}
