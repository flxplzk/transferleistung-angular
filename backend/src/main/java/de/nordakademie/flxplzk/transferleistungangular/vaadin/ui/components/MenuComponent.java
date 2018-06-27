package de.nordakademie.flxplzk.transferleistungangular.vaadin.ui.components;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;

public class MenuComponent extends HorizontalLayout {
	private int numberInProgressValue = 0;
	private Label appTitle = new Label("Task Manager");
	private Label numberInProgress = new Label("In Bearbeitung: " + this.numberInProgressValue);

	public MenuComponent() {
		this.addStyleNames(ValoTheme.MENUBAR_BORDERLESS, ValoTheme.MENU_ROOT);
		setHeight(60, Unit.PIXELS);
		setWidth(100, Unit.PERCENTAGE);
		addComponents(appTitle, numberInProgress);
		setComponentAlignment(appTitle, Alignment.MIDDLE_LEFT);
		setComponentAlignment(numberInProgress, Alignment.MIDDLE_RIGHT);
		setMargin(false);
		appTitle.setStyleName(ValoTheme.LABEL_H2);
		appTitle.addStyleName(ValoTheme.LABEL_BOLD);
		numberInProgress.addStyleName(ValoTheme.MENU_BADGE);
	}
}
