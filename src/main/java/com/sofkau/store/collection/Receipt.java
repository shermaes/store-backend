package com.sofkau.store.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
@Document(collection="receipt")
public class Receipt {
    @Id
    private String id;
    private String provider;
    private String id_product;
    private String date;
    private Integer quantity;

    //constructor

    public Receipt(String id, String provider, String id_product, String date, Integer quantity) {
        this.id = id;
        this.provider = provider;
        this.id_product = id_product;
        this.date = date;
        this.quantity= quantity;
    }

    public Receipt() {
    }

    //getter and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getId_product() {
        return id_product;
    }

    public void setId_product(String id_product) {
        this.id_product = id_product;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    //toString


    @Override
    public String toString() {
        return "Receipt{" +
                "id='" + id + '\'' +
                ", provider=" + provider +
                ", id_product='" + id_product + '\'' +
                ", date='" + date + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return id.equals(receipt.id) && provider.equals(receipt.provider) && id_product.equals(receipt.id_product) && date.equals(receipt.date) && quantity.equals(receipt.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, provider, id_product, date, quantity);
    }
}
