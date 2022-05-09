package com.aksdev.projectsecondaryusage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Recycle extends AppCompatActivity {

    private final int paper = 2;
    private final int plastic = 5;
    private final int glass=4;
    private final int oil=8;
    private final int battery=10;
    private final int clothes=6;
    
    User user;
    
    private int totalScore;
    private int paperAmount, plasticAmount, glassAmount, oilAmount, batteryAmount,clothesAmount;

 


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        Button submit = findViewById(R.id.button);
        //submit.setOnClickListener(onBtnClick());

    }

    public void btn (View view)
    {
        EditText paperInput = findViewById(R.id.paperInput);
        EditText plasticInput = findViewById(R.id.plasticInput);
        EditText glassInput = findViewById(R.id.glassInput);
        EditText oilInput = findViewById(R.id.oilInput);
        EditText batteryInput = findViewById(R.id.batteryInput);

        EditText clothesInput = findViewById(R.id.clothesInput);

        if(paperInput != null)
        {
            paperAmount = Integer.parseInt(paperInput.getText().toString());
        }
        
        if(plasticInput != null)
        {
            plasticAmount = Integer.parseInt(plasticInput.getText().toString());
        }
        
        if(glassInput != null)
        {
            glassAmount = Integer.parseInt(glassInput.getText().toString());
        }
        
        if(oilInput != null)
        {
            oilAmount = Integer.parseInt(oilInput.getText().toString());
        }
        
        if(batteryInput != null)
        {
            batteryAmount = Integer.parseInt(batteryInput.getText().toString());
        }
        
        if(clothesInput != null)
        {
            clothesAmount = Integer.parseInt(clothesInput.getText().toString());
        }
        
        //TEST
        //int n = calculateScore();
        TextView text = findViewById(R.id.textView);
        text.setText("idk");
        //calculateScore();
        TextView number = findViewById(R.id.editTextNumber);
        //number.setText(calculateScore());
        
        //ACTUAL METHOD WITH USER CLASS
        user.setScore(calculateScore());

    }

    public int calculateScore()
    {
            totalScore = paperAmount*paper + plasticAmount*plastic + glassAmount*glass + oilAmount*oil + batteryAmount*battery + clothesAmount*clothes;
            System.out.println("offffffffff \n" + totalScore);
            return totalScore;
    }

}


