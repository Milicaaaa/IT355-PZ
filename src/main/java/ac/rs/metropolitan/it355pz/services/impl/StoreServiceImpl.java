package ac.rs.metropolitan.it355pz.services.impl;

import ac.rs.metropolitan.it355pz.entities.Platform;
import ac.rs.metropolitan.it355pz.entities.Store;
import ac.rs.metropolitan.it355pz.repositories.StoreRepository;
import ac.rs.metropolitan.it355pz.services.StoreService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public List<Store> findAll() {
        return this.storeRepository.findAll();
    }

    @Override
    public Store save(Store store) {
        return this.storeRepository.save(store);
    }

    @Override
    public Store update(Store updatedStore) {
        Store store = storeRepository.findById(updatedStore.getId()).orElseThrow(EntityNotFoundException::new);

        store.setDomain(updatedStore.getDomain());
        store.setStoreName(updatedStore.getStoreName());

        return storeRepository.save(store);
    }

    @Override
    public List<Store> saveAll(List<Store> stores) {
        return this.storeRepository.saveAll(stores);
    }


    @Override
    public void deleteById(Long storeId) {
        this.storeRepository.deleteById(storeId);
    }
}
