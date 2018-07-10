package com.example.android.group;

public class Vehicle {
    private String offence,rule,type;
    private int fine;


    public Vehicle() {
    }

    public Vehicle(String offence, String rule, String type, int fine) {
        this.offence = offence;
        this.rule = rule;
        this.type = type;
        this.fine = fine;
    }

    public String getOffence() {
        return offence;
    }

    public void setOffence(String offence) {
        this.offence = offence;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }
}
