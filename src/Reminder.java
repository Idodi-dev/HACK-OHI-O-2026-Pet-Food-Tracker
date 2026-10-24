import java.time.LocalDateTime;

public class Reminder {
    private reminderType type;
    private String petName;
    private String foodName;
    private LocalDateTime time;

    public Reminder(LocalDateTime reminderTime){
        this.time = reminderTime;
    }


    public void setAsFeedReminder(String petName){
        this.type = reminderType.FEEDPET;
        this.petName = petName;
    }

    public void setAsBuyFoodReminder(String petName){
        this.type = reminderType.BUYFOOD;
        this.petName = petName;
    }

    public void setAsVetVisitReminder(String petName){
        this.type = reminderType.VETVISIT;
        this.petName = petName;
    }



    @Override 
    public String toString() {

        return switch (this.type) {
            case FEEDPET -> this.petName + " is due to be fed.";
            case BUYFOOD -> this.foodName + " is running out!";
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
