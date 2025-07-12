package com.irgendwas.PCTCD.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDTO {
    private Long id;
    private String name;
    private String desc;
    private Integer atk;
    private Integer def;
    private Integer level;
    private Integer type;
    private Integer attribute;
    private Integer race;
}