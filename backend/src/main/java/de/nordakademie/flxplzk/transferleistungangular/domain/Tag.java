package de.nordakademie.flxplzk.transferleistungangular.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tag {
	@Id
	@GeneratedValue
	private long id;
	private String label;

	public Tag() {
	}

	public Tag(String label) {
		this.id = id;
		this.label = label;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
