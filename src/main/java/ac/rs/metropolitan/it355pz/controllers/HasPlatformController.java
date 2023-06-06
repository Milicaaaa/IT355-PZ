package ac.rs.metropolitan.it355pz.controllers;

import ac.rs.metropolitan.it355pz.entities.HasPlatform;
import ac.rs.metropolitan.it355pz.entities.HasTag;
import ac.rs.metropolitan.it355pz.services.HasPlatformService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hasPlatform")
public class HasPlatformController {
    private final HasPlatformService hasPlatformService;

    public HasPlatformController(HasPlatformService hasPlatformService) {
        this.hasPlatformService = hasPlatformService;
    }

    @GetMapping
    public ResponseEntity<List<HasPlatform>> getAll() {
        return ResponseEntity.ok(hasPlatformService.findAll());
    }

    @GetMapping("/game")
    public ResponseEntity<List<HasPlatform>> findByGameId(@RequestParam String gameId){
        return ResponseEntity.ok(hasPlatformService.findByGameId(gameId));
    }

    @PostMapping
    public ResponseEntity<HasPlatform> save(@RequestBody HasPlatform hasPlatform) {
        return ResponseEntity.ok(hasPlatformService.save(hasPlatform));
    }

    @DeleteMapping("/{hasPlatformId}")
    public void deleteById(@PathVariable Long hasPlatformId) {
        hasPlatformService.deleteById(hasPlatformId);
    }
}
