package ac.rs.metropolitan.it355pz.repositories;

import ac.rs.metropolitan.it355pz.entities.HasGenre;
import ac.rs.metropolitan.it355pz.entities.HasTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HasGenreRepository extends JpaRepository<HasGenre, Long> {

    Optional<List<HasGenre>> findByGameId(String gameId);

    Optional<List<HasGenre>> findByGenreId(String genreId);
}
