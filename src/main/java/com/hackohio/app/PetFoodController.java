package com.hackohio.app;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

class FoodData {
    private String name;
    private String productBrand;
    private boolean isWet;
    private double totalWeight;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getProductBrand() {
        return productBrand;
    }
    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }
    public boolean isWet() {
        return isWet;
    }
    public void setWet(boolean isWet) {
        this.isWet = isWet;
    }
    public double getTotalWeight() {
        return totalWeight;
    }
    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }
}

@RestController
@RequestMapping("/api/v1/users/{userId}/food")
public class PetFoodController {

    private final PetFoodRepository petFoodRepository;
    private final UserRepository userRepository; // 1. Inject the UserRepository

    public PetFoodController(PetFoodRepository petFoodRepository, UserRepository userRepository) {
        this.petFoodRepository = petFoodRepository;
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<String> createFoodType(
            @PathVariable Long userId, // 2. Grab the specific user ID from the URL path
            @RequestBody FoodData newFoodType) {
        
        // 3. Look up the user in the Postgres database. Return 404 if not found.
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        // 4. Instantiate and map fields to your PetFood Entity
        PetFood petFood = new PetFood();
        petFood.setProductBrand(newFoodType.getProductBrand());
        petFood.setWet(newFoodType.isWet());
        petFood.setTotalWeight(newFoodType.getTotalWeight());
        petFood.setCurrentWeight(newFoodType.getTotalWeight());

        // 5. Associate the fetched user with this specific pet food row
        petFood.setUser(user);

        // 6. Save the data to PostgreSQL
        petFoodRepository.save(petFood);

        return ResponseEntity.status(HttpStatus.CREATED).body("Food created and linked to user successfully");
    }

    @GetMapping
    public ResponseEntity<List<PetFood>> findFoodType(
            @PathVariable Long userId, @RequestParam(name = "foodName", required = false) String foodName) {
        
        List<PetFood> results;
        
        // If a brand query parameter is passed, filter by it. Otherwise, return all food for this user.
        if (foodName != null && !foodName.trim().isEmpty()) {
            results = petFoodRepository.findByUserIdAndFoodNameContainingIgnoreCase(userId, foodName);
        } else {
            results = petFoodRepository.findByUserId(userId);
        }
        
        return ResponseEntity.ok(results);
    }
}
