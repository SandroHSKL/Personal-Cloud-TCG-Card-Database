package com.irgendwas.PCTCD.dto;

import lombok.Data;

@Data
public class PersonalCardDTO {
    private Long id;
    private String cardId;
    private String language;
    private String setCode;
    private String rarity;
    private String cardCondition;
    private String edition;
    private String storageIndex;
    private String storageLocation;
    private String notes;
    private Long storageLocationId;
}
