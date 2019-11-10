package com.epam.dto;

import com.epam.entity.Priority;
import com.epam.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

    private Long taskId;
    private String description;
    private Boolean complete;
    private User user;
    private Priority priority;
}
