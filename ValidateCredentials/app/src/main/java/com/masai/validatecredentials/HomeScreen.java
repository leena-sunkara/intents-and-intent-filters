package com.masai.validatecredentials;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        TextView mtvEmail;
        mtvEmail = findViewById(R.id.tvEmail);
        Intent intent = getIntent();
        String email = intent.getStringExtra("mail");
        mtvEmail.setText(email);
    }
}