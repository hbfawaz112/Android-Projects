package com.example.hp.all_in_one;

import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class FirstPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        try {
            NotificationManagerCompat nmc = NotificationManagerCompat.from(getApplicationContext());
           nmc.cancel(getIntent().getExtras().getInt("0"));

            Toast.makeText(getApplicationContext(),"You entered from notification",Toast.LENGTH_LONG).show();
        }catch (Exception e){

        }
    }

    public void toButton(View view){
        Intent i=new Intent(this,Button.class);
        startActivity(i);
    }
    public void toCheckBox(View view){
        Intent i=new Intent(this,CheckBox.class);
        startActivity(i);
    }
    public void toRadioButton(View view){
        Intent i=new Intent(this,RadioButton.class);
        startActivity(i);
    }
    public void toEditText(View view){
        Intent i=new Intent(this,EditText.class);
        startActivity(i);
    }
    public void toSeekBar(View view){
        Intent i=new Intent(this,SeekBar.class);
        startActivity(i);
    }
    public void toSpinner(View view){
        Intent i=new Intent(this,Spinner.class);
        startActivity(i);
    }

    public void toImage(View view){
        Intent i=new Intent(this,ImageAssets.class);
        startActivity(i);
    }

    public void toTimePicker(View view){
        Intent i=new Intent(this,TimePicker.class);
        startActivity(i);
    }

    public void toDatePicker(View view){
        Intent i=new Intent(this,DatePicker.class);
        startActivity(i);
    }

    public void toSwipePicker(View view){
        Intent i=new Intent(this,SwipeRefresh.class);
        startActivity(i);
    }

    public void toNotification(View view){
        Intent i=new Intent(this,Notification.class);
        startActivity(i);
    }

    public void toDialog(View view){
        Intent i=new Intent(this,AlertDialog.class);
        startActivity(i);
    }
    public void toActionBar(View view){
        Intent i=new Intent(this,ActionBar.class);
        startActivity(i);
    }
    public void toImplicitIntent(View view){
        Intent i=new Intent(this,ImplicitIntent.class);
        startActivity(i);
    }
    public void toBadge(View view){
        Intent i=new Intent(this,Badge.class);
        startActivity(i);
    }
    public void toSaveData(View view){
        Intent i=new Intent(this,SavingData.class);
        startActivity(i);
    }

    public void toDataBase(View view){
        Intent i=new Intent(this,DataBase.class);
        startActivity(i);
    }
}
