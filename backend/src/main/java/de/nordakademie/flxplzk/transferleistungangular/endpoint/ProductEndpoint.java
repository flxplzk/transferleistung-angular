package de.nordakademie.flxplzk.transferleistungangular.endpoint;

import de.nordakademie.flxplzk.transferleistungangular.domain.Product;
import de.nordakademie.flxplzk.transferleistungangular.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductEndpoint extends RestEndpoint<Product> {

    @Autowired
    public ProductEndpoint(CrudService<Product> crudService) {
        super(crudService);
    }
}
