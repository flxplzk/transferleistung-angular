package de.nordakademie.flxplzk.transferleistungangular.configuration;

import de.nordakademie.flxplzk.transferleistungangular.vaadin.ui.components.MenuComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class VaadinConfiguration {

	@Bean
	@Scope("prototype")
	public MenuComponent menuComponent(){
		return new MenuComponent();
	}
}
