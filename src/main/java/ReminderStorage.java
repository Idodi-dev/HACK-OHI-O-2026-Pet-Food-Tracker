import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

public class ReminderStorage {
    Map<Reminder.reminderType, ArrayList<Reminder>> remindersByType;
    ArrayList<Reminder> allReminders;

    public ReminderStorage() {
        allReminders = new ArrayList<Reminder>();

        remindersByType = new EnumMap<>(Reminder.reminderType.class);
        remindersByType.put(Reminder.reminderType.FEEDPET, new ArrayList<>());
        remindersByType.put(Reminder.reminderType.BUYFOOD, new ArrayList<>());
        remindersByType.put(Reminder.reminderType.VETVISIT, new ArrayList<>());
    }

    public void AddReminder(Reminder reminder) {
        remindersByType.get(reminder.getType()).add(reminder);
        allReminders.add(reminder);
    }

    public ArrayList<Reminder> getAllReminder(){
        return allReminders;
    }

    public ArrayList<Reminder> getRemindersByType(Reminder.reminderType type) {
        return remindersByType.get(type);
    }

}

