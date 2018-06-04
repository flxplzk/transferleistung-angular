package de.nordakademie.flxplzk.transferleistungangular.persistence;

import de.nordakademie.flxplzk.transferleistungangular.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
