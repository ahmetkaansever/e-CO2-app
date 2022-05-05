package com.aksdev.projectsecondaryusage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Calculatable {
    static double totalSecondaryUsage;

    //Coefficients
    final static double NUTRITION_CO = 0.00038; final static double PHARMACEUTICALS_CO = 0.00144; final static double CLOTHING_CO = 0.00022;
    final static double PAPER_PRODUCTS_CO = 0.00015; final static double IT_EQUIPMENT_CO = 0.00063; final static double MOTOR_VEHICLES = 0.00016;
    final static double FURNITURE_CO = 0.00017; final static double HOTELS_CO = 0.00021; final static double EDUCATION_CO = 0.00014;

    //Values
    static int nutrition, pharmaceuticals, clothing, paperProducts, itEquipment, motorVehicles, furniture, hotels, education;

    //Declarations of Texts
    TextView primaryText, pharmaceuticalsText, clothingText, paperProductText, itEquipmentText, motorVehiclesText,
    furnitureText, hotelsText, educationText, nutritionText;

    //Declarations of EditTexts
    EditText nutritionEditText, pharmaceuticalsEditText, clothingEditText, paperProductsEditText, itEquipmentEditText,
    motorVehiclesEditText, furnitureEditText, hotelsEditText, educationEditText;

    //Declaration of Buttons
    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Please write how much you have spent on given areas this month", Toast.LENGTH_LONG).show();

        //Instantiations
        nutritionEditText = findViewById(R.id.nutritionEditText);
        pharmaceuticalsEditText = findViewById(R.id.pharmaceuticalsEditText);
        clothingEditText = findViewById(R.id.clothingEditText);
        paperProductsEditText = findViewById(R.id.paperProductsEditText);
        itEquipmentEditText = findViewById(R.id.itEquipmentEditText);
        motorVehiclesEditText = findViewById(R.id.motorVehiclesEditText);
        furnitureEditText = findViewById(R.id.furnitureEditText);
        hotelsEditText = findViewById(R.id.hotelsEditText);
        educationEditText = findViewById(R.id.educationEditText);

        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("I am working!!!");
                if(!nutritionEditText.getText().toString().trim().equals("")){
                    nutrition = Integer.parseInt(nutritionEditText.getText().toString());
                }
                if(!pharmaceuticalsEditText.getText().toString().trim().equals("")){
                    pharmaceuticals = Integer.parseInt(pharmaceuticalsEditText.getText().toString());
                }
                if(!clothingEditText.getText().toString().trim().equals("")){
                    clothing = Integer.parseInt (clothingEditText.getText().toString());
                }
                if(!paperProductsEditText.getText().toString().trim().equals("")){
                    paperProducts = Integer.parseInt(paperProductsEditText.getText().toString());
                }
                if(!itEquipmentEditText.getText().toString().trim().equals("")){
                    itEquipment = Integer.parseInt(itEquipmentEditText.getText().toString());
                }
                if(!motorVehiclesEditText.getText().toString().trim().equals("")){
                    motorVehicles = Integer.parseInt(motorVehiclesEditText.getText().toString());
                }
                if(!furnitureEditText.getText().toString().trim().equals("")){
                    furniture = Integer.parseInt(furnitureEditText.getText().toString());
                }
                if(!hotelsEditText.getText().toString().trim().equals("")){
                    hotels = Integer.parseInt(hotelsEditText.getText().toString());
                }
                if(!educationEditText.getText().toString().trim().equals("")){
                    education = Integer.parseInt(educationEditText.getText().toString());
                }

                calculate();
                Toast.makeText(MainActivity.this, "Successfully submitted.", Toast.LENGTH_SHORT).show();
                System.out.println(totalSecondaryUsage);
            }
        });
    }

    //nutrition, pharmaceuticals, clothing, paperProducts, itEquipment, motorVehicles, furniture, hotels, education;

    public void calculate(){
        totalSecondaryUsage = (nutrition * NUTRITION_CO) + (pharmaceuticals * PHARMACEUTICALS_CO) + (clothing * CLOTHING_CO)
                            + (paperProducts * PAPER_PRODUCTS_CO) + (itEquipment * IT_EQUIPMENT_CO) + (motorVehicles * MOTOR_VEHICLES)
                            + (furniture * FURNITURE_CO) + (hotels * HOTELS_CO) + (education * EDUCATION_CO);
    }


}