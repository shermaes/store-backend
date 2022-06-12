package com.sofkau.store.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "bills")
public class Bills {
    @Id
    private String id;
    private String date;
    private String client_name;

    private Integer quantity;
    private String clerk;
    private String productsSold;
    private Float total_paid;

    //constructors

    public Bills(String id, String date, String client_name, Integer quantity, String clerk, String productsSold, Float total_paid) {
        this.id = id;
        this.date = date;
        this.client_name = client_name;
        this.quantity = quantity;
        this.clerk = clerk;
        this.productsSold = productsSold;
        this.total_paid = total_paid;
    }

    public Bills() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getClerk() {
        return clerk;
    }

    public void setClerk(String clerk) {
        this.clerk = clerk;
    }

    public String getProductsSold() {
        return productsSold;
    }

    public void setProductsSold(String productsSold) {
        this.productsSold = productsSold;
    }

    public Float getTotal_paid() {
        return total_paid;
    }

    public void setTotal_paid(Float total_paid) {
        this.total_paid = total_paid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bills bills = (Bills) o;
        return id.equals(bills.id) && date.equals(bills.date) && client_name.equals(bills.client_name) && quantity.equals(bills.quantity) && clerk.equals(bills.clerk) && Objects.equals(productsSold, bills.productsSold) && total_paid.equals(bills.total_paid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, client_name, quantity, clerk, productsSold, total_paid);
    }

    @Override
    public String toString() {
        return "Bills{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", client_name='" + client_name + '\'' +
                ", quantity=" + quantity +
                ", clerk='" + clerk + '\'' +
                ", productsSold='" + productsSold + '\'' +
                ", total_paid=" + total_paid +
                '}';
    }
}
