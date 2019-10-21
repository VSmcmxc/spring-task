package com.epam.repository;

import com.epam.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {


    TreeMap<Long, User> userMap;

    @Autowired
    @Qualifier( "users")
    public void setUserMap(TreeMap<Long, User> userMap) {
        this.userMap = userMap;
    }

    @Override
    public User create(User user) {
        return userMap.put(user.getUserId(), user);
    }

    @Override
    public User getById(Long id) {
        return userMap.get(id);
    }

    @Override
    public User update(User user) {
        return userMap.put(user.getUserId(), user);
    }

    @Override
    public Long deleteById(Long id) {
        userMap.remove(id);
        return id;
    }



    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>(userMap.values());
        return users;
    }
}
