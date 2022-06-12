package com.sofkau.store.dto;

import lombok.Data;

@Data
public class BillsDTO {
    private String id;

    private String date;

    private Integer quantity;

    private String client_name;

    private String clerk;

    private String productsSold;

    private Float total_paid;
}
