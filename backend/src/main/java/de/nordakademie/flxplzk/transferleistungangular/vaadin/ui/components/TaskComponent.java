package de.nordakademie.flxplzk.transferleistungangular.vaadin.ui.components;


import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;
import de.nordakademie.flxplzk.transferleistungangular.domain.Task;

public class TaskComponent extends CustomComponent {
    private TaskDesign designRoot = new TaskDesign();
    @DesignRoot
    private static class TaskDesign extends VerticalLayout{
        private Label title;
        private Label description;
    }
    public TaskComponent(Task task) {
        Design.read("TaskComponent.html", this.designRoot);
        setCompositionRoot(this.designRoot);
        designRoot.title.setValue(task.getTitle());
        designRoot.description.setValue(task.getDescription());
    }
}
