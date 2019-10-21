package com.epam.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = { "taskId" })
public class Task {

    private Long taskId;
    private String description;
    private Boolean complete;
    private User user;

}
