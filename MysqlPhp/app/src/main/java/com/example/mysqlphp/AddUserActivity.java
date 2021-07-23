package com.example.mysqlphp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class AddUserActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
    }

    public void save(View view) {
        EditText firstNameEditText = findViewById(R.id.firstName);
        EditText lastNameEditText = findViewById(R.id.lastName);

        final String firstName = firstNameEditText.getText().toString();
        final String lastName = lastNameEditText.getText().toString();

        firstNameEditText.setText("");
        lastNameEditText.setText("");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String serverAddress = getResources().getString(R.string.localServer);
                URL url = null;
                try {
                    url = new URL(serverAddress+"/addUser.php?fn="+firstName+"&ln="+lastName);
                    System.out.println(url.toString());

                    HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.connect();

                    InputStream inputStream = connection.getInputStream();

                    BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
                    String line = "";

                    while ((line = rd.readLine()) != null) {
                        System.out.println(line);
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

    }
}
