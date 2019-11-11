package com.epam.entity;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"taskId"})
public class Task {

    private Long taskId;
    private String description;
    private Boolean complete;
    private User user;
    private Priority priority;
    private MultipartFile file;

    public Task(Long taskId, String description, Boolean complete, User user) {
        this.taskId = taskId;
        this.description = description;
        this.complete = complete;
        this.user = user;
        priority = Priority.MEDIUM;
    }

    public Task(String description, Boolean complete, User user) {
        this.description = description;
        this.complete = complete;
        this.user = user;
        this.priority = Priority.MEDIUM;
    }

    public Task(Long taskId, String description, Boolean complete, User user, Priority priority) {
        this.taskId = taskId;
        this.description = description;
        this.complete = complete;
        this.user = user;
        this.priority = priority;
    }
}
