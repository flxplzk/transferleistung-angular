package de.nordakademie.flxplzk.transferleistungangular.endpoint;

import de.nordakademie.flxplzk.transferleistungangular.domain.Customer;
import de.nordakademie.flxplzk.transferleistungangular.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customers")
public class CustomerEndpoint extends RestEndpoint<Customer> {

    @Autowired
    public CustomerEndpoint(CrudService<Customer> crudService) {
        super(crudService);
    }
}
