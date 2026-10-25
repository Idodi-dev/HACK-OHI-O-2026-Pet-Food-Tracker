package com.hackohio.app;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

// CLASSES FOR RequestBody
class UserData {
    private Long id;
    private String username;
    private String password;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
}


@RestController
@RequestMapping("/api/users") // Sets a base path for all endpoints in this class
@CrossOrigin(origins = "*")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserData newUser) {
        User createdUser = new User(newUser.getUsername(), newUser.getPassword());
        User savedUser = userRepository.save(createdUser);

        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<User>> getUser() {
        List<User> users = userRepository.findAll();
        
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build(); // Optional: Returns 204 No Content if empty
        }
        
        return ResponseEntity.ok(users); 
        
    }
    
}
