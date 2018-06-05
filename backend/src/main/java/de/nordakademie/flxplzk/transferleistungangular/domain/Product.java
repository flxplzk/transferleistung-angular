package de.nordakademie.flxplzk.transferleistungangular.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;

@Entity
public class Product extends RestResource {

    private String description;
    private long priceInCents;
    private boolean active;

    private Product() {
        // JPA Constructor
    }

    public Product(@JsonProperty("description") final String description,
                   @JsonProperty("priceInCents") final long priceInCents,
                   @JsonProperty("active") final boolean active) {
        this.description = description;
        this.priceInCents = priceInCents;
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
