package ac.rs.metropolitan.it355pz.repositories;

import ac.rs.metropolitan.it355pz.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findAllByOrderByGameNameAsc();

    List<Game> findAllByOrderByGameNameDesc();

    List<Game> findAllByOrderByRatingAsc();

    List<Game> findAllByOrderByRatingDesc();


}
