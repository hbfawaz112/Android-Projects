package com.example.bbmc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
//class of login page
public class MainActivity extends AppCompatActivity {

    DatabaseHandler db;
    EditText t1,t2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        db = new DatabaseHandler(this);
        db.add_user_login();

        t1 = (EditText)findViewById(R.id.activity_main_usernameEditText);
        t2 = (EditText)findViewById(R.id.activity_main_passwordEditText);


    }
//test if the enterd value is correct
    public void login(View view) {
        String username = t1.getText().toString();
        String password = t2.getText().toString();

        Boolean success = db.login(username,password);

        if(!success){
            Toast.makeText(this, "Error Login", Toast.LENGTH_LONG).show();
        }
        else{
            Intent I = new Intent(getApplicationContext(),Dashboard.class);
            startActivity(I);




        }
    }
}