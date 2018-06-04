package de.nordakademie.flxplzk.transferleistungangular;

import de.nordakademie.flxplzk.transferleistungangular.controller.CrudController;
import de.nordakademie.flxplzk.transferleistungangular.domain.Customer;
import de.nordakademie.flxplzk.transferleistungangular.domain.Order;
import de.nordakademie.flxplzk.transferleistungangular.domain.Product;
import de.nordakademie.flxplzk.transferleistungangular.persistence.CustomerRepository;
import de.nordakademie.flxplzk.transferleistungangular.persistence.OrderRepository;
import de.nordakademie.flxplzk.transferleistungangular.persistence.ProductsRepository;
import de.nordakademie.flxplzk.transferleistungangular.service.CrudService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfiguration {

    @Bean
    @Scope("singleton")
    public CrudService<Order, Long> orderService(final OrderRepository orderRepository) {
        return new CrudService<>(orderRepository);
    }

    @Bean
    @Scope("singleton")
    public CrudService<Product, Long> productService(final ProductsRepository productsRepository) {
        return new CrudService<>(productsRepository);
    }

    @Bean
    @Scope("singleton")
    public CrudService<Customer, Long> customerService(final CustomerRepository customerRepository) {
        return new CrudService<>(customerRepository);
    }

    @Bean
    @Scope("singleton")
    public CrudController<Order, Long> orderController(final CrudService<Order, Long> orderService) {
        return new CrudController<>(orderService);
    }

    @Bean
    @Scope("singleton")
    public CrudController<Product, Long> productController(final CrudService<Product, Long> productService) {
        return new CrudController<>(productService);
    }

    @Bean
    @Scope("singleton")
    public CrudController<Customer, Long> customerController(final CrudService<Customer, Long> customerService) {
        return new CrudController<>(customerService);
    }
}
