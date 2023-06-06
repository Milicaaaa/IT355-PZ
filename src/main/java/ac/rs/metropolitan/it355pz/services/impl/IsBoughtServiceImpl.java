package ac.rs.metropolitan.it355pz.services.impl;

import ac.rs.metropolitan.it355pz.entities.IsBought;
import ac.rs.metropolitan.it355pz.repositories.IsBoughtRepository;
import ac.rs.metropolitan.it355pz.services.IsBoughtService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IsBoughtServiceImpl implements IsBoughtService {

    private final IsBoughtRepository isBoughtRepository;

    public IsBoughtServiceImpl(IsBoughtRepository isBoughtRepository) {
        this.isBoughtRepository = isBoughtRepository;
    }

    @Override
    public List<IsBought> findAll() {
        return this.isBoughtRepository.findAll();
    }

    @Override
    public IsBought save(IsBought isBought) {
        return this.isBoughtRepository.save(isBought);
    }

    @Override
    public IsBought update(IsBought updatedIsBought) {
        IsBought isBought = isBoughtRepository.findById(updatedIsBought.getId()).orElseThrow(EntityNotFoundException::new);

        isBought.setGame(updatedIsBought.getGame());
        isBought.setStore(updatedIsBought.getStore());

        return isBoughtRepository.save(isBought);
    }


    @Override
    public void deleteById(Long isBoughtId) {
        this.isBoughtRepository.deleteById(isBoughtId);
    }
}
