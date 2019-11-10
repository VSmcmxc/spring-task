package com.epam.service;

import com.epam.dto.UserDTO;
import com.epam.entity.User;

import java.util.List;


public interface UserService {

    Boolean signUp(User user);

    Boolean signIn(User user);

    User getUserById(Long id);

    List<UserDTO> getAllUsers();

    boolean buySubscribe(User user);

    public UserDTO getUserDTOById(Long id);

}
