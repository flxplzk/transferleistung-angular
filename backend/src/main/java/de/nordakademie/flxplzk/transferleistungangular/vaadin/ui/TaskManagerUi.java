package de.nordakademie.flxplzk.transferleistungangular.vaadin.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

@SpringUI(path = "/vaadin")
public class TaskManagerUi extends UI {
    @Override
    protected void init(VaadinRequest request) {
        setContent(new Label("hello world"));
    }
}
