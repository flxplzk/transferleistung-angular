package de.nordakademie.flxplzk.transferleistungangular.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Customer extends RestResource {

    private String firstName;
    private String lastName;
    @ManyToOne
    private Address address;

    private Customer() {
        // JPA constructor
    }

    public Customer(@JsonProperty("firstName") final String firstName,
                    @JsonProperty("lastName") final String lastName, Address address,
                    @JsonProperty("active") final boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
