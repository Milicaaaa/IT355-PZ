package ac.rs.metropolitan.it355pz.services.impl;

import ac.rs.metropolitan.it355pz.entities.Game;
import ac.rs.metropolitan.it355pz.repositories.GameRepository;
import ac.rs.metropolitan.it355pz.services.GameService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<Game> findAll() {
        return this.gameRepository.findAll();
    }

    @Override
    public Optional<Game> findById(String id) {
        return this.gameRepository.findById(Long.valueOf(id));
    }

    @Override
    public Game save(Game game) {
        return this.gameRepository.save(game);
    }

    @Override
    public Optional<List<Game>> findAllByGameNameContainingIgnoreCaseAndGameNameIgnoreCase(String name) {
        return gameRepository.findByGameNameContainingIgnoreCase(name);
    }

    @Override
    public Game update(Game updatedGame) {
        Game game = gameRepository.findById(updatedGame.getId()).orElseThrow(EntityNotFoundException::new);

        game.setGameName(updatedGame.getGameName());
        game.setBackgroundImage(updatedGame.getBackgroundImage());
        game.setRating(updatedGame.getRating());
        game.setDescriptionRaw(updatedGame.getDescriptionRaw());
        game.setReviewCount(updatedGame.getReviewCount());
        game.setSuggestionCount(updatedGame.getSuggestionCount());

        return gameRepository.save(game);
    }

    @Override
    public List<Game> saveAll(List<Game> games) {
        return this.gameRepository.saveAllAndFlush(games);
    }


    @Override
    public void deleteById(Long gameId) {
        this.gameRepository.deleteById(gameId);
    }

    @Override
    public List<Game> findAllByOrderByGameNameAsc() {
        return this.gameRepository.findAllByOrderByGameNameAsc();
    }

    @Override
    public List<Game> findAllByOrderByGameNameDesc() {
        return this.gameRepository.findAllByOrderByGameNameDesc();
    }

    @Override
    public List<Game> findAllByOrderByRatingAsc() {
        return this.gameRepository.findAllByOrderByRatingAsc();
    }

    @Override
    public List<Game> findAllByOrderByRatingDesc() {
        return this.gameRepository.findAllByOrderByRatingDesc();
    }


}
