import java.time.*;
import java.util.ArrayList;
import java.util.Iterator;

public class User {
    String username;
    String password;
    ArrayList<Pet> userPets = new ArrayList<>();
    ArrayList<PetFood> foodTypes = new ArrayList<>();
    LocalDateTime lastUpdateTime = LocalDateTime.now();
    ArrayList<Reminder> reminders = new ArrayList<>();

    public void updateTime() {
        this.lastUpdateTime = LocalDateTime.now();
    }

    public void update() {
        updateTime();
        updateDatabase();

        LocalDateTime now = LocalDateTime.now();

        if(now.getDayOfYear() != lastUpdateTime.getDayOfYear() && now.getYear() != now.getYear()) {
            newDayUpdate();
        }
    }

    public void newDayUpdate() {
        Iterator<Pet> iterator = userPets.iterator();
        while(iterator.hasNext()) {
            Pet currPet = iterator.next();
            currPet.newDay();
        }
    }

    public void updateDatabase() {
        Database.update();
    }

    public LocalDateTime getLocalDateTime() {
        return lastUpdateTime;
    }
    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.lastUpdateTime = localDateTime;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public ArrayList<Pet> getUserPets() {
        return userPets;
    }
    public void setUserPets(ArrayList<Pet> userPets) {
        this.userPets = userPets;
    }
    public ArrayList<PetFood> getFoodTypes() {
        return foodTypes;
    }
    public void setFoodTypes(ArrayList<PetFood> foodTypes) {
        this.foodTypes = foodTypes;
    }


}
