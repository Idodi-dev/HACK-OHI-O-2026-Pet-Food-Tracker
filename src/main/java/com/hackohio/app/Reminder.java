package com.hackohio.app;

import java.time.LocalDateTime;

public class Reminder {
    private reminderType type;
    private String petName;
    private LocalDateTime time;

    private String foodName;
    private int daysUntilEmpty;

    public Reminder(LocalDateTime reminderTime){
        this.time = reminderTime;
    }


    public void setAsFeedReminder(String petName){
        this.type = reminderType.FEEDPET;
        this.petName = petName;
    }

    public void setAsBuyFoodReminder(String petName, int daysUntilEmpty){
        this.type = reminderType.BUYFOOD;
        this.petName = petName;
        this.daysUntilEmpty = daysUntilEmpty;
    }

    public void setAsVetVisitReminder(String petName){
        this.type = reminderType.VETVISIT;
        this.petName = petName;
    }



    @Override 
    public String toString() {

        return switch (this.type) {
            case FEEDPET -> this.petName + " is due to be fed.";
            case BUYFOOD -> this.foodName + " will be out in " + daysUntilEmpty + " days!";
            case VETVISIT -> this.petName + " is due for a vet check up.";
            default -> "Generic Reminder";
        };
    }

    public LocalDateTime getTime() {
        return time;
    }

    public reminderType getType() {
        return type;
    }
    
    public enum reminderType{
        FEEDPET, BUYFOOD, VETVISIT;
    }
}
