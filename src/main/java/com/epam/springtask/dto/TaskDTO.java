package com.epam.springtask.dto;

import com.epam.springtask.domain.Priority;
import com.epam.springtask.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

 /*   private Long taskId;*/
    private String description;
    private Boolean complete;
    private Long id_user;
    private Priority priority;
}
