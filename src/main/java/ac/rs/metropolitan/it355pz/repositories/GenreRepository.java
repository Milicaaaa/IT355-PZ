package ac.rs.metropolitan.it355pz.repositories;

import ac.rs.metropolitan.it355pz.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
