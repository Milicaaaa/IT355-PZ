package ac.rs.metropolitan.it355pz.services;

import ac.rs.metropolitan.it355pz.entities.HasTag;
import ac.rs.metropolitan.it355pz.entities.IsBought;
import ac.rs.metropolitan.it355pz.entities.Tag;

import java.util.List;

public interface IsBoughtService {
    List<IsBought> findAll();

    IsBought save(IsBought isBought);

    IsBought update(IsBought isBought);

    void deleteById(Long isBoughtId);

}
