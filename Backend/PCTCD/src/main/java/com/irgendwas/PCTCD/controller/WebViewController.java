package com.irgendwas.PCTCD.controller;

import com.irgendwas.PCTCD.entity.PersonalCard;
import com.irgendwas.PCTCD.service.PersonalCardService;
import com.irgendwas.PCTCD.dto.PersonalCardDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebViewController {

    private final PersonalCardService service;

    public WebViewController(PersonalCardService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(Model model) {

        return "index";
    }

    @GetMapping("/cards1")
    public String showCardList(Model model) {
        var cards = service.findAll();
        model.addAttribute("cards", cards);
        return "card-list";
    }

    @GetMapping("/cards2")
    public String showCards(Model model) {
        model.addAttribute("cards",service.findAll());
        return "card-list2";
    }
}
