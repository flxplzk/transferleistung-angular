package de.nordakademie.flxplzk.transferleistungangular.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
public class Task extends RestResource {

    private String title;
    private String description;
    @Enumerated(value = EnumType.STRING)
    private TaskStatus taskStatus;
    @Enumerated(value = EnumType.STRING)
    private TaskPriority taskPriority;
    private LocalDate deadLineDate;
    private LocalDate creationDate;

    public Task(String title) {
        this.title = title;
    }

    public Task(final String title, final  String description, final TaskStatus taskStatus,
                final TaskPriority taskPriority, final LocalDate deadLineDate,
                final LocalDate creationDate) {
        this.title = title;
        this.description = description;
        this.taskStatus = taskStatus;
        this.taskPriority = taskPriority;
        this.deadLineDate = deadLineDate;
        this.creationDate = creationDate;
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

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }

    public LocalDate getDeadLineDate() {
        return deadLineDate;
    }

    public void setDeadLineDate(LocalDate deadLineDate) {
        this.deadLineDate = deadLineDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
