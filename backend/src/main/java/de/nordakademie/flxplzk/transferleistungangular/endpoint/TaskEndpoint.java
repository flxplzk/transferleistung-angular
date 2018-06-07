package de.nordakademie.flxplzk.transferleistungangular.endpoint;

import de.nordakademie.flxplzk.transferleistungangular.domain.Task;
import de.nordakademie.flxplzk.transferleistungangular.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * simple endpoint serving crud operation on tasks.
 *
 * @author Felix Plazek
 */
@RestController
@RequestMapping(value = "/orders")
public class TaskEndpoint extends RestEndpoint<Task> {

    @Autowired
    public TaskEndpoint(CrudService<Task> crudService) {
        super(crudService);
    }
}
