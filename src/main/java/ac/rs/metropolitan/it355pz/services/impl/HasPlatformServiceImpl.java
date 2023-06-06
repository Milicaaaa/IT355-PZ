package ac.rs.metropolitan.it355pz.services.impl;

import ac.rs.metropolitan.it355pz.entities.HasPlatform;
import ac.rs.metropolitan.it355pz.repositories.HasPlatformRepository;
import ac.rs.metropolitan.it355pz.services.HasPlatformService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HasPlatformServiceImpl implements HasPlatformService {

    private final HasPlatformRepository hasPlatformRepository;

    public HasPlatformServiceImpl(HasPlatformRepository hasPlatformRepository) {
        this.hasPlatformRepository = hasPlatformRepository;
    }

    @Override
    public List<HasPlatform> findAll() {
        return this.hasPlatformRepository.findAll();
    }

    @Override
    public HasPlatform save(HasPlatform hasPlatform) {
        return this.hasPlatformRepository.save(hasPlatform);
    }

    @Override
    public HasPlatform update(HasPlatform updatedHasPlatform) {
        HasPlatform hasPlatform = hasPlatformRepository.findById(updatedHasPlatform.getId()).orElseThrow(EntityNotFoundException::new);

        hasPlatform.setGame(updatedHasPlatform.getGame());
        hasPlatform.setPlatform(updatedHasPlatform.getPlatform());

        return hasPlatformRepository.save(hasPlatform);
    }


    @Override
    public void deleteById(Long hasPlatformId) {
        this.hasPlatformRepository.deleteById(hasPlatformId);
    }
}
