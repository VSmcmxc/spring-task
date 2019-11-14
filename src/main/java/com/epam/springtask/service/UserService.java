package com.epam.springtask.service;


import com.epam.springtask.domain.User;
import com.epam.springtask.dto.UserDTO;
import com.epam.springtask.dto.UserSignInDTO;

import java.util.List;


public interface UserService {

    Boolean signUp(UserSignInDTO user);

    Boolean signIn(UserSignInDTO user);

    User getUserById(Long id);

    List<UserDTO> getAllUsers();

    boolean buySubscribe(Long id);

    public UserDTO getUserDTOById(Long id);


}
