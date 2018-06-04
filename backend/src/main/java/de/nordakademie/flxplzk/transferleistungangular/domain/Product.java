package de.nordakademie.flxplzk.transferleistungangular.domain;

import javax.persistence.Entity;

@Entity
public class Product extends RestResource{

    private String name;
    private long priceInCents;
    private boolean active;

    private Product() {
        // JPA Constructor
    }

    public Product(String name, long priceInCents, boolean active) {
        this.name = name;
        this.priceInCents = priceInCents;
        this.active = active;
    }

    public Product(long id, String name, long priceInCents, boolean active) {
        super(id);
        this.name = name;
        this.priceInCents = priceInCents;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPriceInCents() {
        return priceInCents;
    }

    public void setPriceInCents(long priceInCents) {
        this.priceInCents = priceInCents;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
