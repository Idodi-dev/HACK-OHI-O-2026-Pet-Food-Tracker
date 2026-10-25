package com.hackohio.app;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetFoodRepository extends JpaRepository<PetFood, Long> {
    // Filters down by the associated user's ID AND applies a case-insensitive partial match on the brand
    List<PetFood> findByUserIdAndFoodNameContainingIgnoreCase(long userId, String foodName);

    // Returns all food types for a specific user if no search query is provided
    List<PetFood> findByUserId(Long userId);
}