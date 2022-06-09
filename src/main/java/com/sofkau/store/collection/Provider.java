package com.sofkau.store.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;


@Document(collection="provider")
public class Provider {
    //atributes
    @Id
    private String id;
    private String name;
    private String passport;
    private Integer phone;

    //constructors

    public Provider(String id, String name, String passport, Integer phone) {
        this.id = id;
        this.name = name;
        this.passport = passport;
        this.phone = phone;
    }

    public Provider() {
    }

    //getter and setters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
// to string

    @Override
    public String toString() {
        return "Provider{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", passport='" + passport + '\'' +
                ", phone=" + phone +
                '}';
    }
    //hash and equals to

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Provider provider = (Provider) o;
        return id.equals(provider.id) && name.equals(provider.name) && passport.equals(provider.passport) && phone.equals(provider.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, passport, phone);
    }
}
