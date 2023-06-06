package ac.rs.metropolitan.it355pz.controllers;

import ac.rs.metropolitan.it355pz.entities.Game;
import ac.rs.metropolitan.it355pz.entities.Genre;
import ac.rs.metropolitan.it355pz.services.GenreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genre")
@CrossOrigin("*")
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public ResponseEntity<List<Genre>> getAll() {
        return ResponseEntity.ok(genreService.findAll());
    }

    @PostMapping
    public ResponseEntity<Genre> save(@RequestBody Genre genre) {
        return ResponseEntity.ok(genreService.save(genre));
    }

    @PostMapping("/insertAll")
    public ResponseEntity<List<Genre>> saveAll(@RequestBody List<Genre> genres) {
        return ResponseEntity.ok(genreService.saveAll(genres));
    }

    @DeleteMapping("/{genreId}")
    public void deleteById(@PathVariable Long genreId) {
        genreService.deleteById(genreId);
    }
}
