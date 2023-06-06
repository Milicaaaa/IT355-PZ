package ac.rs.metropolitan.it355pz.services;

import ac.rs.metropolitan.it355pz.entities.HasPlatform;
import ac.rs.metropolitan.it355pz.entities.HasTag;
import ac.rs.metropolitan.it355pz.entities.Tag;

import java.util.List;
import java.util.Optional;

public interface HasTagService {
    List<HasTag> findAll();

    Optional<List<HasTag>> findByGameId(String gameId);

    HasTag save(HasTag hasTag);

    HasTag update(HasTag hasTag);

    void deleteById(Long hasTagId);

}
