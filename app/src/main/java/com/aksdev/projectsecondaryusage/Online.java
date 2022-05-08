package com.aksdev.projectsecondaryusage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Online extends AppCompatActivity {
    private Button logIn;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        logIn = findViewById(R.id.logInBtn);
        register = findViewById(R.id.registerBtn);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Online.this , Register.class) );
                finish();
            }
        });

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent (Online.this , LogIn.class) );
                finish();
            }
        });
    }
}