package com.irgendwas.PCTCD.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "personal_card", schema = "yugioh-personalcard-db")
public class PersonalCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "card_id", nullable = false, length = 50)
    private String cardId;

    @Column(name = "language", nullable = false, length = 50)
    private String language;

    @Column(name = "set_code", nullable = false, length = 10)
    private String setCode;

    @Column(name = "rarity", nullable = false, length = 50)
    private String rarity;

    @Column(name = "card_condition", nullable = false, length = 50)
    private String cardCondition;

    @Column(name = "edition", nullable = false, length = 1)
    private String edition;

    @Column(name = "storage_location", nullable = false, length = 50)
    private String storageLocation;

    @Column(name = "storage_index")
    private String storageIndex;

    @Lob
    @Column(name = "notes")
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storage_location_id")
    private StorageLocation storageLocation1;

}