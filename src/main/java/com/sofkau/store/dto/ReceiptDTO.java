package com.sofkau.store.dto;

import lombok.Data;

@Data
public class ReceiptDTO {
    private String id;

    private String provider;

    private String id_product;

    private String date;

    private Integer quantity;
}
