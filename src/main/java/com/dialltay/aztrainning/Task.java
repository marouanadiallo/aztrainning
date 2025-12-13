package com.dialltay.aztrainning;

import java.util.UUID;

public class Task {

    private final Long id;

    private String title;
    private String description;
    private TaskStatus status;

    private final UUID businessKey;

    public Task() {
        this.id = null;
        this.businessKey = UUID.randomUUID();
    }

    public Task(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.businessKey = UUID.randomUUID();
        this.status = TaskStatus.PENDING;
    }

    public Long getId() {
        return id;
    }

    public UUID getBusinessKey() {
        return businessKey;
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

    public TaskStatus getStatus() {
        return status;
    }
    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Task task)) return false;

        return businessKey.equals(task.businessKey);
    }

    @Override
    public int hashCode() {
        return businessKey.hashCode();
    }
}
