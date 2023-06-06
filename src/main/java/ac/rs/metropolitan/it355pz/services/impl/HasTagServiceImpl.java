package ac.rs.metropolitan.it355pz.services.impl;

import ac.rs.metropolitan.it355pz.entities.HasTag;
import ac.rs.metropolitan.it355pz.repositories.HasTagRepository;
import ac.rs.metropolitan.it355pz.services.HasTagService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HasTagServiceImpl implements HasTagService {

    private final HasTagRepository hasTagRepository;


    public HasTagServiceImpl(HasTagRepository hasTagRepository) {
        this.hasTagRepository = hasTagRepository;
    }

    @Override
    public List<HasTag> findAll() {
        return this.hasTagRepository.findAll();
    }

    @Override
    public Optional<List<HasTag>> findByGameId(String gameId) {
        return this.hasTagRepository.findByGameId(gameId);
    }

    @Override
    public HasTag save(HasTag hasTag) {
        return this.hasTagRepository.save(hasTag);
    }

    @Override
    public HasTag update(HasTag updatedHasTag) {
        HasTag hasTag = hasTagRepository.findById(updatedHasTag.getId()).orElseThrow(EntityNotFoundException::new);

        hasTag.setGame(updatedHasTag.getGame());
        hasTag.setTag(updatedHasTag.getTag());

        return hasTagRepository.save(hasTag);
    }

    @Override
    public void deleteById(Long hasTagId) {
        this.hasTagRepository.deleteById(hasTagId);
    }
}
