package de.nordakademie.flxplzk.transferleistungangular.Configuration;

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
    public CrudService<Order> orderService(final OrderRepository orderRepository) {
        return new CrudService<>(orderRepository);
    }

    @Bean
    @Scope("singleton")
    public CrudService<Product> productService(final ProductsRepository productsRepository) {
        productsRepository.save(new Product("works", 100, true));
        return new CrudService<>(productsRepository);
    }

    @Bean
    @Scope("singleton")
    public CrudService<Customer> customerService(final CustomerRepository customerRepository) {
        return new CrudService<>(customerRepository);
    }

}
