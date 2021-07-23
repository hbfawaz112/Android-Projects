package com.example.hp.all_in_one;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

public class EditText extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        android.widget.EditText t=findViewById(R.id.editText);

        t.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                TextView t1=findViewById(R.id.textView);
                t1.setText(s + "   "+ start  + "     " +count+"       "+after);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                TextView t1=findViewById(R.id.textView2);
                t1.setText(s + "   "+ start  + "     " +before+"      "+count);
            }

            @Override
            public void afterTextChanged(Editable s) {
                TextView t1=findViewById(R.id.textView3);
                t1.setText(s);
            }
        });
    }
}
