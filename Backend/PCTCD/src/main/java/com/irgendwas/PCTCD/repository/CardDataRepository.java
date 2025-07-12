package com.irgendwas.PCTCD.repository;

import com.irgendwas.PCTCD.entity.CardData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardDataRepository extends JpaRepository<CardData, Long> {}