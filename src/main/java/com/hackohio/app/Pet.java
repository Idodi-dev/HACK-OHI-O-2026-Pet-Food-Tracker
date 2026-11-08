package com.hackohio.app;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity 
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID", nullable = false) // Foreign key column
    private User user;

    // Getter and Setter for user
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    
    @Column
    private String name;
    @Column
    private double foodWeightPerServing;
    @Column
    private int servingsPerDay;
    @Column
    private String animal;
    @ManyToMany
    @JoinTable(name = "pet_foods",
        joinColumns = @JoinColumn(name = "pet_id"),
        inverseJoinColumns = @JoinColumn(name = "food_id"))
    private List<PetFood> foodTypes = new ArrayList<>();
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
    @Transient
    private ArrayList<Reminder> reminders = new ArrayList<>();
    @Column
    private LocalDateTime lastFed = LocalDateTime.now();
    @Column
    private Duration maxTimeBetweenFeedings;
    @Column
    private final Duration feedingWindow = Duration.of(12, ChronoUnit.HOURS);


    
    public Pet(User user, String name, double foodWeightPerServing, int servingsPerDay, String animal,
            List<PetFood> foodTypes, int servingsToday, double animalWeight, int age, double targetWeight,
            boolean reachedFoodLimit, ArrayList<Reminder> reminders) {
        this.user = user;
        this.name = name;
        this.foodWeightPerServing = foodWeightPerServing;
        this.servingsPerDay = servingsPerDay;
        this.animal = animal;
        this.foodTypes = foodTypes;
        this.servingsToday = servingsToday;
        this.animalWeight = animalWeight;
        this.age = age;
        this.targetWeight = targetWeight;
        this.reachedFoodLimit = reachedFoodLimit;
        this.reminders = reminders;

        this.maxTimeBetweenFeedings = Duration.of(feedingWindow.toMinutes()/servingsPerDay, ChronoUnit.MINUTES);
    }

    public Pet(String name, double foodWeightPerServing, int servingsPerDay, String animal, double animalWeight, int age, double targetWeight) {
        this.name = name;
        this.foodWeightPerServing = foodWeightPerServing;
        this.servingsPerDay = servingsPerDay;
        this.animal = animal;
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

        Iterator<PetFood> iterator = this.foodTypes.iterator();
        while(iterator.hasNext()) {
            PetFood foodType = iterator.next();
            
            if(foodType != null) {
                foodType.updateSupply(this.foodWeightPerServing);
            }
        }
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


    public void setAnimal(String animal) {
        this.animal = animal;
    }


    public void setFoodTypes(List<PetFood> foodTypes) {
        this.foodTypes = foodTypes;
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

    public Long getId() {
        return this.id;
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


    public String getAnimal() {
        return animal;
    }


    public List<PetFood> getFoodTypes() {
        return foodTypes;
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

    @Override 
    public String toString() {
        return this.name;
    }
    
}
