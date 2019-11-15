package com.epam.springtask.dto;

import com.epam.springtask.domain.Priority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

 /*   private Long taskId;*/
    private String description;
    @NotNull
    private Boolean complete;
    @NotNull(message = "Name cannot be null")
    private Long id_user;
    @NotNull
    private Priority priority;
}
