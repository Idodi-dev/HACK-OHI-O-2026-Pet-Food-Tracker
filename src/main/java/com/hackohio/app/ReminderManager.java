package com.hackohio.app;

import java.time.LocalDateTime;

public class ReminderManager {
    private static final ReminderManager INSTANCE = new ReminderManager();
    private static final ReminderStorage STORAGE = new ReminderStorage();

    private ReminderManager() {}

    public static ReminderManager getInstance() {
        return INSTANCE;
    }

    public static void createFeedReminder(String petName){
        Reminder reminder = new Reminder(LocalDateTime.now());
        reminder.setAsFeedReminder(petName);
        STORAGE.AddReminder(reminder);
    }

    public static void createBuyFoodReminder(String foodName, int daysUntilEmpty){
        Reminder reminder = new Reminder(LocalDateTime.now());
        reminder.setAsBuyFoodReminder(foodName, daysUntilEmpty);

        STORAGE.AddReminder(reminder);
    }

    public static void createVetVisitReminder(String petName){
        Reminder reminder = new Reminder(LocalDateTime.now());
        reminder.setAsVetVisitReminder(petName);

        STORAGE.AddReminder(reminder);
    }
}
