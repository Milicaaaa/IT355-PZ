package ac.rs.metropolitan.it355pz.services;

import ac.rs.metropolitan.it355pz.entities.HasPlatform;
import ac.rs.metropolitan.it355pz.entities.Tag;

import java.util.List;

public interface HasPlatformService {
    List<HasPlatform> findAll();

    HasPlatform save(HasPlatform hasPlatform);

    HasPlatform update(HasPlatform hasPlatform);

    void deleteById(Long hasPlatformId);

}
