package ac.rs.metropolitan.it355pz.repositories;

import ac.rs.metropolitan.it355pz.entities.HasPlatform;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HasPlatformRepository extends JpaRepository<HasPlatform, Long> {
    List<HasPlatform> findByGameId(String gameId);
}
