package com.sofkau.store.dto;

import lombok.Data;

@Data
public class ProductDTO {

    private String id;

    private String provider;

    private Integer minimum;

    private Integer maximum;

    private String name_product;

    private String description;

    private Integer units_available;

    private Float price;
}
