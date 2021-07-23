package com.example.mysqlphp;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Async extends AsyncTask<Void,String,Void> {
    private TextView resultTextView;
    private URL url;
    private boolean json;

    public Async(TextView textView, URL url, boolean json)
    {
        this.resultTextView = textView;
        this.url = url;
        this.json = json;
    }

    @Override
    protected Void doInBackground(Void... params) {

        try{
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            InputStream inputStream = connection.getInputStream();

            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            String answer = "";
            while ((line = rd.readLine()) != null) {
                answer += line;
            }

            publishProgress(answer);

        }catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(String...progress){
        super.onProgressUpdate();

        String users = progress[0];;

        if(json)
        {
            try {
                JSONObject jsonObject = new JSONObject(progress[0]);

                JSONArray jsonArray = jsonObject.getJSONArray("rows");


                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject e = jsonArray.getJSONObject(i);
                    JSONObject oneUser = e.getJSONObject("row");

                    users = oneUser.getString("firstName") + "  ";
                    users += oneUser.getString("lastName") + "  ";
                    users += oneUser.getString("phone") + "\n";
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


        // Update the UI
        this.resultTextView.setText(users);


    }

}
