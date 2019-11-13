package com.epam.springtask.domain;


import com.epam.springtask.repository.PriorityJpaConverter;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "task")
@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;
    @Column
    private String description;
    @Column
    private Boolean complete;
    @Convert(converter = PriorityJpaConverter.class)
    private Priority priority;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @Column
    private String fileName;


    public Task(Long taskId, String description, Boolean complete, User user) {
        this.taskId = taskId;
        this.description = description;
        this.complete = complete;
        this.user = user;
        priority = Priority.MEDIUM;
        fileName = "";
    }

    public Task(String description, Boolean complete, User user) {
        this.description = description;
        this.complete = complete;
        this.user = user;
        this.priority = Priority.MEDIUM;
        fileName = "";
    }

    public Task(Long taskId, String description, Boolean complete, User user, Priority priority) {
        this.taskId = taskId;
        this.description = description;
        this.complete = complete;
        this.user = user;
        this.priority = priority;
        this.priority = Priority.MEDIUM;
        fileName = "";
    }
}
