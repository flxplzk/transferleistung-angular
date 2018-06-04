package de.nordakademie.flxplzk.transferleistungangular.controller;

import de.nordakademie.flxplzk.transferleistungangular.domain.RestResource;
import de.nordakademie.flxplzk.transferleistungangular.service.CrudService;

import java.io.Serializable;

public class CrudController<T extends RestResource, ID extends Serializable> {

    private final CrudService<T, ID> crudService;

    public CrudController(CrudService<T, ID> crudService) {
        this.crudService = crudService;
    }
}
