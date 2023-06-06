package ac.rs.metropolitan.it355pz.controllers;

import ac.rs.metropolitan.it355pz.entities.User;
import ac.rs.metropolitan.it355pz.security.AuthenticationService;
import ac.rs.metropolitan.it355pz.security.model.LoginRequestDTO;
import ac.rs.metropolitan.it355pz.security.model.LoginResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate")
//@CrossOrigin("*")
public class LoginController {

    private final AuthenticationService authenticationService;

    @Autowired
    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginDTO) {
        return ResponseEntity.ok(authenticationService.authenticate(loginDTO));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws Exception {
        return ResponseEntity.ok(authenticationService.save(user));
    }
}
