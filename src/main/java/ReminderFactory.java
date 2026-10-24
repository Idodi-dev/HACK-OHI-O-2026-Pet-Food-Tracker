import java.time.LocalDateTime;

public class ReminderFactory {

    public static Reminder createFeedReminder(String petName){
        Reminder reminder = new Reminder(LocalDateTime.now());
        reminder.setAsFeedReminder(petName);

        return reminder;
    }

    public static Reminder createBuyFoodReminder(String foodName, int daysUntilEmpty){
        Reminder reminder = new Reminder(LocalDateTime.now());
        reminder.setAsBuyFoodReminder(foodName, daysUntilEmpty);

        return reminder;
    }

    public static Reminder createVetVisitReminder(String petName){
        Reminder reminder = new Reminder(LocalDateTime.now());
        reminder.setAsVetVisitReminder(petName);

        return reminder;
    }
}
