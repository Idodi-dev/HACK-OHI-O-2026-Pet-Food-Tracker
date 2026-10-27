package com.hackohio.app;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity 
public class PetFood {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID", nullable = false) // Foreign key column
    private User user;

    // Getter and Setter for user
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    @Column
    private String foodName;
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
        this.foodName = productBrand;
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
        return foodName;
    }
    public void setProductBrand(String productBrand) {
        this.foodName = productBrand;
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
