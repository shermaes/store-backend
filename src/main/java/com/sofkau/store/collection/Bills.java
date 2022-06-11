package com.sofkau.store.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document(collection = "bills")
public class Bills {
    @Id
    private String id;
    private String date;
    private String client_name;
    private String clerk;
    private List<Sale> productsSold;
    private Integer total_paid;

    //constructors

    public Bills(String id, String date, String client_name, String clerk, List<Sale> productsSold, Integer total_paid) {
        this.id = id;
        this.date = date;
        this.client_name = client_name;
        this.clerk = clerk;
        this.productsSold = productsSold;
        this.total_paid = total_paid;
    }

    public Bills() {
    }
    //getter and setters

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

    public String getClerk() {
        return clerk;
    }

    public void setClerk(String clerk) {
        this.clerk = clerk;
    }

    public List<Sale> getProductsSold() {
        return productsSold;
    }

    public void setProductsSold(List<Sale> productList) {
        this.productsSold = productList;
    }

    public Integer getTotal_paid() {
        return total_paid;
    }

    public void setTotal_paid(Integer total_paid) {
        this.total_paid = total_paid;
    }

    //toString


    @Override
    public String toString() {
        return "Bills{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", client_name='" + client_name + '\'' +
                ", clerk='" + clerk + '\'' +
                ", productsSold=" + productsSold +
                ", total_paid=" + total_paid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bills bills = (Bills) o;
        return id.equals(bills.id) && date.equals(bills.date) && client_name.equals(bills.client_name) && clerk.equals(bills.clerk) && productsSold.equals(bills.productsSold) && total_paid.equals(bills.total_paid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, client_name, clerk, productsSold, total_paid);
    }
}
