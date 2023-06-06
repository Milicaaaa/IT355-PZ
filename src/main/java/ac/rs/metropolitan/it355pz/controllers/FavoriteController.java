package ac.rs.metropolitan.it355pz.controllers;

import ac.rs.metropolitan.it355pz.entities.Favorite;
import ac.rs.metropolitan.it355pz.services.FavoriteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/favorite")
public class FavoriteController {

    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping
    public ResponseEntity<List<Favorite>> getAll() {
        return ResponseEntity.ok(favoriteService.findAll());
    }

    @GetMapping("/detail")
    public ResponseEntity<Optional<Favorite>> getByUserIdAndGameId(@RequestParam String userId, @RequestParam String gameId){
        return ResponseEntity.ok(favoriteService.findByUserIdAndGameId(userId, gameId));
    }

    @GetMapping("/user")
    public ResponseEntity<Optional<List<Favorite>>> findByUserId(@RequestParam String userId){
        return ResponseEntity.ok(favoriteService.findByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<Favorite> save(@RequestParam String userId, @RequestParam String gameId) {
        return ResponseEntity.ok(favoriteService.save(userId, gameId));
    }

    @DeleteMapping
    public void deleteByUserIdAndGameId(@RequestParam String userId, @RequestParam String gameId) {
        favoriteService.deleteByUserIdAndGameId(userId, gameId);
    }

    @DeleteMapping("/{favoriteId}")
    public void deleteById(@PathVariable Long favoriteId) {
        favoriteService.deleteById(favoriteId);
    }

}
