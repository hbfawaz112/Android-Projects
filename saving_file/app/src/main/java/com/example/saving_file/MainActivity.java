package com.example.saving_file;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.util.ArraySet;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void write_shared_prefrences(View V)
    {
        SharedPreferences sharedPref =this.getSharedPreferences("file", Context.MODE_PRIVATE);
        SharedPreferences.Editor e = sharedPref.edit();
        EditText e1=(EditText) findViewById(R.id.e1);
        EditText e2=(EditText) findViewById(R.id.e2);
        e.putString("id",e1.getText().toString());
        e.putString("name", e2.getText().toString());
        e.commit();

        AlertDialog.Builder Alert=new AlertDialog.Builder(this);
        Alert.setMessage("the data has saved to shered preferences");
        Alert.setTitle("data entered");
        Alert.create().show();
    }

    public void read_shared_proferences(View V)
    {

        SharedPreferences sharedPref = this.getSharedPreferences("file", Context.MODE_PRIVATE);
//SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        String id = sharedPref.getString("id", "aa");
        String name= sharedPref.getString("name", "bb");

        String msg="the id is : "+id+" and name: "+name+" ";
        TextView t=(TextView)findViewById(R.id.tttt);
        t.setText(msg);
    }


    public void save_internal(View V)
    {
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);

        String filename="file1";
      String id= e1.getText().toString();
      String name=e2.getText().toString();

        FileOutputStream outputStream;
        try {
            
            outputStream=openFileOutput(filename,MODE_APPEND);
            outputStream.write(id.getBytes());

            outputStream.write(name.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        AlertDialog.Builder Alert=new AlertDialog.Builder(this);
        Alert.setMessage("the data has saved to internal storage");
        Alert.setTitle("data entered");
        Alert.create().show();


    }
    public void read_internal(View V) throws IOException
    {
        t1=(TextView)findViewById(R.id.tt);
        FileInputStream input = openFileInput("file1");
        byte[] buffer = new byte[4096];
        while(input.read(buffer)!= -1){

            String s ="";
            for(byte b:buffer){ s += (char)b; }
            t1.setText(s);
        }
        input.close();
    }


    /*Checks if external storage is available for read and write */
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


    public void save_external(View v) throws IOException {

        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);

        String id= e1.getText().toString();
        String name=e2.getText().toString();

        if(!isExternalStorageWritable())return;
      //  Toast.makeText(this, "fafaf", Toast.LENGTH_SHORT).show();
        //String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + File.separator + "myFolder";

        File doc=this.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        String path=doc+"/"+"myfile";
        File F=new File(path);

        FileOutputStream output=new FileOutputStream(F,true);
        output.write((id).getBytes());
        output.write((name).getBytes());


       /* File outputDir = new File(path);
        if(!outputDir.exists()) outputDir.mkdir();
        //3. reference to a file inside this folder
        File f = new File(outputDir, "/" + "myfile");
        FileOutputStream output = null;
        try {
            output = new FileOutputStream(f, true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            output.write((id).getBytes());
            output.write((name).getBytes());


        } catch (IOException e) {
            e.printStackTrace();
        }*/
        output.close();

        AlertDialog.Builder Alert=new AlertDialog.Builder(this);
        Alert.setMessage("the data has saved to external storage");
        Alert.setTitle("data entered");
        Alert.create().show();

    }

    public void read_external(View v) {

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
            t2=(TextView)findViewById(R.id.ttt);
            t2.setText(s);

            input.close();
        }catch (IOException e){

        }
    }


}
