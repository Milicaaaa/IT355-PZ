package ac.rs.metropolitan.it355pz.services.impl;

import ac.rs.metropolitan.it355pz.entities.Platform;
import ac.rs.metropolitan.it355pz.repositories.PlatformRepository;
import ac.rs.metropolitan.it355pz.services.PlatformService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatformServiceImpl implements PlatformService {
    private final PlatformRepository platformRepository;

    public PlatformServiceImpl(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }

    @Override
    public List<Platform> findAll() {
        return this.platformRepository.findAll();
    }

    @Override
    public Platform save(Platform platform) {
        return this.platformRepository.save(platform);
    }

    @Override
    public Platform update(Platform updatedPlatform) {
        Platform platform = platformRepository.findById(updatedPlatform.getId()).orElseThrow(EntityNotFoundException::new);

        platform.setPlatformName(platform.getPlatformName());

        return platformRepository.save(platform);
    }

    @Override
    public List<Platform> saveAll(List<Platform> platforms) {
        return this.platformRepository.saveAll(platforms);
    }

    @Override
    public void deleteById(Long platformId) {
        this.platformRepository.deleteById(platformId);
    }
}
