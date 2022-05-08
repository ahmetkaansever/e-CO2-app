package com.aksdev.projectsecondaryusage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DailyUsageMain extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_primary_usage);

        Button buttonPrimaryUsage = findViewById(R.id.buttonPrimaryUsage);
        Button buttonSecondaryUsage = findViewById(R.id.buttonSecondaryUsage);
        Button buttonMonthlyCalculator =  findViewById(R.id.buttonMonthlyCalculator);
        Button buttonSolutions = findViewById(R.id.buttonSolutions);
        Button buttonRecycle = findViewById(R.id.buttonRecycle);

        buttonPrimaryUsage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intPrim = new Intent(DailyUsageMain.this, PrimaryUsage.class);
                startActivity(intPrim);
            }
        });

        buttonSecondaryUsage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intSec = new Intent(DailyUsageMain.this, SecondaryUsage.class);
                startActivity(intSec);
            }
        });

        buttonMonthlyCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intMonthly = new Intent(DailyUsageMain.this, MonthlyCalculator.class);
                startActivity(intMonthly);
            }
        });

        buttonRecycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intRec = new Intent(DailyUsageMain.this, Recycle.class);
                startActivity(intRec);
            }
        });

        buttonSolutions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intSol = new Intent(DailyUsageMain.this, Solutions.class);
                startActivity(intSol);
            }
        });

    }
}