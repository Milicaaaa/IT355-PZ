package ac.rs.metropolitan.it355pz.services;

import ac.rs.metropolitan.it355pz.entities.Store;
import ac.rs.metropolitan.it355pz.entities.Tag;

import java.util.List;

public interface TagService {

    List<Tag> findAll();
    Tag save(Tag tag);

    Tag update(Tag tag);

    List<Tag> saveAll(List<Tag> tags);


    void deleteById(Long tagId);

}
