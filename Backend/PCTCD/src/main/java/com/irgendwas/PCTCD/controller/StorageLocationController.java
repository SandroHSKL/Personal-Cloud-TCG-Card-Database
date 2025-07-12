package com.irgendwas.PCTCD.controller;

import com.irgendwas.PCTCD.dto.StorageLocationDTO;
import com.irgendwas.PCTCD.service.StorageLocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/storage-locations")
@CrossOrigin
public class StorageLocationController {

    private final StorageLocationService service;

    public StorageLocationController(StorageLocationService service) {
        this.service = service;
    }

    @GetMapping
    public List<StorageLocationDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StorageLocationDTO> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StorageLocationDTO> create(@RequestBody StorageLocationDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StorageLocationDTO> update(@PathVariable Long id, @RequestBody StorageLocationDTO dto) {
        dto.setId(id);
        return ResponseEntity.ok(service.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
