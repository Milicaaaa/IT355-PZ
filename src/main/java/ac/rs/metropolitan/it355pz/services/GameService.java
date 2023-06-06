package ac.rs.metropolitan.it355pz.services;

import ac.rs.metropolitan.it355pz.entities.Game;

import java.util.List;
import java.util.Optional;

public interface GameService {
    List<Game> findAll();

    Optional<Game> findById(String id);
    Game save(Game game);

    Optional<List<Game>> findAllByGameNameContainingIgnoreCaseAndGameNameIgnoreCase(String name);

    Game update(Game game);

    List<Game> saveAll(List<Game> games);

    void deleteById(Long gameId);

    List<Game> findAllByOrderByGameNameAsc();

    List<Game> findAllByOrderByGameNameDesc();

    List<Game> findAllByOrderByRatingAsc();

    List<Game> findAllByOrderByRatingDesc();
}
