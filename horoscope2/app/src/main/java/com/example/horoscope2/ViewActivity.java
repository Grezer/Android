package com.example.horoscope2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        TextView textD = findViewById(R.id.textView2);
        TextView textDesc = findViewById(R.id.textView3);

        Bundle arguments = getIntent().getExtras();
        if(arguments!=null){
            textD.setText(arguments.getString("dates"));
            textDesc.setText(arguments.getString("description"));
        }
    }

    public void onClick(View v) {
        finish();
    }
}
