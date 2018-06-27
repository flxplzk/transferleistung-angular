package de.nordakademie.flxplzk.transferleistungangular.endpoint;

import de.nordakademie.flxplzk.transferleistungangular.domain.Task;
import de.nordakademie.flxplzk.transferleistungangular.service.TaskService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/tasks")
public class TaskEndpoint {

    private final TaskService taskService;

    public TaskEndpoint(final TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Task save(@RequestBody final Task model) {
        return this.taskService.save(model);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Task update(@PathVariable(name = "id") final long id,
                    @RequestBody final Task model) {
        model.setId(id);
        return this.taskService.save(model);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE)
    public void delete(@PathVariable(name = "id") final Long id) {
        this.taskService.delete(id);
    }

	@RequestMapping(value = "/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Task findOne(@PathVariable(name = "id") final Long id) {
		return this.taskService.findOne(id);
	}

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Task> findAll() {
        return this.taskService.findAll();
    }

}
