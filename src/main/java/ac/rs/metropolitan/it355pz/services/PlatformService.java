package ac.rs.metropolitan.it355pz.services;

import ac.rs.metropolitan.it355pz.entities.Game;
import ac.rs.metropolitan.it355pz.entities.IsBought;
import ac.rs.metropolitan.it355pz.entities.Platform;
import ac.rs.metropolitan.it355pz.entities.Tag;

import java.util.List;

public interface PlatformService {
    List<Platform> findAll();

    Platform save(Platform platform);

    Platform update(Platform platform);

    List<Platform> saveAll(List<Platform> platforms);

    void deleteById(Long platformId);

}
