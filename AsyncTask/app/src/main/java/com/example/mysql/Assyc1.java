package com.example.mysql;

import android.os.AsyncTask;
import android.widget.TextView;

import static java.lang.Thread.sleep;

public class Assyc1 extends AsyncTask<Void,Integer,Void> {
    TextView T;

    public Assyc1(TextView t) {
        T = t;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        for(int i=0;i<100;i++){
            publishProgress(i);
            try{
                sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {

        super.onProgressUpdate(values);
        T.setText(values[0]+"%");

    }
}
