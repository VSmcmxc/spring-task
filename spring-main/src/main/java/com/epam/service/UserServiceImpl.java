package com.epam.service;

import com.epam.IncorrectRoleException;
import com.epam.RoleChecker;
import com.epam.entity.Role;
import com.epam.entity.User;
import com.epam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleChecker roleChecker;

  /*  // @Resource(name = "roleChecker")
    public void setRoleChecker(RoleChecker roleChecker) {
        this.roleChecker = roleChecker;
    }

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }*/

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleChecker roleChecker) {
        this.userRepository = userRepository;
        this.roleChecker = roleChecker;
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
