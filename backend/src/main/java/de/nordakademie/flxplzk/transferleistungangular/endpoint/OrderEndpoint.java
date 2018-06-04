package de.nordakademie.flxplzk.transferleistungangular.endpoint;

import de.nordakademie.flxplzk.transferleistungangular.domain.Customer;
import de.nordakademie.flxplzk.transferleistungangular.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderEndpoint extends RestEndpoint<Customer> {

    @Autowired
    public OrderEndpoint(CrudService<Customer> crudService) {
        super(crudService);
    }
}
