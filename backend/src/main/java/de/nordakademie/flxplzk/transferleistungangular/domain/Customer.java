package de.nordakademie.flxplzk.transferleistungangular.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Customer extends RestResource {

    private String firstName;
    private String lastName;
    @ManyToOne
    private Address address;
    private boolean active;

    private Customer() {
        // JPA constructor
    }

    public Customer(String firstName, String lastName, Address address, boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.active = active;
    }

    public Customer(long id, String firstName, String lastName, Address address, boolean active) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.active = active;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
