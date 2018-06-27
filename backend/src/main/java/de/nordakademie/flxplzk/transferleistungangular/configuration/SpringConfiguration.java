package de.nordakademie.flxplzk.transferleistungangular.configuration;

import com.google.common.collect.Lists;
import de.nordakademie.flxplzk.transferleistungangular.domain.Tag;
import de.nordakademie.flxplzk.transferleistungangular.domain.Task;
import de.nordakademie.flxplzk.transferleistungangular.persistence.TaskRepository;
import de.nordakademie.flxplzk.transferleistungangular.service.TaskService;
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
	public TaskService taskService(final TaskRepository taskRepository) {
		return new TaskService(taskRepository);
	}
}
