package com.example.hp.all_in_one;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class IntentViewReceiver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_view_receiver);

        try{
            Intent intent=getIntent();
            Toast.makeText(getApplicationContext(), intent.getStringExtra("ali"), Toast.LENGTH_LONG).show();
        }catch (Exception e){

        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==1) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(getApplicationContext(), data.getData().toString(), Toast.LENGTH_LONG).show();
            }
        }
    }
}
