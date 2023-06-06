package ac.rs.metropolitan.it355pz.services.impl;

import ac.rs.metropolitan.it355pz.entities.HasGenre;
import ac.rs.metropolitan.it355pz.repositories.HasGenreRepository;
import ac.rs.metropolitan.it355pz.services.HasGenreService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HasGenreServiceImpl implements HasGenreService {

    private final HasGenreRepository hasGenreRepository;

    public HasGenreServiceImpl(HasGenreRepository hasGenreRepository) {
        this.hasGenreRepository = hasGenreRepository;
    }

    @Override
    public List<HasGenre> findAll() {
        return this.hasGenreRepository.findAll();
    }

    @Override
    public Optional<List<HasGenre>> findByGameId(String gameId) {
        return hasGenreRepository.findByGameId(gameId);
    }

    @Override
    public Optional<List<HasGenre>> findByGenreId(String genreId) {
        return  hasGenreRepository.findByGenreId(genreId);
    }

    @Override
    public HasGenre save(HasGenre hasGenre) {
        return this.hasGenreRepository.save(hasGenre);
    }

    @Override
    public HasGenre update(HasGenre updatedGenre) {
        HasGenre hasGenre = hasGenreRepository.findById(updatedGenre.getId()).orElseThrow(EntityNotFoundException::new);

        hasGenre.setGenre(updatedGenre.getGenre());
        hasGenre.setGame(updatedGenre.getGame());

        return hasGenreRepository.save(hasGenre);
    }

    @Override
    public void deleteById(Long hasGenreId) {
        this.hasGenreRepository.deleteById(hasGenreId);
    }
}
