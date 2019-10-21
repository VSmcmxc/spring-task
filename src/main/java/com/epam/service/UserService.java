package com.epam.service;

import com.epam.entity.Task;
import com.epam.entity.User;

import java.util.List;


public interface UserService {

    Boolean signUp(User user);

    Boolean signIn(User user);

    User getUserById(Long id);

    List<Task> findTasksByUser(User user);

    Task createTask(Task task, User user);

    Long deleteTask(Task task);

    Boolean markTaskAsCompleted(Task task);

    Boolean markTaskAsUncompleted(Task task);
    List<User> getAllUsers();
}
