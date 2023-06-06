package ac.rs.metropolitan.it355pz.repositories;

import ac.rs.metropolitan.it355pz.entities.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    Optional<List<Favorite>> findByUserId(String userId);

    Optional<Favorite> findByUserIdAndGameId(String userId, String gameId);
}
