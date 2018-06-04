package de.nordakademie.flxplzk.transferleistungangular.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class RestResource {

    @Id
    @GeneratedValue
    private long id;

    protected RestResource() {
    }

    protected RestResource(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
