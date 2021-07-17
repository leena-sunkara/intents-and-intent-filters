package com.masai.validatecredentials;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginScreen extends AppCompatActivity {

    private EditText mEtEmail, mEtPassword;
    private Button mBtnLogin;
    private String emailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private String passwordValidation = "[A-Za-z]+[0-9]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        mEtEmail = findViewById(R.id.etEmail);
        mEtPassword = findViewById(R.id.etPassword);
        mBtnLogin = findViewById(R.id.btnLogin);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isEmailValid = isEmailValid();
                boolean isPasswordValid = isPasswordValid();
                if (isEmailValid && isPasswordValid) {
                    Intent intent = new Intent(LoginScreen.this, HomeScreen.class);
                    intent.putExtra("mail", mEtEmail.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }

    private boolean isEmailValid() {
        if (mEtEmail.getText().toString().length() != 0 && mEtEmail.getText().toString().matches(emailValidation)) {
            return true;
        } else {
            mEtEmail.setError("Invalid Email");
            return false;
        }
    }
    private boolean isPasswordValid() {
        if(mEtPassword.getText().toString().length() >= 6 && mEtPassword.getText().toString().matches(passwordValidation)) {
            return true;
        } else {
            mEtPassword.setError("Password should be alphanumeric and greater than or equals to 6 characters");
            return false;
        }
    }
}