package com.hackohio.app;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class PetFood {
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column
    private String productBrand;
    @Column
    private boolean isWet;
    @Column
    private double totalWeight;
    @Column
    private double currentWeight;
    @Column
    private int daysLeftUntilRefill;
    @Column
    private double totalDailyUsageWeight;

    public PetFood() {

    }
    
    public PetFood(String productBrand, boolean isWet, double totalWeight, double currentWeight,
            int daysLeftUntilRefill) {
        this.productBrand = productBrand;
        this.isWet = isWet;
        this.totalWeight = totalWeight;
        this.currentWeight = currentWeight;
        this.daysLeftUntilRefill = daysLeftUntilRefill;

        totalDailyUsageWeight = 0;
    }

    public void updateSupply(double amount){
        this.currentWeight -= amount;

        if (this.currentWeight < 0) {
            this.currentWeight = 0;
        }

        daysLeftUntilRefill = (int) Math.round(totalWeight/totalDailyUsageWeight);
    }

    public void updateUsage(double amount) {
        this.totalDailyUsageWeight += amount;
    }

    public String getProductBrand() {
        return productBrand;
    }
    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }
    public boolean isWet() {
        return isWet;
    }
    public void setWet(boolean isWet) {
        this.isWet = isWet;
    }
    public double getTotalWeight() {
        return totalWeight;
    }
    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }
    public double getCurrentWeight() {
        return currentWeight;
    }
    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }
    public int getDayLeftUntilRefill() {
        return daysLeftUntilRefill;
    }
    public void setDayLeftUntilRefill(int dayLeftUntilRefill) {
        this.daysLeftUntilRefill = dayLeftUntilRefill;
    }


}
