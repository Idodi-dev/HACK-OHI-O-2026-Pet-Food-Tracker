
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Pet {
    User user;
    String name;
    double foodWeightPerServing;
    int servingsPerDay;
    Animal animal;
    PetFood foodType;
    int servingsToday;
    double animalWeight;
    int age;
    double targetWeight;
    boolean reachedFoodLimit;
    ArrayList<Reminder> reminders = new ArrayList<>();
    LocalDateTime lastFed = LocalDateTime.now();

    public void meal() {
        lastFed = LocalDateTime.now();
        servingsToday++;
        if(servingsPerDay == servingsToday) {
            setReachedFoodLimit(true);
        }
    }

    public void newDay() {
        servingsToday = 0;
    }

    public boolean isReachedFoodLimit() {
        return reachedFoodLimit;
    }

    public void setReachedFoodLimit(boolean reachedFoodLimit) {
        this.reachedFoodLimit = reachedFoodLimit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setFoodWeightPerServing(double foodWeightPerServing) {
        this.foodWeightPerServing = foodWeightPerServing;
    }


    public void setServingsPerDay(int servingsPerDay) {
        ServingsPerDay = servingsPerDay;
    }


    public void setAnimal(Animal animal) {
        this.animal = animal;
    }


    public void setFoodType(PetFood foodType) {
        this.foodType = foodType;
    }


    public void setServingsToday(int servingsToday) {
        this.servingsToday = servingsToday;
    }


    public void setAnimalWeight(double animalWeight) {
        this.animalWeight = animalWeight;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public void setTargetWeight(double targetWeight) {
        this.targetWeight = targetWeight;
    }


    public String getName() {
        return name;
    }


    public double getFoodWeightPerServing() {
        return foodWeightPerServing;
    }


    public int getServingsPerDay() {
        return ServingsPerDay;
    }


    public Animal getAnimal() {
        return animal;
    }


    public PetFood getFoodType() {
        return foodType;
    }


    public int getServingsToday() {
        return servingsToday;
    }


    public double getAnimalWeight() {
        return animalWeight;
    }


    public int getAge() {
        return age;
    }


    public double getTargetWeight() {
        return targetWeight;
    }

    public ArrayList<Reminder> getReminders() {
        return reminders;
    }

    public void setReminders(ArrayList<Reminder> reminders) {
        this.reminders = reminders;
    }

    public LocalDateTime getLastFed() {
        return lastFed;
    }

    public void setLastFed(LocalDateTime lastFed) {
        this.lastFed = lastFed;
    }


    enum Animal {
        dog, cat, lizard, rabbit, hamster, bird, gerbil, cow, duck, chicken, 
        sheep, pig;
    }
    
}
