package ac.rs.metropolitan.it355pz.services.impl;

import ac.rs.metropolitan.it355pz.entities.Tag;
import ac.rs.metropolitan.it355pz.repositories.TagRepository;
import ac.rs.metropolitan.it355pz.services.TagService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag update(Tag updatedTag) {
        Tag tag = tagRepository.findById(updatedTag.getId()).orElseThrow(EntityNotFoundException::new);
        tag.setTagName(updatedTag.getTagName());
        tag.setTagLanguage(updatedTag.getTagLanguage());
        return tagRepository.save(tag);
    }

    @Override
    public List<Tag> saveAll(List<Tag> tags) {
        return tagRepository.saveAll(tags);
    }

    @Override
    public void deleteById(Long tagId) {
        tagRepository.deleteById(tagId);
    }
}
