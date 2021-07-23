package com.example.hp.all_in_one;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.IOException;

public class ImageAssets extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_assets);
        Toast.makeText(this,"abel",Toast.LENGTH_LONG).show();

        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.linearL1);
        AssetManager assets = this.getAssets();
        try {
            String [] images = assets.list("user");
            for(int i = 0; i < images.length; i++) {
                ImageView imageView = new ImageView(this);
                String imageName = "user/" + images[i];
                Drawable image = Drawable.createFromStream(assets.open(imageName), imageName);
                imageView.setImageDrawable(image);
                linearLayout1.addView(imageView);
                //addView to add the image
            }
            ImageView image = new ImageView(this);
            image.setImageResource(R.drawable.ic_launcher_foreground);
            linearLayout1.addView(image);

        } catch (IOException e){
            Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
        }
        Toast.makeText(this,"b3d",Toast.LENGTH_LONG).show();
    }
}

