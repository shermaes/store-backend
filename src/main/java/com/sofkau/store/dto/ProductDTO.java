package com.sofkau.store.dto;

import com.sofkau.store.collection.Provider;
import lombok.Data;

@Data
public class ProductDTO {

    private String id;

    private Provider provider;

    private Integer minimum;

    private Integer maximum;

    private String name_product;

    private String description;

    private Integer units_available;

    private Float price;
}
