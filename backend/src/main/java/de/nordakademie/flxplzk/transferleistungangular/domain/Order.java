package de.nordakademie.flxplzk.transferleistungangular.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Order extends RestResource {

    @ManyToOne
    private Customer customer;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Product> products;
    private LocalDate orderDate;
    private boolean active;

    private Order() {
        // JPA constructor
    }

    public Order(@JsonProperty("customer") Customer customer,
                 @JsonProperty("products") List<Product> products,
                 @JsonProperty("orderDate") LocalDate orderDate,
                 @JsonProperty("active") boolean active) {
        this.customer = customer;
        this.products = products;
        this.orderDate = orderDate;
        this.active = active;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}