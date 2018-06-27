package de.nordakademie.flxplzk.transferleistungangular.service;

import com.google.common.collect.Lists;
import de.nordakademie.flxplzk.transferleistungangular.domain.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.stream.Collectors;

public class TaskService {

    private final CrudRepository<Task, Long> crudRepository;

    public TaskService(CrudRepository<Task, Long> crudRepository) {
        this.crudRepository = crudRepository;
    }

    public Task save(final Task model) {
        return this.crudRepository.save(model);
    }

    public void delete(final long id) {
        this.crudRepository.delete(id);
    }

    public List<Task> findAll() {
        return Lists.newArrayList(this.crudRepository.findAll());
    }

	public Task findOne(final Long id) {
		return crudRepository.findOne(id);
	}
}
