package ac.rs.metropolitan.it355pz.services.impl;

import ac.rs.metropolitan.it355pz.entities.Favorite;
import ac.rs.metropolitan.it355pz.entities.Game;
import ac.rs.metropolitan.it355pz.entities.User;
import ac.rs.metropolitan.it355pz.repositories.FavoriteRepository;
import ac.rs.metropolitan.it355pz.services.FavoriteService;
import ac.rs.metropolitan.it355pz.services.GameService;
import ac.rs.metropolitan.it355pz.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final UserService userService;
    private final GameService gameService;


    public FavoriteServiceImpl(FavoriteRepository favoriteRepository, UserService userService, GameService gameService) {
        this.favoriteRepository = favoriteRepository;
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public Optional<List<Favorite>> findByUserId(String userId){
        return this.favoriteRepository.findByUserId(userId);
    }

    @Override
    public Optional<Favorite> findByUserIdAndGameId(String userId, String gameId) {
        return this.favoriteRepository.findByUserIdAndGameId(userId, gameId);
    }

    @Override
    public List<Favorite> findAll() {
        return this.favoriteRepository.findAll();
    }

    @Override
    public Favorite save(String userId, String gameId) {
        Optional<User> user  = userService.findById(userId);
        Optional<Game> game = gameService.findById(gameId);
        Favorite favorite = new Favorite(user, game);
        return this.favoriteRepository.save(favorite);
    }

    @Override
    public Favorite update(Favorite updatedFavorite) {
        Favorite favorite = favoriteRepository.findById(updatedFavorite.getId()).orElseThrow(EntityNotFoundException::new);
        favorite.setGame(updatedFavorite.getGame());
        favorite.setUser(updatedFavorite.getUser());
        return favoriteRepository.save(favorite);
    }

    @Override
    public void deleteById(Long favoriteId) {
        this.favoriteRepository.deleteById(favoriteId);
    }

    @Override
    public void  deleteByUserIdAndGameId(String userId, String gameId){
        Optional<Favorite> favorite = this.favoriteRepository.findByUserIdAndGameId(userId, gameId);
        this.favoriteRepository.deleteById(favorite.get().getId());
    }
}
