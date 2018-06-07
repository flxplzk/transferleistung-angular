package de.nordakademie.flxplzk.transferleistungangular.configuration;

import de.nordakademie.flxplzk.transferleistungangular.domain.Task;
import de.nordakademie.flxplzk.transferleistungangular.persistence.TaskRepository;
import de.nordakademie.flxplzk.transferleistungangular.service.CrudService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * configuration class for configuring beans.
 *
 * @author Felix Plazek
 */
@Configuration
public class SpringConfiguration {

    @Bean
    @Scope("singleton")
    public CrudService<Task> orderService(final TaskRepository taskRepository) {
        return new CrudService<>(taskRepository);
    }

}
