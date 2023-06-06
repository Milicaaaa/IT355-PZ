package ac.rs.metropolitan.it355pz.services.impl;

import ac.rs.metropolitan.it355pz.entities.Game;
import ac.rs.metropolitan.it355pz.entities.Genre;
import ac.rs.metropolitan.it355pz.repositories.GenreRepository;
import ac.rs.metropolitan.it355pz.services.GenreService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> findAll() {
        return this.genreRepository.findAll();
    }

    @Override
    public Genre save(Genre genre) {
        return this.genreRepository.save(genre);
    }

    @Override
    public Genre update(Genre updatedGenre) {
        Genre genre = genreRepository.findById(updatedGenre.getId()).orElseThrow(EntityNotFoundException::new);

        genre.setGenreName(updatedGenre.getGenreName());
        genre.setSlug(updatedGenre.getSlug());
        genre.setDescription(updatedGenre.getDescription());

        return genreRepository.save(genre);
    }

    @Override
    public List<Genre> saveAll(List<Genre> genres) {
        return this.genreRepository.saveAllAndFlush(genres);
    }


    @Override
    public void deleteById(Long genreId) {
        this.genreRepository.deleteById(genreId);
    }
}
