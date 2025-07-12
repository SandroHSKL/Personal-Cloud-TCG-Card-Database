package com.irgendwas.PCTCD.dto;

import lombok.Data;

@Data
public class StorageLocationDTO {
    private Long id;
    private String name;
    private String storageType;
    private String notes;
}
