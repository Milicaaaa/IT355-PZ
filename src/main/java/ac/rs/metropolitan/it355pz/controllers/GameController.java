package ac.rs.metropolitan.it355pz.controllers;

import ac.rs.metropolitan.it355pz.entities.Game;
import ac.rs.metropolitan.it355pz.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/game")
@CrossOrigin("*")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<List<Game>> getAll() {
        return ResponseEntity.ok(gameService.findAll());
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<Optional<Game>> getById(@PathVariable String gameId) {
        return ResponseEntity.ok(gameService.findById(gameId));
    }

    @GetMapping("/nameAsc")
    public ResponseEntity<List<Game>> sortByNameAsc() {
        return ResponseEntity.ok(gameService.findAllByOrderByGameNameAsc());
    }

    @GetMapping("/nameDesc")
    public ResponseEntity<List<Game>> sortByNameDesc() {
        return ResponseEntity.ok(gameService.findAllByOrderByGameNameDesc());
    }

    @GetMapping("/ratingAsc")
    public ResponseEntity<List<Game>> sortByRatingAsc() {
        return ResponseEntity.ok(gameService.findAllByOrderByRatingAsc());
    }

    @GetMapping("/ratingDesc")
    public ResponseEntity<List<Game>> sortByRatingDesc() {
        return ResponseEntity.ok(gameService.findAllByOrderByRatingDesc());
    }

    @PostMapping
    public ResponseEntity<Game> save(@RequestBody Game game) {
        return ResponseEntity.ok(gameService.save(game));
    }

    @PostMapping("/insertAll")
    public ResponseEntity<List<Game>> saveAll(@RequestBody List<Game> games) {
        return ResponseEntity.ok(gameService.saveAll(games));
    }

    @DeleteMapping("/{gameId}")
    public void deleteById(@PathVariable Long gameId) {
        gameService.deleteById(gameId);
    }

}
