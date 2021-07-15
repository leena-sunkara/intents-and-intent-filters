package com.masai.customactivityapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ReceiveActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);
        textView = findViewById(R.id.tvReceive);
        if (getIntent() != null && getIntent().getExtras() != null) {
            String name = getIntent().getStringExtra("data");
            textView.setText(name);
        }
    }
}