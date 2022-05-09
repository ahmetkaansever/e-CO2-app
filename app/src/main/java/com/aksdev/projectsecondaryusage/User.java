package com.aksdev.projectsecondaryusage;

import android.net.Uri;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class User  {
    String userName;
    String email;
    String profileColor;



    String password;
    Uri picture;

    public User( String userName, String email){
        this.userName = userName;
        this.email = email;
    }
    public User(){}
    //Firebase references


    Solutions solution;
    double gasEmission;
    double motorEmission;
    double nutritionEmission;
    double totalEmission;
    double totalSecondaryEmission;
    double totalPrimaryEmission;
    double paperEmission;
    double itEmission;
    double hotelEmission;

    public double getGasEmission() {
        return gasEmission;
    }

    public double getMotorEmission() {
        return motorEmission;
    }

    public double getNutritionEmission() {
        return nutritionEmission;
    }

    public double getPaperEmission() {
        return paperEmission;
    }

    public double getItEmission() {
        return itEmission;
    }

    public double getHotelEmission() {
        return hotelEmission;
    }

    public double getClothingEmission() {
        return clothingEmission;
    }

    public double getPharmaceuticalsEmission() {
        return pharmaceuticalsEmission;
    }

    double clothingEmission;
    double score;
    double pharmaceuticalsEmission;

    //getters
    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getProfileColor() {
        return profileColor;
    }

    public Solutions getSolution() {
        return solution;
    }

    public double getTotalEmission() {
        return totalEmission;
    }

    public double getTotalSecondaryEmission() {
        return totalSecondaryEmission;
    }

    public double getTotalPrimaryEmission() {
        return totalPrimaryEmission;
    }

    public double getScore() {
        return score;
    }

    //setter for score
    public void setScore(int s){
        score += s;
    }

    public void setUserName(String name){
        this.userName = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProfileColor(String profileColor) {
        this.profileColor = profileColor;
    }

    public void setSolution(Solutions solution) {
        this.solution = solution;
    }

    public void setGasEmission(double gasEmission) {
        this.gasEmission = gasEmission;
    }

    public void setMotorEmission(double motorEmission) {
        this.motorEmission = motorEmission;
    }

    public void setNutritionEmission(double nutritionEmission) {
        this.nutritionEmission = nutritionEmission;
    }

    public void setTotalEmission(double totalEmission) {
        this.totalEmission = totalEmission;
    }

    public void setTotalSecondaryEmission(double totalSecondaryEmission) {
        this.totalSecondaryEmission = totalSecondaryEmission;
    }

    public void setTotalPrimaryEmission(double totalPrimaryEmission) {
        this.totalPrimaryEmission = totalPrimaryEmission;
    }

    public void setPaperEmission(double paperEmission) {
        this.paperEmission = paperEmission;
    }

    public void setItEmission(double itEmission) {
        this.itEmission = itEmission;
    }

    public void setHotelEmission(double hotelEmission) {
        this.hotelEmission = hotelEmission;
    }

    public void setClothingEmission(double clothingEmission) {
        this.clothingEmission = clothingEmission;
    }


}
