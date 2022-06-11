package com.sofkau.store.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "product")
public class Product {
    @Id
    private String id;

    private Provider provider;
    //embbeding a provider here

    private Integer minimum;

    private Integer maximum;

    private String name_product;

    private String description;

    private Integer units_available;

    private Float price;

    //constructors

    public Product(String id, Provider provider, Integer minimum, Integer maximum, String name_product, String description, Integer units_available, Float price) {
        this.id = id;
        this.provider = provider;
        this.minimum = minimum;
        this.maximum = maximum;
        this.name_product = name_product;
        this.description = description;
        this.units_available = units_available;
        this.price = price;
    }

    public Product() {
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

    public Integer getMinimum() {
        return minimum;
    }

    public void setMinimum(Integer minimum) {
        this.minimum = minimum;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUnits_available() {
        return units_available;
    }

    public void setUnits_available(Integer units_available) {
        this.units_available = units_available;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    //toString


    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", provider=" + provider +
                ", minimum=" + minimum +
                ", maximum=" + maximum +
                ", name_product='" + name_product + '\'' +
                ", description='" + description + '\'' +
                ", units_available=" + units_available +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id) && provider.equals(product.provider) && minimum.equals(product.minimum) && maximum.equals(product.maximum) && name_product.equals(product.name_product) && description.equals(product.description) && units_available.equals(product.units_available) && price.equals(product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, provider, minimum, maximum, name_product, description, units_available, price);
    }
}
