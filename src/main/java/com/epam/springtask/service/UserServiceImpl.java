package com.epam.springtask.service;


import com.epam.IncorrectRoleException;
import com.epam.RoleChecker;
import com.epam.springtask.domain.Role;
import com.epam.springtask.domain.User;
import com.epam.springtask.dto.UserDTO;
import com.epam.springtask.dto.UserSignInDTO;
import com.epam.springtask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleChecker roleChecker;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleChecker roleChecker) {
        this.userRepository = userRepository;
        this.roleChecker = roleChecker;
    }

    @Override
    public User getUserById(Long id) {
        User user = userRepository.getOne(id);
        return user;
    }

    @Override
    public UserDTO getUserDTOById(Long id) {
        User user = userRepository.getOne(id);
        UserDTO userDTO = UserDTO.builder().
                userId(user.getUserId()).
                userEmail(user.getUserEmail()).
                userName(user.getUserName()).
                build();

        return userDTO;
    }

    @Override
    public Boolean signUp(UserSignInDTO userDTO) {
        try {
            User user = User.builder()
                    .userName(userDTO.getUserName())
                    .userEmail(userDTO.getUserEmail())
                    .password(userDTO.getPassword())
                    .build();
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Boolean signIn(UserSignInDTO userDTO) {
        User user = User.builder()
                .userName(userDTO.getUserName())
                .userEmail(userDTO.getUserEmail())
                .password(userDTO.getPassword())
                .build();
        if (userRepository.findAll().contains(user)) {
            try {
                roleChecker.checkRole(user.getRole(), Role.ADMIN);
            } catch (IncorrectRoleException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user : users) {
            UserDTO userDTO = UserDTO.builder().
                    userId(user.getUserId()).
                    userEmail(user.getUserEmail()).
                    userName(user.getUserName()).
                    build();
            userDTOS.add(userDTO);
        }


        return userDTOS;
    }

    @Override
    public boolean buySubscribe(Long id) {
        try {
            User user = userRepository.getOne(id);
            String subscription = DigestUtils.md5DigestAsHex(("secret".getBytes()));
            user.setSubscription(subscription);
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }

    }




}
