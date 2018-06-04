package de.nordakademie.flxplzk.transferleistungangular.persistence;

import de.nordakademie.flxplzk.transferleistungangular.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductsRepository extends CrudRepository<Product, Long> {
}
