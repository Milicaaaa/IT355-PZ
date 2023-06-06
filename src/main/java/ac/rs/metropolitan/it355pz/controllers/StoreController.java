package ac.rs.metropolitan.it355pz.controllers;

import ac.rs.metropolitan.it355pz.entities.Platform;
import ac.rs.metropolitan.it355pz.entities.Store;
import ac.rs.metropolitan.it355pz.services.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/store")
//@PreAuthorize("hasRole('ADMIN')")
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public ResponseEntity<List<Store>> getAll() {
        return ResponseEntity.ok(storeService.findAll());
    }

    @PostMapping
    public ResponseEntity<Store> save(@RequestBody Store store) {
        return ResponseEntity.ok(storeService.save(store));
    }

    @PostMapping("/insertAll")
    public ResponseEntity<List<Store>> saveAll(@RequestBody List<Store> stores) {
        return ResponseEntity.ok(storeService.saveAll(stores));
    }

    @DeleteMapping("/{storeId}")
    public void deleteById(@PathVariable Long storeId) {
        storeService.deleteById(storeId);
    }
}
