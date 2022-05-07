package com.aksdev.projectsecondaryusage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Solutions extends AppCompatActivity {

    private final String[] solutionMessages = {};
    private ArrayList<TextView> solutionTextViews;
    private boolean[] compareBooleans;
    private double worldDifferencePercentage;
    private double countryDifferencePercentage;
    public final double WORLD_AVERAGE = 4.48;
    public final double COUNTRY_AVERAGE = 5.02; //TURKEY
    public final double AVG_GAS_EMISSION = 0.95;
    public final double AVG_MOTOR_EMISSION = 4.6;
    public final double AVG_NUTRITION_EMISSION = 0.18;
    public final double AVG_CLOTHING_EMISSION = 0.8;
    public final double AVG_IT_EMISSION = 2.0;
    private User user;

    public Solutions() {
        solutionTextViews = new ArrayList<>();
        compareBooleans = new boolean[5];
    }

    public Solutions(User user) {
        solutionTextViews = new ArrayList<>();
        compareBooleans = new boolean[5];
        setCompareBooleans();
        this.user = user;
    }
    public double compareWorldAverage(){

        if (this.user.getTotalEmission() >= WORLD_AVERAGE) {
            worldDifferencePercentage = (((this.user.getTotalEmission()) * 100) / WORLD_AVERAGE) - 100;
        }
        else {
            worldDifferencePercentage = (WORLD_AVERAGE * 100) / ((this.user.getTotalEmission())) - 100;
        }
        return worldDifferencePercentage;
    }

    public double compareCountryAverage(){

        if (this.user.getTotalEmission() >= COUNTRY_AVERAGE) {
            countryDifferencePercentage = (((this.user.getTotalEmission()) * 100) / COUNTRY_AVERAGE) - 100;
        }
        else{
            countryDifferencePercentage = (COUNTRY_AVERAGE * 100) / ((this.user.getTotalEmission())) - 100;
        }
        return countryDifferencePercentage;
    }

    public void setCompareBooleans(){

        for (int i = 0; i < compareBooleans.length; i++) {
            compareBooleans[i] = false;

            if (this.user.getGasEmission() > AVG_GAS_EMISSION) {
                compareBooleans[0] = true;
            }
            if (this.user.getMotorEmission() > AVG_MOTOR_EMISSION) {
                compareBooleans[1] = true;
            }
            if (this.user.getNutritionEmission() > AVG_NUTRITION_EMISSION) {
                compareBooleans[2] = true;
            }
            if (this.user.getClothingEmission() > AVG_CLOTHING_EMISSION) {
                compareBooleans[3] = true;
            }
            if (this.user.getItEmission() > AVG_IT_EMISSION) {
                compareBooleans[4] = true;
            }
        }
    }

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_solutions);

            TextView solution1 = (TextView) findViewById(R.id.solutionText1);
            TextView solution2 = (TextView) findViewById(R.id.solutionText2);
            TextView solution3 = (TextView) findViewById(R.id.solutionText3);
            TextView solution4 = (TextView) findViewById(R.id.solutionText4);
            TextView solution5 = (TextView) findViewById(R.id.solutionText5);
            TextView solution6 = (TextView) findViewById(R.id.solutionText6);
            TextView solution7 = (TextView) findViewById(R.id.solutionText7);
            TextView solution8 = (TextView) findViewById(R.id.solutionText8);
            TextView solution9 = (TextView) findViewById(R.id.solutionText9);
            TextView solution10 = (TextView) findViewById(R.id.solutionText10);


            solutionTextViews.add(solution1);
            solutionTextViews.add(solution2);
            solutionTextViews.add(solution3);
            solutionTextViews.add(solution4);
            solutionTextViews.add(solution5);
            solutionTextViews.add(solution6);
            solutionTextViews.add(solution7);
            solutionTextViews.add(solution8);
            solutionTextViews.add(solution9);
            solutionTextViews.add(solution10);



            if(this.user.getTotalEmission() > WORLD_AVERAGE){
                solution1.setText("You are " + compareWorldAverage() + "% above world average carbon emission rates.");
            }
            else{
                solution1.setText("You are " + compareWorldAverage() + "% under world average carbon emission rates.");
            }

            if(this.user.getTotalEmission() > COUNTRY_AVERAGE){
                solution2.setText("You are " + compareCountryAverage() + "% above your country average carbon emission rates.");
            }
            else{
                solution2.setText("You are " + compareCountryAverage() + "% under your country average carbon emission rates.");
            }

            int a = 2;

            for(int index = 0; index < compareBooleans.length; index++){

                if(compareBooleans[index] == true && index == 0) {

                    solutionTextViews.get(a).setText("Your gas usage is higher than the world average. Try turning off the heat when your not home.");
                    a++;
                }
                else if(compareBooleans[index] == true && index == 1) {

                    solutionTextViews.get(a).setText("Your car usage is higher than the world average. Try using public transportation if possible.");
                    a++;
                }
                else if(compareBooleans[index] == true && index == 2) {

                    solutionTextViews.get(a).setText("Your carbon emission rates from food usage is higher than the world average. Try avoiding prepackaged food for less contamination.");
                    a++;
                }
                else if(compareBooleans[index] == true && index == 3) {

                    solutionTextViews.get(a).setText("Your clothing purchase is higher than the world average. Try to visit thrift stores and stay away from fast fashion brands.");
                    a++;
                }
                else if(compareBooleans[index] == true && index == 4) {

                    solutionTextViews.get(a).setText("Your IT purchase is higher than the world average. Recycling your old devices after buying new ones might help.");
                    a++;
                }




            }

            solution1.setText("You are % above world average carbon emission rates.");
            solution2.setText("You are % above country average carbon emission rates.");
            solution3.setText("Your gas usage is higher than the world average. Try turning off the heat when your not home.");
            solution4.setText("Your car usage is higher than the world average. Try using public transportation for a change.");
            solution5.setText("Your carbon emission rates from food usage is higher than the world average. Try avoiding prepackaged food for less contamination.");
            solution6.setText("Your clothing purchase is higher than the world average. Try to visit thrift stores and stay away from fast fashion brands.\"");
            solution7.setText("Your IT purchase is higher than the world average. Recycling your old devices after buying new ones might help.\"");



        }
    }
