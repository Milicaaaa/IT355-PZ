package ac.rs.metropolitan.it355pz.services;

import ac.rs.metropolitan.it355pz.entities.HasGenre;

import java.util.List;
import java.util.Optional;

public interface HasGenreService {
    List<HasGenre> findAll();
    Optional<List<HasGenre>> findByGameId(String gameId);
    Optional<List<HasGenre>> findByGenreId(String genreId);
    HasGenre save(HasGenre hasGenre);
    HasGenre update(HasGenre hasGenre);
    void deleteById(Long hasGenreId);

}
