package ac.rs.metropolitan.it355pz.repositories;

import ac.rs.metropolitan.it355pz.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long> {

//    @Query("SELECT g FROM Game g WHERE LOWER(g.gameName) LIKE LOWER(concat('%', :searchTerm, '%'))")
//    Optional<List<Game>> findByGameNameContainingIgnoreCase(String searchTerm);

    @Query("SELECT g FROM Game g WHERE LOWER(g.gameName) LIKE CONCAT('%', :searchTerm, '%')")
    Optional<List<Game>> findByGameNameContainingIgnoreCase(String searchTerm);

    List<Game> findAllByOrderByGameNameAsc();

    List<Game> findAllByOrderByGameNameDesc();

    List<Game> findAllByOrderByRatingAsc();

    List<Game> findAllByOrderByRatingDesc();


}
