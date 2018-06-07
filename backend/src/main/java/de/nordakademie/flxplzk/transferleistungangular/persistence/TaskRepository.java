package de.nordakademie.flxplzk.transferleistungangular.persistence;

import de.nordakademie.flxplzk.transferleistungangular.domain.Task;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long>,
        JpaSpecificationExecutor<Task> {
}
