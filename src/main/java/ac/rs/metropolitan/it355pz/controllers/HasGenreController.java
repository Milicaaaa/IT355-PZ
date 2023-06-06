package ac.rs.metropolitan.it355pz.controllers;

import ac.rs.metropolitan.it355pz.entities.HasGenre;
import ac.rs.metropolitan.it355pz.entities.HasTag;
import ac.rs.metropolitan.it355pz.services.HasGenreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hasGenre")
public class HasGenreController {
    private final HasGenreService hasGenreService;

    public HasGenreController(HasGenreService hasGenreService) {
        this.hasGenreService = hasGenreService;
    }

    @GetMapping
    public ResponseEntity<List<HasGenre>> getAll() {
        return ResponseEntity.ok(hasGenreService.findAll());
    }

    @GetMapping("/game")
    public ResponseEntity<Optional<List<HasGenre>>> findByGameId(@RequestParam String gameId){
        return ResponseEntity.ok(hasGenreService.findByGameId(gameId));
    }

    @GetMapping("/genre")
    public ResponseEntity<Optional<List<HasGenre>>> findByGenreId(@RequestParam String genreId){
        return ResponseEntity.ok(hasGenreService.findByGenreId(genreId));
    }

    @PostMapping
    public ResponseEntity<HasGenre> save(@RequestBody HasGenre hasGenre) {
        return ResponseEntity.ok(hasGenreService.save(hasGenre));
    }

    @DeleteMapping("/{hasGenreId}")
    public void deleteById(@PathVariable Long hasGenreId) {
        hasGenreService.deleteById(hasGenreId);
    }
}
