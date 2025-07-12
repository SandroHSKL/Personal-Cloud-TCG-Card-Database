package com.irgendwas.PCTCD.controller;

import com.irgendwas.PCTCD.dto.CardDTO;
import com.irgendwas.PCTCD.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping
    public List<CardDTO> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/{id}")
    public CardDTO getCardById(@PathVariable Long id) {
        return cardService.getCardById(id);
    }
}
