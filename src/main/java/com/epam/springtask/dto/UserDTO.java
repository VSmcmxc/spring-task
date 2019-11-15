package com.epam.springtask.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {


    private Long userId;
    @NotNull
    private String userName;
    @Email(message = "Email should be valid")
    private String userEmail;

    private String subscription;
}
