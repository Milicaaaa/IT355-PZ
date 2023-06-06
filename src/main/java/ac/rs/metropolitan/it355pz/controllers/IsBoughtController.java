package ac.rs.metropolitan.it355pz.controllers;

import ac.rs.metropolitan.it355pz.entities.HasPlatform;
import ac.rs.metropolitan.it355pz.entities.IsBought;
import ac.rs.metropolitan.it355pz.services.IsBoughtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/isBought")
public class IsBoughtController {
    private final IsBoughtService isBoughtService;

    public IsBoughtController(IsBoughtService isBoughtService) {
        this.isBoughtService = isBoughtService;
    }


    @GetMapping
    public ResponseEntity<List<IsBought>> getAll() {
        return ResponseEntity.ok(isBoughtService.findAll());
    }

    @GetMapping("/game")
    public ResponseEntity<List<IsBought>> findByGameId(@RequestParam String gameId){
        return ResponseEntity.ok(isBoughtService.findByGameId(gameId));
    }

    @PostMapping
    public ResponseEntity<IsBought> save(@RequestBody IsBought isBought) {
        return ResponseEntity.ok(isBoughtService.save(isBought));
    }

    @DeleteMapping("/{isBoughtId}")
    public void deleteById(@PathVariable Long isBoughtId) {
        isBoughtService.deleteById(isBoughtId);
    }
}
