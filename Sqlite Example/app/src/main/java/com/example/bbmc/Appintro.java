package com.example.bbmc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bbmc.R;

import static java.lang.Thread.sleep;

public class Appintro extends AppCompatActivity {
    Animation topAnim, bottomAnim;
    ImageView logo;
    TextView slogan;
    private static int SPLASH_SCREEN = 2000;//ms

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();

        //Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        setContentView(R.layout.activity_appintro);
        logo = (ImageView) findViewById(R.id.ivLogo);
        slogan = (TextView) findViewById(R.id.tvSlogan);

      //  topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        //bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        //logo.startAnimation(topAnim);
        //slogan.setAnimation(bottomAnim);
        getSupportActionBar().hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Appintro.this, MainActivity.class);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(i);
                finish();
            }
        }, SPLASH_SCREEN);
    }
}