package com.example.ratemanagment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Surcharge {
    @JsonProperty("surchargeRate")
    private int surchargeRate;

    @JsonProperty("surchargeDescription")
    private String surchargeDescription;

    public int getSurchargeRate() {
        return surchargeRate;
    }

    public void setSurchargeRate(int surchargeRate) {
        this.surchargeRate = surchargeRate;
    }

    public String getSurchargeDescription() {
        return surchargeDescription;
    }

    public void setSurchargeDescription(String surchargeDescription) {
        this.surchargeDescription = surchargeDescription;
    }
}
