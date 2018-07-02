package de.nordakademie.flxplzk.transferleistungangular.vaadin.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import de.nordakademie.flxplzk.transferleistungangular.vaadin.ui.components.MenuComponent;
import de.nordakademie.flxplzk.transferleistungangular.vaadin.ui.components.TaskView;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI(path = "/vaadin")
public class TaskManagerUi extends UI {
    private final SpringNavigator springNavigator;
    private final MenuComponent menuComponent;
    private final ComponentContainer routerOutlet;
    private final VerticalLayout rootLayout;

    @Autowired
    public TaskManagerUi(final MenuComponent menuComponent, final SpringNavigator springNavigator) {
        this.menuComponent = menuComponent;
        this.springNavigator = springNavigator;
        this.routerOutlet = new CssLayout();
        this.rootLayout = new VerticalLayout(this.menuComponent, this.routerOutlet);
    }

    @Override
    protected void init(VaadinRequest request) {
        setContent(this.rootLayout);
        this.springNavigator.init(this, this.routerOutlet);
        setNavigator(this.springNavigator);
        this.rootLayout.setSizeFull();
        this.rootLayout.setExpandRatio(this.routerOutlet, 1f);
        this.rootLayout.setMargin(false);
        routerOutlet.setSizeFull();
    }

}
