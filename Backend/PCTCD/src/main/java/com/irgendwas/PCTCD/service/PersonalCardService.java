package com.irgendwas.PCTCD.service;

import com.irgendwas.PCTCD.dto.PersonalCardDTO;
import com.irgendwas.PCTCD.entity.PersonalCard;
import com.irgendwas.PCTCD.repository.PersonalCardRepository;
import com.irgendwas.PCTCD.repository.StorageLocationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonalCardService {

    private final PersonalCardRepository cardRepository;
    private final StorageLocationRepository storageRepository;

    public PersonalCardService(PersonalCardRepository cardRepository, StorageLocationRepository storageRepository) {
        this.cardRepository = cardRepository;
        this.storageRepository = storageRepository;
    }

    public List<PersonalCardDTO> findAll() {
        return cardRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<PersonalCardDTO> findById(Long id) {
        return cardRepository.findById(id).map(this::toDTO);
    }

    public PersonalCardDTO create(PersonalCardDTO dto) {
        PersonalCard card = toEntity(dto);
        return toDTO(cardRepository.save(card));
    }

    public PersonalCardDTO update(Long id, PersonalCardDTO dto) {
        PersonalCard card = cardRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Card not found with id " + id));

        // Update fields
        card.setCardId(dto.getCardId());
        card.setLanguage(dto.getLanguage());
        card.setSetCode(dto.getSetCode());
        card.setRarity(dto.getRarity());
        card.setCardCondition(dto.getCardCondition());
        card.setEdition(dto.getEdition());
        card.setStorageIndex(dto.getStorageIndex());
        card.setStorageLocation(dto.getStorageLocation());
        card.setNotes(dto.getNotes());

        return toDTO(cardRepository.save(card));
    }

    public void delete(Long id) {
        cardRepository.deleteById(id);
    }

    // Mapping methods
    public PersonalCardDTO toDTO(PersonalCard c) {
        PersonalCardDTO dto = new PersonalCardDTO();
        dto.setId(c.getId());
        dto.setCardId(c.getCardId());
        dto.setLanguage(c.getLanguage());
        dto.setSetCode(c.getSetCode());
        dto.setRarity(c.getRarity());
        dto.setCardCondition(c.getCardCondition());
        dto.setEdition(c.getEdition());
        dto.setStorageIndex(c.getStorageIndex());
        dto.setStorageLocation(c.getStorageLocation());
        dto.setNotes(c.getNotes());
        return dto;
    }

    public PersonalCard toEntity(PersonalCardDTO dto) {
        PersonalCard c = new PersonalCard();
        c.setId(dto.getId());
        c.setCardId(dto.getCardId());
        c.setLanguage(dto.getLanguage());
        c.setSetCode(dto.getSetCode());
        c.setRarity(dto.getRarity());
        c.setCardCondition(dto.getCardCondition());
        c.setEdition(dto.getEdition());
        c.setStorageIndex(dto.getStorageIndex());
        c.setStorageLocation(dto.getStorageLocation());
        c.setNotes(dto.getNotes());
        return c;
    }
}
