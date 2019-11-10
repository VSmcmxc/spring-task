package com.epam.entity;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"userId"})
public class User {

    private Long userId;
    private String userName;
    private String userEmail;
    private String password;
    private String subscription;
    private Role role;

    public User(Long userId, String userName, String userEmail, String password) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.password = password;
        subscription = "";
        role = Role.USER;
    }

    public User(String userName, String userEmail, String password) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.password = password;
        subscription = "";
        role = Role.USER;
    }
}
