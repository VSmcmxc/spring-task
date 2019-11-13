package com.epam.springtask.domain;


import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"userId"})
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long userId;
    private String userName;
    private String userEmail;
    private String password;
    private String subscription;
    private Role role;

    public User(String userName, String userEmail, String password, String subscription, Role role) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.password = password;
        this.subscription = "1";
        this.role = role;
    }

    public User(Long userId, String userName, String userEmail, String password) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.password = password;
        subscription = "1";
        role = Role.USER;
    }

    public User(String userName, String userEmail, String password) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.password = password;
        subscription = "1";
        role = Role.USER;
    }


}
