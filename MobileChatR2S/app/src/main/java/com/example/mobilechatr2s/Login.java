package com.example.mobilechatr2s;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    private Button btLogin;
    private TextView tvregister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mapping();
        click();

    }
    private void click() {
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,home.class);
                startActivity(intent);
            }
        });
        tvregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,register.class);
                startActivity(intent);
            }
        });
    }

    private void mapping() {
        btLogin = (Button)findViewById(R.id.btlogin);
        tvregister = (TextView)findViewById(R.id.txtRegister);
    }
}
