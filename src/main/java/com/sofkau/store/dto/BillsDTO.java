package com.sofkau.store.dto;

import com.sofkau.store.collection.Sale;
import lombok.Data;
import java.util.List;

@Data
public class BillsDTO {
    private String id;

    private String date;

    private String client_name;

    private String clerk;

    private List<Sale> productsSold;

    private Integer total_paid;
}
