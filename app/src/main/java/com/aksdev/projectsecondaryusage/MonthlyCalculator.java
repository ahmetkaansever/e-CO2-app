package com.aksdev.projectsecondaryusage;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.util.Calendar;

public class MonthlyCalculator extends AppCompatActivity implements Calculatable{
//private TextView dateText = findViewById(R.id.dateText);  // Display current date
private TextView dateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.monthly_calculator);
        dateText = findViewById(R.id.dateText);

    }
    public void  onBtnClick(View view ){
        Boolean check = false;
        //Date Log-in

        Calendar currentCalender = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(currentCalender.getTime());
        dateText.setText(currentDate);
        //Primary Usage
        String primary = findViewById(R.id.PrimaryText).toString();
        int primaryInt = Integer.parseInt(primary);
        //Secondary Usage
        String secondary = findViewById(R.id.SecondaryEditText).toString();
        int secondaryInt = Integer.parseInt(secondary);

        if(primaryInt >= 0 && secondaryInt >= 0){
            //PastCalculations Object
            try{
                PastCalculations newCalculation = new PastCalculations(primaryInt, secondaryInt, currentDate);
            }
            catch (Exception e){
                String cause = e.getCause().toString();
                switch (cause){
                    case  "ArithmeticException" :
                        Toast.makeText(MonthlyCalculator.this, "Please Enter Valid values", Toast.LENGTH_LONG);
                        break;
                    default:
                        Toast.makeText(MonthlyCalculator.this, "Something went wrong", Toast.LENGTH_LONG);
                        break;
                }
            }
        }
        else{
            Toast.makeText(MonthlyCalculator.this, "Please Enter Valid Values", Toast.LENGTH_LONG);
        }
    }

    @Override
    public void calculate() {
        // Firebase addition
    }
}