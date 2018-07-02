package de.nordakademie.flxplzk.transferleistungangular.vaadin.ui.components;

import com.vaadin.annotations.DesignRoot;
import com.vaadin.navigator.View;
import com.vaadin.shared.Registration;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;
import com.vaadin.ui.themes.ValoTheme;
import de.nordakademie.flxplzk.transferleistungangular.domain.Task;
import de.nordakademie.flxplzk.transferleistungangular.service.TaskService;

import java.util.ArrayList;
import java.util.List;

@SpringView(name = "")
public class TaskView extends CustomComponent implements View {

    @DesignRoot
    private static class TaskViewDesign extends VerticalLayout {
        private TextField searchTerm;
        private Button searchButton;
        private Button newTaskButton;
        private VerticalLayout tasksContainer;
    }

    private final TaskService taskService;
    private final TaskViewDesign rootComponent = new TaskViewDesign();
    private final List<Registration> registrations = new ArrayList<>();

    public TaskView(final TaskService taskService) {
        Design.read("TaskView.html", this.rootComponent);
        this.taskService = taskService;
        setCompositionRoot(rootComponent);
        findTasks();
        attachListeners();
    }

    private void attachListeners() {
        rootComponent.searchButton.addClickListener(click -> findTasks());
        rootComponent.searchTerm.addValueChangeListener(change -> findTasks());
    }

    private void findTasks() {
        removeRegistrations();
        rootComponent.tasksContainer.removeAllComponents();
        this.taskService.findAll().forEach(task -> {
            final TaskComponent taskComponent = new TaskComponent(task);
            rootComponent.tasksContainer.addComponent(taskComponent);
            this.registrations.add(taskComponent.addDeleteListener(click -> {
                delete(task);
                findTasks();
            }));
        });
    }

    private void delete(Task task) {
        this.taskService.delete(task.getId());
    }

    private void removeRegistrations() {
        this.registrations.forEach(Registration::remove);
        this.registrations.clear();
    }
}
