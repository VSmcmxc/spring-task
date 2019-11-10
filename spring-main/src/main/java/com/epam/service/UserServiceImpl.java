package com.epam.service;

import com.epam.IncorrectRoleException;
import com.epam.RoleChecker;
import com.epam.dto.UserDTO;
import com.epam.entity.Role;
import com.epam.entity.User;
import com.epam.repository.UserRepository;
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
        User user = userRepository.getById(id);
        return user;
    }

    @Override
    public UserDTO getUserDTOById(Long id) {
        User user = userRepository.getById(id);
        UserDTO userDTO = UserDTO.builder().
                userId(user.getUserId()).
                userEmail(user.getUserEmail()).
                userName(user.getUserName()).
                build();

        return userDTO;
    }

    @Override
    public Boolean signUp(User user) {
        try {
            userRepository.create(user);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Boolean signIn(User user) {
        if (userRepository.getAll().contains(user)) {
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
        List<User> users = userRepository.getAll();
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
    public boolean buySubscribe(User user) {
        try {

            String subscription = DigestUtils.md5DigestAsHex(("secret".getBytes()));
            user.setSubscription(subscription);
            userRepository.update(user);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
