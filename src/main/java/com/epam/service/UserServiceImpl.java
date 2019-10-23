package com.epam.service;

import com.epam.entity.Task;
import com.epam.entity.User;
import com.epam.repository.TaskRepository;
import com.epam.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
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

    @Override
    public boolean buySubscribe(User user) {
        try {
           /* MessageDigest digest = MessageDigest.getInstance("MD5");
            // Update input string in message digest
            digest.update("secret".getBytes(), 0, "secret".length());
            // Converts message digest value in base 16 (hex)
            String md5 = new BigInteger(1, digest.digest()).toString(16);

            //*/
            String subscription = DigestUtils.md5DigestAsHex(("secret".getBytes()));
            user.setSubscription(subscription);
            userRepository.update(user);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
