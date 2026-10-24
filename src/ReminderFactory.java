import java.time.LocalDateTime;

public class ReminderFactory {

    public Reminder createFeedReminder(String petName){
        Reminder reminder = new Reminder(LocalDateTime.now());
        reminder.setAsFeedReminder(petName);

        return reminder;
    }

    public Reminder createBuyFoodReminder(String foodName){
        Reminder reminder = new Reminder(LocalDateTime.now());
        reminder.setAsBuyFoodReminder(foodName);

        return reminder;
    }

    public Reminder createVetVisitReminder(String petName){
        Reminder reminder = new Reminder(LocalDateTime.now());
        reminder.setAsVetVisitReminder(petName);

        return reminder;
    }
}
