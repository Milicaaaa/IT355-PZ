package ac.rs.metropolitan.it355pz.services;

import ac.rs.metropolitan.it355pz.entities.Favorite;
import ac.rs.metropolitan.it355pz.entities.Tag;

import java.util.List;
import java.util.Optional;

public interface FavoriteService {
    List<Favorite> findAll();
    Optional<List<Favorite>> findByUserId(String userId);
    Optional<Favorite> findByUserIdAndGameId(String userId, String gameId);
    Favorite save(String userId, String gameId);
    Favorite update(Favorite favorite);

    void deleteById(Long favoriteId);

    void  deleteByUserIdAndGameId(String userId, String gameId);

}
