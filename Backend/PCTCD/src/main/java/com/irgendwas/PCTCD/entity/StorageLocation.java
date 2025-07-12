package com.irgendwas.PCTCD.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "storage_location", schema = "yugioh-personalcard-db")
public class StorageLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "storage_type", nullable = false)
    private String storageType;

    @Lob
    @Column(name = "notes")
    private String notes;

    @OneToMany(mappedBy = "storageLocation")
    private Set<PersonalCard> personalCards = new LinkedHashSet<>();

}