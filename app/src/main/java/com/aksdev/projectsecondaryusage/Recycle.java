package com.aksdev.projectsecondaryusage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Recycle extends AppCompatActivity {

    private final int paper = 2;
    private final int plastic = 5;
    private final int glass=4;
    private final int oil=8;
    private final int battery=10;
    private int totalScore;
    private int paperAmount, plasticAmount, glassAmount, oilAmount, batteryAmount;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        //Button submit = findViewById(R.id.button);
        //submit.setOnClickListener(onBtnClick());

    }

    public void btn (View view)
    {
        EditText paperInput = findViewById(R.id.paperInput);
        EditText plasticInput = findViewById(R.id.plasticInput);
        EditText glassInput = findViewById(R.id.glassInput);
        EditText oilInput = findViewById(R.id.oilInput);
        EditText batteryInput = findViewById(R.id.batteryInput);

        paperAmount = Integer.parseInt(paperInput.getText().toString());
        plasticAmount = Integer.parseInt(plasticInput.getText().toString());
        glassAmount = Integer.parseInt(glassInput.getText().toString());
        oilAmount = Integer.parseInt(oilInput.getText().toString());
        batteryAmount = Integer.parseInt(batteryInput.getText().toString());

        //int n = calculateScore();
        TextView text = findViewById(R.id.textView);
        text.setText("idk");
        calculateScore();
        TextView number = findViewById(R.id.editTextNumber);
        //int n = Integer.parseInt(number.getText().toString());
        //number.setText(calculateScore());
    }

    public int calculateScore()
    {
        totalScore = paperAmount*paper + plasticAmount*plastic + glassAmount*glass + oilAmount*oil + batteryAmount*battery;
        System.out.println("offffffffff \n" + totalScore);
        return totalScore;
    }


}


