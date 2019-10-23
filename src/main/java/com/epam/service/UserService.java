package com.epam.service;

import com.epam.entity.Task;
import com.epam.entity.User;

import java.util.List;


public interface UserService {

    Boolean signUp(User user);

    Boolean signIn(User user);

    User getUserById(Long id);

    List<User> getAllUsers();
}
