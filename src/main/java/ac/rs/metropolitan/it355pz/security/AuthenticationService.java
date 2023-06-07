package ac.rs.metropolitan.it355pz.security;

import ac.rs.metropolitan.it355pz.entities.User;
import ac.rs.metropolitan.it355pz.exceptions.custom.NotFoundException;
import ac.rs.metropolitan.it355pz.security.model.LoginRequestDTO;
import ac.rs.metropolitan.it355pz.security.model.LoginResponseDTO;
import ac.rs.metropolitan.it355pz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationService(UserService userService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var optionalUser = userService.findByUsername(username);

        if (optionalUser.isEmpty()) {
            throw new NotFoundException("Username doesn't exist");
        }

        var user = optionalUser.get();

        return new AuthenticatedUser(user);
    }

    public LoginResponseDTO authenticate(LoginRequestDTO loginDTO) {
        var authenticatedUser = (AuthenticatedUser) loadUserByUsername(loginDTO.username());

        System.out.println(authenticatedUser.toString());
        System.out.println(loginDTO.password());


        var accessToken = jwtUtil.createToken(authenticatedUser);

        return new LoginResponseDTO(accessToken);
    }




    public User save(User user) {
        User newUser = new User();
        newUser.setFirstname(user.getFirstname());
        newUser.setSurname(user.getSurname());
        newUser.setEmail(user.getEmail());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setRole("ROLE_USER");
        return userService.save(newUser);
    }

}
