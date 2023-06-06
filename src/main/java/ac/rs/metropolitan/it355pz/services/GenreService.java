package ac.rs.metropolitan.it355pz.services;

import ac.rs.metropolitan.it355pz.entities.Game;
import ac.rs.metropolitan.it355pz.entities.Genre;
import ac.rs.metropolitan.it355pz.entities.Tag;

import java.util.List;

public interface GenreService {
    List<Genre> findAll();

    Genre save(Genre genre);

    Genre update(Genre genre);

    List<Genre> saveAll(List<Genre> genres);


    void deleteById(Long genreId);
}
