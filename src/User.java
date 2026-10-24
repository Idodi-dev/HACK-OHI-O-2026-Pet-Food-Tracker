import java.time.*;
import java.util.ArrayList;

public class User {
    String username;
    String password;
    ArrayList<Pet> userPets = new ArrayList<>();
    ArrayList<PetFood> foodTypes = new ArrayList<>();
    LocalDateTime localDateTime = LocalDateTime.now();
    ArrayList<Reminder> reminders = new ArrayList<>();

    public void updateTime() {
        this.localDateTime = localDateTime.now();
    }

    public void genericMeal() {
        updateTime();

    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
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
