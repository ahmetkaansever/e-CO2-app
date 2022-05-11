package com.aksdev.projectsecondaryusage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
//DoğaTrial2

public class DailyUsageMain extends AppCompatActivity {

    User userProfile;
    Button button;
    static TextView secondaryDisplay;
    static TextView primaryDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_primary_usage);

        userProfile = (User)getIntent().getSerializableExtra("currentUser");

        primaryDisplay = findViewById(R.id.primaryDisplay);
        secondaryDisplay = findViewById(R.id.secondaryDisplayed);
        //overallDisplay.setText((SecondaryUsage.totalSecondaryUsage + PrimaryUsage.total) + "");

        Button buttonPrimaryUsage = findViewById(R.id.buttonPrimaryUsage);
        Button buttonSecondaryUsage = findViewById(R.id.buttonSecondaryUsage);
        Button buttonRecycle =  findViewById(R.id.buttonRecycle);
        Button buttonSolutions = findViewById(R.id.buttonSolutions);

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
                intSol.putExtra("currentUser", userProfile);
                startActivity(intSol);
            }
        });

    }
}