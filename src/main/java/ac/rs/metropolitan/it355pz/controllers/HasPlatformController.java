package ac.rs.metropolitan.it355pz.controllers;

import ac.rs.metropolitan.it355pz.entities.HasPlatform;
import ac.rs.metropolitan.it355pz.services.HasPlatformService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public ResponseEntity<HasPlatform> save(@RequestBody HasPlatform hasPlatform) {
        return ResponseEntity.ok(hasPlatformService.save(hasPlatform));
    }

    @DeleteMapping("/{hasPlatformId}")
    public void deleteById(@PathVariable Long hasPlatformId) {
        hasPlatformService.deleteById(hasPlatformId);
    }
}
