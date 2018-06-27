package de.nordakademie.flxplzk.transferleistungangular.vaadin.ui.components;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringView(name = "")
public class TaksView extends CustomComponent implements View {

	private Label titel = new Label("Meine Aufgaben");
	private TextField searchTerm = new TextField();
	private Button searchButton = new Button("suchen");
	private VerticalLayout tasksContainer = new VerticalLayout();
	private Button newTaskButton = new Button("Neue Aufgabe anlegen");
	private HorizontalLayout searchPanel = new HorizontalLayout(searchTerm, searchButton);
	private VerticalLayout rootLayout = new VerticalLayout(titel, searchPanel, tasksContainer, newTaskButton);

	public TaksView() {
		setCompositionRoot(rootLayout);
		searchPanel.setExpandRatio(searchTerm, 1f);
		searchPanel.setWidth(100, Unit.PERCENTAGE);
		searchTerm.setWidth(100, Unit.PERCENTAGE);
		tasksContainer.setHeightUndefined();
		tasksContainer.setWidth("100%");
		tasksContainer.setSpacing(true);
		rootLayout.setComponentAlignment(newTaskButton, Alignment.BOTTOM_RIGHT);
		newTaskButton.addStyleName(ValoTheme.BUTTON_FRIENDLY);
		rootLayout.setSizeFull();
		titel.addStyleName(ValoTheme.LABEL_H2);
		titel.addStyleName(ValoTheme.LABEL_BOLD);
		setSizeFull();
		rootLayout.setExpandRatio(tasksContainer, 1f);
	}
}