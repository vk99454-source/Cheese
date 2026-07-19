package org.example;

public class Cheese {
    private String milkTreatmentType;
    private String organic;
    private String moisturePercent;
    private String milkType;

    public Cheese(String milkTreatmentType, String organic,
                  String moisturePercent, String milkType) {
        this.milkTreatmentType = milkTreatmentType;
        this.organic = organic;
        this.moisturePercent = moisturePercent;
        this.milkType = milkType;
    }

    public String getMilkTreatmentType() {
        return milkTreatmentType;
    }

    public String getOrganic() {
        return organic;
    }

    public String getMoisturePercent() {
        return moisturePercent;
    }

    public String getMilkType() {
        return milkType;
    }
}