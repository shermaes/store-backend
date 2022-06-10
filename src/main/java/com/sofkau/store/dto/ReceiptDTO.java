package com.sofkau.store.dto;

import com.sofkau.store.collection.Provider;
import lombok.Data;

@Data
public class ReceiptDTO {
    private String id;

    private Provider provider;

    private String id_product;

    private String date;

    private Integer quantity;
}
