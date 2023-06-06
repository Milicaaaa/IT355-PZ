package ac.rs.metropolitan.it355pz.controllers;

import ac.rs.metropolitan.it355pz.entities.Game;
import ac.rs.metropolitan.it355pz.entities.Platform;
import ac.rs.metropolitan.it355pz.services.PlatformService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/platform")
@CrossOrigin
public class PlatformController {
    private final PlatformService platformService;

    public PlatformController(PlatformService platformService) {
        this.platformService = platformService;
    }

    @GetMapping
    public ResponseEntity<List<Platform>> getAll() {
        return ResponseEntity.ok(platformService.findAll());
    }

    @PostMapping
    public ResponseEntity<Platform> save(@RequestBody Platform platform) {
        return ResponseEntity.ok(platformService.save(platform));
    }

    @PostMapping("/insertAll")
    public ResponseEntity<List<Platform>> saveAll(@RequestBody List<Platform> platforms) {
        return ResponseEntity.ok(platformService.saveAll(platforms));
    }

    @DeleteMapping("/{platformId}")
    public void deleteById(@PathVariable Long platformId) {
        platformService.deleteById(platformId);
    }
}
