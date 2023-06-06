package ac.rs.metropolitan.it355pz.services;

import ac.rs.metropolitan.it355pz.entities.Platform;
import ac.rs.metropolitan.it355pz.entities.Store;
import ac.rs.metropolitan.it355pz.entities.Tag;

import java.util.List;

public interface StoreService {
    List<Store> findAll();

    Store save(Store store);

    Store update(Store store);

    List<Store> saveAll(List<Store> stores);

    void deleteById(Long storeId);

}
