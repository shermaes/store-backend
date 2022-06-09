package com.sofkau.store.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;
@Document(collection="bills")
public class Bills {
    @Id
    private String id;
    private String date;
    private String client_name;
    private String clerk;
    private List<Product> productList;
    private Integer total_paid;

    //constructors

    public Bills(String id, String date, String client_name, String clerk, List<Product> productList, Integer total_paid) {
        this.id = id;
        this.date = date;
        this.client_name = client_name;
        this.clerk = clerk;
        this.productList = productList;
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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
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
                ", productList=" + productList +
                ", total_paid=" + total_paid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bills bills = (Bills) o;
        return id.equals(bills.id) && date.equals(bills.date) && client_name.equals(bills.client_name) && clerk.equals(bills.clerk) && productList.equals(bills.productList) && total_paid.equals(bills.total_paid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, client_name, clerk, productList, total_paid);
    }
}
