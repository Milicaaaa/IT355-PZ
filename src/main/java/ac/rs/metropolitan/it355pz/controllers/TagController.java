package ac.rs.metropolitan.it355pz.controllers;

import ac.rs.metropolitan.it355pz.entities.Store;
import ac.rs.metropolitan.it355pz.entities.Tag;
import ac.rs.metropolitan.it355pz.services.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tag")
public class TagController {
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public ResponseEntity<List<Tag>> getAll() {
        return ResponseEntity.ok(tagService.findAll());
    }

    @PostMapping
    public ResponseEntity<Tag> save(@RequestBody Tag tag) {
        return ResponseEntity.ok(tagService.save(tag));
    }

    @PutMapping
    public ResponseEntity<Tag> update(@RequestBody Tag tag) {
        return ResponseEntity.ok(tagService.update(tag));
    }

    @PostMapping("/insertAll")
    public ResponseEntity<List<Tag>> saveAll(@RequestBody List<Tag> tags) {
        return ResponseEntity.ok(tagService.saveAll(tags));
    }

    @DeleteMapping("/{tagId}")
    public void deleteById(@PathVariable Long tagId) {
        tagService.deleteById(tagId);
    }
}
