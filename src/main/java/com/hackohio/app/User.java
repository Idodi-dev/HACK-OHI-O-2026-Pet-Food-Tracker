package com.hackohio.app;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class User {

    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column
    private String username;
    @Column
    private String password;
    private ArrayList<Pet> userPets = new ArrayList<>();
    private ArrayList<PetFood> foodTypes = new ArrayList<>();
    @Column
    private LocalDateTime lastUpdateTime = LocalDateTime.now();

    public User() {

    }

    public User(Database database, String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void updateTime() {
        this.lastUpdateTime = LocalDateTime.now();
    }

    public void update() {
        updateTime();
        Database.update();

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

    public void newPet(Pet pet) {
        this.userPets.add(pet);
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
