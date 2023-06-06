package ac.rs.metropolitan.it355pz.repositories;

import ac.rs.metropolitan.it355pz.entities.HasPlatform;
import ac.rs.metropolitan.it355pz.entities.IsBought;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IsBoughtRepository extends JpaRepository<IsBought, Long> {

    List<IsBought> findByGameId(String gameId);
}
