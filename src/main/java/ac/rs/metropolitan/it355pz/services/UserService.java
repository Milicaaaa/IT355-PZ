package ac.rs.metropolitan.it355pz.services;

import ac.rs.metropolitan.it355pz.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(String id);

    User save(User user);

    void deleteById(Long userId);

    User update(User user);

    Optional<User> findByUsername(String username);

}
