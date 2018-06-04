package de.nordakademie.flxplzk.transferleistungangular.persistence;

import de.nordakademie.flxplzk.transferleistungangular.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
