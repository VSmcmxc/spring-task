package com.epam.service;

import com.epam.entity.Task;
import com.epam.entity.User;
import com.epam.repository.TaskRepository;
import com.epam.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")

public class UserServiceImpl implements UserService {

    private TaskRepository taskRepository;
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getById(id);
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
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAll();
    }
}
