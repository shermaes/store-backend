package com.sofkau.store.collection;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Receipt {
    @Id
    private String id;

    private Provider provider;

    private String id_product;

    private String date;

    //constructor

    public Receipt(String id, Provider provider, String id_product, String date) {
        this.id = id;
        this.provider = provider;
        this.id_product = id_product;
        this.date = date;
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

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
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

    //toString

    @Override
    public String toString() {
        return "Receipts{" +
                "id='" + id + '\'' +
                ", provider=" + provider +
                ", id_product='" + id_product + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return id.equals(receipt.id) && provider.equals(receipt.provider) && id_product.equals(receipt.id_product) && date.equals(receipt.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, provider, id_product, date);
    }
}
