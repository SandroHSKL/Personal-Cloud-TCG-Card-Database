package com.irgendwas.PCTCD.service;

import com.irgendwas.PCTCD.dto.StorageLocationDTO;
import com.irgendwas.PCTCD.entity.StorageLocation;
import com.irgendwas.PCTCD.repository.StorageLocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StorageLocationService {

    private final StorageLocationRepository repository;

    public StorageLocationService(StorageLocationRepository repository) {
        this.repository = repository;
    }

    public List<StorageLocationDTO> findAll() {
        return repository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public Optional<StorageLocationDTO> findById(Long id) {
        return repository.findById(id).map(this::mapToDTO);
    }

    public StorageLocationDTO save(StorageLocationDTO dto) {
        StorageLocation entity = mapToEntity(dto);
        return mapToDTO(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    // Mapping
    private StorageLocationDTO mapToDTO(StorageLocation entity) {
        StorageLocationDTO dto = new StorageLocationDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setStorageType(entity.getStorageType());
        dto.setNotes(entity.getNotes());
        return dto;
    }

    private StorageLocation mapToEntity(StorageLocationDTO dto) {
        StorageLocation entity = new StorageLocation();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setStorageType(dto.getStorageType());
        entity.setNotes(dto.getNotes());
        return entity;
    }
}
