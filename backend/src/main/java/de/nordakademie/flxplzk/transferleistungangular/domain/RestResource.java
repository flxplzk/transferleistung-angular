package de.nordakademie.flxplzk.transferleistungangular.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class RestResource {

    @Id
    @GeneratedValue
    private long id;
    private boolean active;

    protected RestResource() {
    }

    protected RestResource(long id) {
        this.id = id;
    }

    protected RestResource(long id, boolean active) {
        this(id);
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
