package com.irgendwas.PCTCD.service;

import com.irgendwas.PCTCD.dto.CardDTO;
import com.irgendwas.PCTCD.entity.CardData;
import com.irgendwas.PCTCD.entity.CardText;
import com.irgendwas.PCTCD.repository.CardDataRepository;
import com.irgendwas.PCTCD.repository.CardTextRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardDataRepository dataRepo;
    private final CardTextRepository textRepo;

    public List<CardDTO> getAllCards() {
        return dataRepo.findAll().stream().map(data -> {
            CardText text = textRepo.findById(data.getId()).orElse(null);
            return new CardDTO(
                    data.getId(),
                    text != null ? text.getName() : null,
                    text != null ? text.getDesc() : null,
                    data.getAtk(),
                    data.getDef(),
                    data.getLevel(),
                    data.getType(),
                    data.getAttribute(),
                    data.getRace()
            );
        }).collect(Collectors.toList());
    }

    public CardDTO getCardById(Long id) {
        CardData data = dataRepo.findById(id).orElse(null);
        CardText text = textRepo.findById(id).orElse(null);
        if (data == null || text == null) return null;
        return new CardDTO(
                data.getId(),
                text.getName(),
                text.getDesc(),
                data.getAtk(),
                data.getDef(),
                data.getLevel(),
                data.getType(),
                data.getAttribute(),
                data.getRace()
        );
    }
}
