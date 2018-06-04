package de.nordakademie.flxplzk.transferleistungangular.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private long id;
    private String street;
    private int number;
    private int postCode;
    private String city;

    private Address() {
    }

    public Address(String street, int number, int postCode, String city) {
        this.street = street;
        this.number = number;
        this.postCode = postCode;
        this.city = city;
    }

    public Address(long id, String street, int number, int postCode, String city) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.postCode = postCode;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
