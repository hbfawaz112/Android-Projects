package com.example.mysqlphp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Search(View view) {
        EditText editText = (EditText)findViewById(R.id.Uid);
        String id = editText.getText().toString();

        String serverAddress = getResources().getString(R.string.localServer);

        URL url = null;
        try {
            url = new URL(serverAddress+"/getUser.php?id="+id+"&format=txt");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        SearchAsyncTask searchAsyncTask = new SearchAsyncTask();
        searchAsyncTask.execute(url);
    }

    public void add(View view) {
        startActivity(new Intent(this, AddUserActivity.class));
    }
    private class SearchAsyncTask extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... urls) {
            try{

                HttpURLConnection connection = (HttpURLConnection)urls[0].openConnection();
                System.out.println(urls[0].toString());
                connection.setRequestMethod("GET");
                connection.connect();

                InputStream inputStream = connection.getInputStream();

                BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
                String line = rd.readLine();
                return line;


            }catch(Exception e)
            {
                System.out.println(e.toString());
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            TextView textView = findViewById(R.id.textview);
            textView.setText(s);
        }
    }
}
