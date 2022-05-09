package com.aksdev.projectsecondaryusage;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PrimaryUsage extends AppCompatActivity {
    int[] Primerylist = new int[8];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary_usage);

    }
    public void onBtnClick (View view) {

        EditText hauseholdEditText =  findViewById(R.id.hauseholdEditText);
        Primerylist[0] = Integer.parseInt(hauseholdEditText.getText().toString());

        EditText electricityEditText =  findViewById(R.id.electricityEditText);
        Primerylist[1] = Integer.parseInt(electricityEditText.getText().toString());

        EditText naturalGasEditText =  findViewById(R.id.naturalGasEditText);
        Primerylist[2] = Integer.parseInt(naturalGasEditText.getText().toString());

        EditText lpgEditText =  findViewById(R.id.lpgEditText);
        Primerylist[3] =Integer.parseInt(lpgEditText.getText().toString());

        EditText flightEditText =  findViewById(R.id.flightEditText);
        Primerylist[4] = Integer.parseInt(flightEditText.getText().toString());

        EditText carEditText =  findViewById(R.id.carEditText);
        Primerylist[5] = Integer.parseInt(carEditText.getText().toString());

        EditText subwayEditText =  findViewById(R.id.subwayEditText);
        Primerylist[6] = Integer.parseInt(subwayEditText.getText().toString());

        EditText busEditText =  findViewById(R.id.busEditText);
        Primerylist[7] = Integer.parseInt(busEditText.getText().toString());

    }
    public int calculatePrimary(int[] primerylist){
        int result =0;
        int multp = primerylist[0];
        int index = 1;
        /**
         * index
         *  0:  household in int
         *  1:  electricity in kW
         *  2:  natural gas in m^3
         *  3:  lpg in m^3
         *  4:  flight in miles
         *  5:  car in km
         *  6:  subway in km
         *  7:  bus in km
         */
        while(index < 8){
            String indexString = ""+index;
            switch (indexString){
                case "1" : result += (10.5)* primerylist[index];
                    break;
                case "2" : result += (10.5)* primerylist[index];
                    break;
                case "3" : result += (11.3)* primerylist[index];
                    break;
                case "4" : result += (1.1)* primerylist[index];
                    break;
                case "5" : result += (0.8)* primerylist[index];
                    break;
                case "6" : result += (0.2)* primerylist[index];
                    break;
                case "7" : result += (0.3)* primerylist[index];
                    break;
                default: result+= 0;
                    break;
            }
        }
        return (int) (result * multp * 10);
    }
}