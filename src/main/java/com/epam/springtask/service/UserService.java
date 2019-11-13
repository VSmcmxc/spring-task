package com.epam.springtask.service;


import com.epam.springtask.domain.User;
import com.epam.springtask.dto.UserDTO;

import java.util.List;


public interface UserService {

    Boolean signUp(User user);

    Boolean signIn(User user);

    User getUserById(Long id);

    List<UserDTO> getAllUsers();

    boolean buySubscribe(User user);

    public UserDTO getUserDTOById(Long id);

}
