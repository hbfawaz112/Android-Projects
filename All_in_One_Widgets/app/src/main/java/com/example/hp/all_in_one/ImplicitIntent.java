package com.example.hp.all_in_one;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import static java.net.Proxy.Type.HTTP;


public class ImplicitIntent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);
    }
    public void call(View view){
        Uri number = Uri.parse("tel:71873440");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(callIntent);
    }
    public void location(View view){
        // Build the intent
        Uri location = Uri.parse("geo:33.377169,35.483829?z=10"); Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        // Verify it resolves
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
        boolean isIntentSafe = activities.size() > 0;
        // Start an activity if it's safe
        if (isIntentSafe) {
            startActivity(mapIntent);
        }
    }
    public void email(View view){
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        // The intent does not have a URI, so declare the "text/plain" MIME type
      //  emailIntent.setType(HTTP.PLAIN_TEXT_TYPE);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"jon@example.com"}); // recipients
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message text"); emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));
        // You can also attach multiple items by passing an ArrayList of Uris
        startActivity(emailIntent);

    }
    public void webPage(View view){
        Uri webpage = Uri.parse("http://www.facebook.com");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);
    }

    public void share(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        // Always use string resources for UI text.
        // This says something like "Share this photo with"
        intent.putExtra("ali","From implicit Intent ... ");
        String title = "Share To";
        // Create intent to show chooser
        Intent chooser = Intent.createChooser(intent, title);



        // Verify the intent will resolve to at least one activity
        if (intent.resolveActivity(getPackageManager()) != null) {
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(chooser, 0);
        boolean isIntentSafe = activities.size() > 0;
        // Start an activity if it's safe
        if (isIntentSafe) {
           /* chooser.setData(Uri.parse("from activity intent ..."));
            setResult(RESULT_OK,chooser);
            startActivityForResult(chooser,1);*/
           startActivity(chooser);
        }}
    }
}
