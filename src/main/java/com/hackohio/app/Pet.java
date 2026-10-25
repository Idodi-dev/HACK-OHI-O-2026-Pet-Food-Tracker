package com.hackohio.app;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity 
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID", nullable = false) // Foreign key column
    private User user;

    // Getter and Setter for user
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    
    @Column
    private long userID;
    @Column
    private String name;
    @Column
    private double foodWeightPerServing;
    @Column
    private int servingsPerDay;
    @Column
    private Animal animal;
    @OneToOne
    private PetFood foodType;
    @Column
    private int servingsToday;
    @Column
    private double animalWeight;
    @Column
    private int age;
    @Column
    private double targetWeight;
    @Column
    private boolean reachedFoodLimit;
    private ArrayList<Reminder> reminders = new ArrayList<>();
    @Column
    private LocalDateTime lastFed = LocalDateTime.now();
    @Column
    private Duration maxTimeBetweenFeedings;
    @Column
    private final Duration feedingWindow = Duration.of(12, ChronoUnit.HOURS);


    
    public Pet(User user, String name, double foodWeightPerServing, int servingsPerDay, Pet.Animal animal,
            PetFood foodType, int servingsToday, double animalWeight, int age, double targetWeight,
            boolean reachedFoodLimit, ArrayList<Reminder> reminders) {
        this.user = user;
        this.name = name;
        this.foodWeightPerServing = foodWeightPerServing;
        this.servingsPerDay = servingsPerDay;
        this.animal = animal;
        this.foodType = foodType;
        this.servingsToday = servingsToday;
        this.animalWeight = animalWeight;
        this.age = age;
        this.targetWeight = targetWeight;
        this.reachedFoodLimit = reachedFoodLimit;
        this.reminders = reminders;

        this.maxTimeBetweenFeedings = Duration.of(feedingWindow.toMinutes()/servingsPerDay, ChronoUnit.MINUTES);
    }

    public Pet(long userID, String name, double foodWeightPerServing, int servingsPerDay, String foodNaem, double animalWeight, int age, double targetWeight) {
        this.userID = userID;
        this.name = name;
        this.foodWeightPerServing = foodWeightPerServing;
        this.servingsPerDay = servingsPerDay;
        this.animalWeight = animalWeight;
        this.age = age;
        this.targetWeight = targetWeight;

        this.maxTimeBetweenFeedings = Duration.of(feedingWindow.toMinutes()/servingsPerDay, ChronoUnit.MINUTES);
    }

    public Pet() {

    }

    public void meal() {
        lastFed = LocalDateTime.now();
        servingsToday++;
        if(servingsPerDay == servingsToday) {
            setReachedFoodLimit(true);
        }

        this.foodType.updateSupply(this.foodWeightPerServing);
    }

    public void update(){
        if (Duration.between(lastFed, LocalDateTime.now()).toMinutes() > this.maxTimeBetweenFeedings.toMinutes()) {
            ReminderManager.createFeedReminder(this.name);
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

    public void setName(String name) {
        this.name = name;
    }


    public void setFoodWeightPerServing(double foodWeightPerServing) {
        this.foodWeightPerServing = foodWeightPerServing;
    }


    public void setServingsPerDay(int servingsPerDay) {
        this.servingsPerDay = servingsPerDay;
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
        return servingsPerDay;
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

    @Override 
    public String toString() {
        return this.name;
    }
    
}
