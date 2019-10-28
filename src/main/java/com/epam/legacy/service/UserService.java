package com.epam.legacy.service;

import com.epam.legacy.entity.User;

import java.util.List;


public interface UserService {

    Boolean signUp(User user);

    Boolean signIn(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    boolean buySubscribe(User user);
}
