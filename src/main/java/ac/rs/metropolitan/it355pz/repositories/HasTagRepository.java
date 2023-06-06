package ac.rs.metropolitan.it355pz.repositories;

import ac.rs.metropolitan.it355pz.entities.HasTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HasTagRepository extends JpaRepository<HasTag, Long> {

    Optional<List<HasTag>> findByGameId(String gameId);
}
