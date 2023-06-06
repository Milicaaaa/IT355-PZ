package ac.rs.metropolitan.it355pz.controllers;

import ac.rs.metropolitan.it355pz.entities.Favorite;
import ac.rs.metropolitan.it355pz.entities.HasTag;
import ac.rs.metropolitan.it355pz.services.HasTagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hasTag")
public class HasTagController {
    private final HasTagService hasTagService;

    public HasTagController(HasTagService hasTagService) {
        this.hasTagService = hasTagService;
    }

    @GetMapping
    public ResponseEntity<List<HasTag>> getAll() {
        return ResponseEntity.ok(hasTagService.findAll());
    }

    @PostMapping
    public ResponseEntity<HasTag> save(@RequestBody HasTag hasTag) {
        return ResponseEntity.ok(hasTagService.save(hasTag));
    }

    @GetMapping("/game")
    public ResponseEntity<Optional<List<HasTag>>> findByGameId(@RequestParam String gameId){
        return ResponseEntity.ok(hasTagService.findByGameId(gameId));
    }

    @DeleteMapping("/{hasTagId}")
    public void deleteById(@PathVariable Long hasTagId) {
        hasTagService.deleteById(hasTagId);
    }
}
