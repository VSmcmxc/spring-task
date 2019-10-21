package com.epam.controller;


import com.epam.entity.Task;
import com.epam.entity.User;
import com.epam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller("userController")
public class UserController {

    @Autowired
    UserService userService;


    public User getUserById(Long id) {
        return userService.getUserById(id);
    }

    public boolean signIn(User user) {
        return userService.signIn(user);
    }

    public boolean signUp(User user) {
        return userService.signUp(user);
    }

    public List<Task> findTasksByUser(User user) {
        return userService.findTasksByUser(user);
    }

    public Task createTask(Task task, User user) {
        return userService.createTask(task, user);
    }

    public Long deleteTask(Task task) {
        return userService.deleteTask(task);
    }

    public boolean markTaskAsComplete(Task task) {
        return userService.markTaskAsCompleted(task);
    }

    public boolean markTaskAsUncompleted(Task task) {
        return userService.markTaskAsUncompleted(task);
    }

}
