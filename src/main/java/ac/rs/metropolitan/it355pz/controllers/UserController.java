package ac.rs.metropolitan.it355pz.controllers;

import ac.rs.metropolitan.it355pz.entities.User;
import ac.rs.metropolitan.it355pz.services.UserService;
import ac.rs.metropolitan.it355pz.services.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;

    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.findAll());
    }


    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/{username}")
    public Optional<User> findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @DeleteMapping("/{userId}")
    public void deleteById(@PathVariable Long userId) {
        userService.deleteById(userId);
    }

}
