package com.example.hp.all_in_one;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Spinner extends AppCompatActivity {
    ArrayList<String> ar;
    ArrayAdapter<String> myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        ar=new ArrayList<String>();

        android.widget.Spinner s=findViewById(R.id.spinner1);
        android.widget.Spinner s1=findViewById(R.id.spinner);
        String[] spinnerContents = {"Apple", "Tomato", "Orange"};
        ArrayAdapter<String> myadapter1 = new ArrayAdapter<String> (this,android.R.layout.simple_spinner_dropdown_item,spinnerContents);
        s.setAdapter(myadapter1);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            int isSpinnercalledBefore=0;
            public void onItemSelected(AdapterView<?> parent, View v, int pos, long id){
                isSpinnercalledBefore++;
                if (isSpinnercalledBefore > 1){
                    String o = parent.getItemAtPosition(pos).toString();
                    TextView t=findViewById(R.id.textView11);
                    t.setText(o);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        myadapter = new ArrayAdapter<String> (this,android.R.layout.simple_spinner_dropdown_item,ar);
        s1.setAdapter(myadapter);
    }
    //  @RequiresApi(api = Build.VERSION_CODES.O)
    public void addToSpinner(View view){
        android.widget.EditText t=findViewById(R.id.editText2);
        // Spinner s=findViewById(R.id.spinner);
        if(ar.contains(t.getText().toString())==false) {
            ar.add(t.getText().toString());
            /*
           myadapter = new ArrayAdapter<String> (this,android.R.layout.simple_spinner_dropdown_item,ar);
            s.setAdapter(myadapter);

            */
            //or
            myadapter.notifyDataSetChanged();
        }else{
            Toast.makeText(this,"it's found in spinner",Toast.LENGTH_LONG).show();
        }
    }

    public void removeToSpinner(View view){
        EditText t=findViewById(R.id.editText2);
        // Spinner s=findViewById(R.id.spinner);
        if(ar.contains(t.getText().toString())) {
            ar.remove(t.getText().toString());
          /*  myadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ar);
            s.setAdapter(myadapter);
*/
            //or
            myadapter.notifyDataSetChanged();
        }else{
            Toast.makeText(this,"it's not found in spinner",Toast.LENGTH_LONG).show();
        }
    }
}
