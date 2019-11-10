package com.epam.controller;


import com.epam.dto.UserDTO;
import com.epam.entity.User;
import com.epam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signUp")
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean signUp(@RequestBody User user) {
        return userService.signUp(user);
    }

    @PostMapping("/signIn")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Boolean signIn(@RequestBody User user) {
        return userService.signIn(user);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/buySubscribe/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean buySubscribe(@PathVariable long id) {
        return userService.buySubscribe(userService.getUserById(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public UserDTO getAllUsers(@PathVariable long id) {
        return userService.getUserDTOById(id);
    }

}
