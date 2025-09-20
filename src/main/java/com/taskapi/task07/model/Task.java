package com.taskapi.task07.model;

import jakarta.validation.constraints.NotBlank;

public class Task {
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    public Task() {}

    public Task(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}