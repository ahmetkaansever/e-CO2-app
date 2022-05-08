package com.aksdev.projectsecondaryusage;

public class PastCalculations {

    private int primaryData;
    private  int secondaryData;
    private  String pastDate;

    PastCalculations(int primaryData, int secondaryData, String pastDate){
        this.pastDate = pastDate;
        this.primaryData = primaryData;
        this.secondaryData = secondaryData;
    }

    public int getPrimaryData() {
        return primaryData;
    }

    public void setPrimaryData(int primaryData) {
        this.primaryData = primaryData;
    }

    public int getSecondaryData() {
        return secondaryData;
    }

    public void setSecondaryData(int secondaryData) {
        this.secondaryData = secondaryData;
    }

    public String getPastDate() {
        return pastDate;
    }

    public void setPastDate(String pastDate) {
        this.pastDate = pastDate;
    }

    public String printPast(){
        String result = "";
        result += "Date of the calculation: " + getPastDate() + "\n";
        result += "Primary Usage: " + getPrimaryData() + "\n";
        result += "Secondary Usage: " + getSecondaryData() + "\n";
        return result;
    }
}
