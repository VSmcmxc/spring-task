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
    private String subscription;

    public User(Long userId, String userName, String userEmail, String password) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.password = password;
        subscription = "";
    }
}
