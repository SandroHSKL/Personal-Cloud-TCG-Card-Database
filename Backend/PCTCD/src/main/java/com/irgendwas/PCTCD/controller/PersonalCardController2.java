package com.irgendwas.PCTCD.controller;

import com.irgendwas.PCTCD.entity.PersonalCard;
import com.irgendwas.PCTCD.service.PersonalCardService;
import com.irgendwas.PCTCD.dto.PersonalCardDTO;
import com.irgendwas.PCTCD.service.StorageLocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cards")
public class PersonalCardController2 {

    private final PersonalCardService cardService;
    private final StorageLocationService locationService;

    public PersonalCardController2(PersonalCardService cardService, StorageLocationService locationService) {
        this.cardService = cardService;
        this.locationService = locationService;
    }

    // Show all cards
    @GetMapping
    public String list(Model model) {
        model.addAttribute("cards", cardService.findAll());
        return "card-list";
    }

    // Show form to create a new card
    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("card", new PersonalCard());
        return "new";
    }

    // Save new card
    @PostMapping
    public String create(@ModelAttribute("card") PersonalCard card) {
        cardService.create(cardService.toDTO(card));
        return "redirect:/cards";
    }

    // Show edit form
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        PersonalCardDTO dto = cardService.findById(id).orElseThrow(() -> new RuntimeException("Card not found"));
        PersonalCard card = cardService.toEntity(dto);
        model.addAttribute("card", card);
        return "edit";
    }

    // Update card
    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("card") PersonalCard card) {
        card.setId(id);
        cardService.update(id,cardService.toDTO(card));
        return "redirect:/cards";
    }

    // Delete card
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        cardService.delete(id);
        return "redirect:/cards";
    }
}
