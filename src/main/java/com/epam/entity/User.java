package com.epam.entity;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = { "userId" })
public class User {

    private Long userId;
    private String userName;
    private String userEmail;
    private String password;

}
