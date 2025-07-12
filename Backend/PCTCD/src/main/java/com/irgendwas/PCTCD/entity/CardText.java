package com.irgendwas.PCTCD.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "texts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardText {
    @Id
    private Long id;
    private String name;
    private String desc;
    private String str1;
    private String str2;
    private String str3;
    private String str4;
    private String str5;
    private String str6;
    private String str7;
    private String str8;
    private String str9;
    private String str10;
    private String str11;
    private String str12;
    private String str13;
    private String str14;
    private String str15;
    private String str16;
}