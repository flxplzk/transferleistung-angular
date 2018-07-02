package de.nordakademie.flxplzk.transferleistungangular.vaadin.ui.components;


import com.vaadin.annotations.DesignRoot;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ClientConnector;
import com.vaadin.shared.Registration;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;
import com.vaadin.ui.themes.ValoTheme;
import de.nordakademie.flxplzk.transferleistungangular.domain.Task;

public class TaskComponent extends CustomComponent {
    private TaskDesign designRoot = new TaskDesign();

    @DesignRoot
    private static class TaskDesign extends CssLayout{
        private Label title;
        private Label description;
        private Button trashButton;
    }

    public TaskComponent(Task task) {
        Design.read("TaskComponent.html", this.designRoot);
        setCompositionRoot(this.designRoot);
        designRoot.title.setValue(task.getTitle());
        designRoot.description.setValue(task.getDescription());
        designRoot.trashButton.setIcon(VaadinIcons.TRASH);
        designRoot.trashButton.setStyleName(ValoTheme.BUTTON_BORDERLESS);
    }

    public Registration addDeleteListener(Button.ClickListener listener) {
        return this.designRoot.trashButton.addClickListener(listener);
    }
}
