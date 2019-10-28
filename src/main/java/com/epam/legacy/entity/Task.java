package com.epam.legacy.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"taskId"})
public class Task {

    private Long taskId;
    private String description;
    private Boolean complete;
    private User user;
    private Priority priority;

    public Task(Long taskId, String description, Boolean complete, User user) {
        this.taskId = taskId;
        this.description = description;
        this.complete = complete;
        this.user = user;
        priority = Priority.HIGHT;
    }

}
