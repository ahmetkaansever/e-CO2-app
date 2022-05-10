package com.aksdev.projectsecondaryusage;

import android.net.Uri;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class User  {
    String userName;
    String email;
    int score;


    public User( String userName, String email){
        this.userName = userName;
        this.email = email;
    }
    public User(){}
    //Firebase references

    Solutions solution;
    double totalEmission;
    double primaryEmission;
    double secondaryEmission;
    //Primary
    double houseHoldEmission;
    double electricityEmission;
    double naturalGasEmission;
    double gasEmission;
    double flightEmission;
    double carEmission;
    double subwayEmission;
    double busEmission;

    //Secondary
    double nutritionEmission;
    double pharmaceuticalEmission;
    double clothingEmission;
    double paperProductEmission;
    double itEmission;
    double motorEmission;
    double furnitureEmission;
    double hotelEmission;
    double educationEmission;

    public int getScore() {
        return score;
    }

    public void setGasEmission(double gasEmission) {
        this.gasEmission = gasEmission;
    }

    public double getTotalEmission() {
        return totalEmission;
    }

    public void setTotalEmission(double totalEmission) {
        this.totalEmission = totalEmission;
    }

    public double getPrimaryEmission() {
        return primaryEmission;
    }

    public void setPrimaryEmission(double primaryEmission) {
        this.primaryEmission = primaryEmission;
    }

    public double getSecondaryEmission() {
        return secondaryEmission;
    }

    public void setSecondaryEmission(double secondaryEmission) {
        this.secondaryEmission = secondaryEmission;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSolution(Solutions solution) {
        this.solution = solution;
    }

    public void setHouseHoldEmission(double houseHoldEmission) {
        this.houseHoldEmission = houseHoldEmission;
    }

    public void setElectricityEmission(double electricityEmission) {
        this.electricityEmission = electricityEmission;
    }

    public void setNaturalGasEmission(double naturalGasEmission) {
        this.naturalGasEmission = naturalGasEmission;
    }

    public void setLpgEmission(double gasEmission) {
        this.gasEmission = gasEmission;
    }

    public void setFlightEmission(double flightEmission) {
        this.flightEmission = flightEmission;
    }

    public void setCarEmission(double carEmission) {
        this.carEmission = carEmission;
    }

    public void setSubwayEmission(double subwayEmission) {
        this.subwayEmission = subwayEmission;
    }

    public void setBusEmission(double busEmission) {
        this.busEmission = busEmission;
    }

    public void setNutritionEmission(double nutritionEmission) {
        this.nutritionEmission = nutritionEmission;
    }

    public void setPharmaceuticalEmission(double pharmaceuticalEmission) {
        this.pharmaceuticalEmission = pharmaceuticalEmission;
    }

    public void setClothingEmission(double clothingEmission) {
        this.clothingEmission = clothingEmission;
    }

    public void setPaperProductEmission(double paperProductEmission) {
        this.paperProductEmission = paperProductEmission;
    }

    public void setItEmission(double itEmission) {
        this.itEmission = itEmission;
    }

    public void setMotorEmission(double motorEmission) {
        this.motorEmission = motorEmission;
    }

    public void setFurnitureEmission(double furnitureEmission) {
        this.furnitureEmission = furnitureEmission;
    }

    public void setHotelEmission(double hotelEmission) {
        this.hotelEmission = hotelEmission;
    }

    public void setEducationEmission(double educationEmission) {
        this.educationEmission = educationEmission;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public Solutions getSolution() {
        return solution;
    }

    public double getHouseHoldEmission() {
        return houseHoldEmission;
    }

    public double getElectricityEmission() {
        return electricityEmission;
    }

    public double getNaturalGasEmission() {
        return naturalGasEmission;
    }

    public double getGasEmission() {
        return gasEmission;
    }

    public double getFlightEmission() {
        return flightEmission;
    }

    public double getCarEmission() {
        return carEmission;
    }

    public double getSubwayEmission() {
        return subwayEmission;
    }

    public double getBusEmission() {
        return busEmission;
    }

    public double getNutritionEmission() {
        return nutritionEmission;
    }

    public double getPharmaceuticalEmission() {
        return pharmaceuticalEmission;
    }

    public double getClothingEmission() {
        return clothingEmission;
    }

    public double getPaperProductEmission() {
        return paperProductEmission;
    }

    public double getItEmission() {
        return itEmission;
    }

    public double getMotorEmission() {
        return motorEmission;
    }

    public double getFurnitureEmission() {
        return furnitureEmission;
    }

    public double getHotelEmission() {
        return hotelEmission;
    }

    public double getEducationEmission() {
        return educationEmission;
    }

    public void setScore(int a){
        score = a;
    }
}
