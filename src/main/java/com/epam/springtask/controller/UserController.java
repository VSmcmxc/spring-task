package com.epam.springtask.controller;


import com.epam.springtask.domain.User;
import com.epam.springtask.dto.UserDTO;
import com.epam.springtask.dto.UserSignInDTO;
import com.epam.springtask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public Boolean signUp(@RequestBody UserSignInDTO user) {
        return userService.signUp(user);
    }

    @PostMapping("/signIn")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Boolean signIn(@RequestBody UserSignInDTO user) {
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
        return userService.buySubscribe(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public UserDTO getAllUsers(@PathVariable long id) {
        return userService.getUserDTOById(id);
    }

}
