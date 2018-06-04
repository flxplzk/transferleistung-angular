package de.nordakademie.flxplzk.transferleistungangular.endpoint;

import de.nordakademie.flxplzk.transferleistungangular.domain.RestResource;
import de.nordakademie.flxplzk.transferleistungangular.service.CrudService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class RestEndpoint<T extends RestResource> {

    private final CrudService<T> crudService;

    public RestEndpoint(CrudService<T> crudService) {
        this.crudService = crudService;
    }

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public T save(@RequestBody final T model) {
        return this.crudService.save(model);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public T update(@PathVariable(name = "id") final long id,
                    @RequestBody final T model) {
        model.setId(id);
        return this.crudService.save(model);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE)
    public void delete(@PathVariable(name = "id") final Long id) {
        this.crudService.delete(id);
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<T> findAll() {
        return this.crudService.findAll();
    }

    @RequestMapping(value = "/active",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<T> findAllActive() {
        return this.crudService.findAllActive();
    }
}
