package com.irgendwas.PCTCD.controller;

import com.irgendwas.PCTCD.dto.PersonalCardDTO;
import com.irgendwas.PCTCD.service.PersonalCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personal-cards")
@CrossOrigin
public class PersonalCardController {

    private final PersonalCardService service;

    public PersonalCardController(PersonalCardService service) {
        this.service = service;
    }

    @GetMapping
    public List<PersonalCardDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalCardDTO> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PersonalCardDTO> create(@RequestBody PersonalCardDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonalCardDTO> update(@PathVariable Long id, @RequestBody PersonalCardDTO dto) {
        dto.setId(id);
        return ResponseEntity.ok(service.create(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
