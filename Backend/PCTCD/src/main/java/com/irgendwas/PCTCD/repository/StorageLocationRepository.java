package com.irgendwas.PCTCD.repository;

import com.irgendwas.PCTCD.entity.StorageLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageLocationRepository extends JpaRepository<StorageLocation, Long> {
}
