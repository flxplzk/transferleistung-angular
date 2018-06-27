package de.nordakademie.flxplzk.transferleistungangular.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String description;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Tag> tags;
    private boolean favorite;
    private String state;

    public Task() {
    }

    public Task(String title, String description, List<Tag> tags, boolean favorite, String state) {
        this.title = title;
        this.description = description;
        this.tags = tags;
        this.favorite = favorite;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
