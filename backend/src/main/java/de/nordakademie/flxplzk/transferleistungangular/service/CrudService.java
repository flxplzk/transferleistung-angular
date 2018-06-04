package de.nordakademie.flxplzk.transferleistungangular.service;

import de.nordakademie.flxplzk.transferleistungangular.domain.RestResource;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public class CrudService<T extends RestResource, ID extends Serializable> {

    private final CrudRepository<T, ID> crudRepository;

    public CrudService(CrudRepository<T, ID> crudRepository) {
        this.crudRepository = crudRepository;
    }
}
