package com.hackohio.app;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    // 1. Get the names of all pets associated with a specific userid
    // Uses a custom JPQL projection query to fetch just strings instead of full objects
    @Query("SELECT p.name FROM Pet p WHERE p.user.id = :userId")
    List<String> findNamesByUserId(@Param("userId") Long userId);

    // 2. Get a specific pet from the table based on the userid and pet's name populated
    // Returns an Optional in case no pet matches that specific name for that user
    Optional<Pet> findByUserIdAndNameIgnoreCase(Long userId, String name);

    List<Pet> findByUserId(Long userId);
}