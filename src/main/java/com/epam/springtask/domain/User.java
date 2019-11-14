package com.epam.springtask.domain;


import com.epam.springtask.repository.RoleJpaConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Column
    private String userName;
    @Column
    private String userEmail;
    @Column
    private String password;
    @Column
    private String subscription;

    @Convert(converter = RoleJpaConverter.class)
    private Role role;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();

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
