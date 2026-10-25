package com.hackohio.app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

class PetData {
    private long userId;
    private String name;
    private double foodWeightPerServing;
    private int servingsPerDay;
    private String foodName;
    private double animalWeight;
    private int age;
    private double targetWeight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFoodWeightPerServing() {
        return foodWeightPerServing;
    }

    public void setFoodWeightPerServing(double foodWeightPerServing) {
        this.foodWeightPerServing = foodWeightPerServing;
    }

    public int getServingsPerDay() {
        return servingsPerDay;
    }

    public void setServingsPerDay(int servingsPerDay) {
        this.servingsPerDay = servingsPerDay;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getAnimalWeight() {
        return animalWeight;
    }

    public void setAnimalWeight(double animalWeight) {
        this.animalWeight = animalWeight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(double targetWeight) {
        this.targetWeight = targetWeight;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}

@RestController
@RequestMapping("/api/v1/users/{userId}/pets")
public class PetController {

    private final PetFoodRepository petRepository;

    // Inject the repository via constructor
    public PetController(PetFoodRepository petFoodRepository) {
        this.petRepository = petFoodRepository;
    }

    @PostMapping
    public ResponseEntity<String> addPet(@PathVariable Long userId, @RequestBody PetData newPet) {
        Pet createdPet = new Pet(newPet.getName(), newPet.getFoodWeightPerServing(), 
        newPet.getServingsPerDay(), newPet.getFoodName(), newPet.getAnimalWeight(), newPet.getAge(), newPet.getTargetWeight());

        //petRepository.save(createdPet, userId);

        return ResponseEntity.ok("Pet added successfully.");
    }

}
