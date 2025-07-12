package com.irgendwas.PCTCD.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "datas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardData {
    @Id
    private Long id;
    private Integer ot;
    private Integer alias;
    private Integer setcode;
    private Integer type;
    private Integer atk;
    private Integer def;
    private Integer level;
    private Integer race;
    private Integer attribute;
    private Integer category;
}