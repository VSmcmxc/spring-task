package com.epam.controller;


import com.epam.entity.Task;
import com.epam.entity.User;
import com.epam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller("userController")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User getUserById(Long id) {
        return userService.getUserById(id);
    }

    public boolean signIn(User user) {
        return userService.signIn(user);
    }

    public boolean signUp(User user) {
        return userService.signUp(user);
    }

    public  List<User> getAllUsers (){return userService.getAllUsers();}

    public boolean buySubscribe (User user) {return userService.buySubscribe(user);}


}
