package ac.rs.metropolitan.it355pz.services.impl;

import ac.rs.metropolitan.it355pz.entities.User;
import ac.rs.metropolitan.it355pz.repositories.UserRepository;
import ac.rs.metropolitan.it355pz.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(Long.valueOf(id));
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User update(User updatedUser) {
        User user = userRepository.findById(updatedUser.getId()).orElseThrow(EntityNotFoundException::new);
        user.setFirstname(updatedUser.getFirstname());
        user.setSurname(updatedUser.getSurname());
        user.setEmail(updatedUser.getEmail());
        user.setUsername(updatedUser.getUsername());
        user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
