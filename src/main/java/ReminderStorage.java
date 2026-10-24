import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

public class ReminderStorage {
    Map<Reminder.reminderType, ArrayList<Reminder>> remindersByType;

    public ReminderStorage() {
        remindersByType = new EnumMap<>(Reminder.reminderType.class);

        remindersByType.put(Reminder.reminderType.FEEDPET, new ArrayList<>());
        remindersByType.put(Reminder.reminderType.BUYFOOD, new ArrayList<>());
        remindersByType.put(Reminder.reminderType.VETVISIT, new ArrayList<>());
    }

    public void AddReminder(Reminder reminder) {
        remindersByType.get(reminder.getType());
    }

}

