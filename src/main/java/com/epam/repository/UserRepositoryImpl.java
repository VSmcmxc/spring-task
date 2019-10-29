package com.epam.repository;

import com.epam.entity.User;
import com.epam.entity.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String GET_ALL_USERS = "select * from tasks_list.user";
    private static final String CREATE_USER = "INSERT INTO tasks_list.user (user_name, user_email, user_password, role) VALUES(?, ?, ?, ?)";
    private static final String UPDATE_USER = "update tasks_list.user set user_name = ?, user_email = ?, user_password = ?," +
            " role = ?, user_subscription = ? where id_user = ?";

    private JdbcTemplate jdbcTemplate;

    private UserRowMapper userRowMapper;



    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate, UserRowMapper userRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRowMapper = userRowMapper;
    }

    @Override
    public User create(User user) {
        jdbcTemplate.update(
                CREATE_USER,
                new Object[]{user.getUserName(), user.getUserEmail(),
                        user.getPassword(), user.getRole().toString()});
        return user;
    }

    @Override
    public User getById(Long id) {
        User user = (User) jdbcTemplate.queryForObject("select * from tasks_list.user where id_user = ?",
                new Object[]{id}, userRowMapper);
        return user;
    }



    @Override
    public User update(User user) {
        jdbcTemplate.update(UPDATE_USER, new Object[]{user.getUserName(), user.getUserEmail(), user.getPassword(),
                user.getRole(), user.getSubscription(), user.getUserId()});
        return user;
    }

    @Override
    public Long deleteById(Long id) {
        jdbcTemplate.update("delete from tasks_list.user where id_user = ?", id);
        return id;
    }


    @Override
    public List<User> getAll() {
        List<User> users = jdbcTemplate.query(GET_ALL_USERS, userRowMapper);
        return users;
    }


}
