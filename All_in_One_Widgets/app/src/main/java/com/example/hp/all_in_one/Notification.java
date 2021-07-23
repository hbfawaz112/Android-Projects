package com.example.hp.all_in_one;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Notification extends AppCompatActivity {
    int idN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        idN=0;

    }
    public void notification(View view){
        NotificationCompat.Builder mBuilder;

        if(Build.VERSION.SDK_INT>=26){
            int importance=NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel=new NotificationChannel("myChannelId","My Channel",importance);
            channel.setDescription("Reminders");

            NotificationManager mNotification=(NotificationManager)this.getSystemService(Context.NOTIFICATION_SERVICE);
            mNotification.createNotificationChannel(channel);




        }

            mBuilder = new NotificationCompat.Builder(this,"myChannelId")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentText("content of the notif ")
                    .setContentTitle("Title of the notif");



        mBuilder.addAction(R.drawable.ic_launcher_foreground,"share",null);

        Intent intent=new Intent(this,FirstPage.class);
        intent.putExtra("Notification id",idN);

        PendingIntent pendingIntent=PendingIntent.getActivity(this,(int)System.currentTimeMillis(),intent,PendingIntent.FLAG_CANCEL_CURRENT);

        mBuilder.setContentIntent(pendingIntent);

        NotificationManager mNotification=(NotificationManager)this.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotification.notify(idN,mBuilder.build());

        idN++;
        //  finish();
        finishAffinity();

    }
}
