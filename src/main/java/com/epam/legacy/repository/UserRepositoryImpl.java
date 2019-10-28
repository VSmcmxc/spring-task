package com.epam.legacy.repository;

import com.epam.legacy.entity.User;
import com.epam.legacy.entity.UserRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private static final String GET_ALL_USERS = "select * from tasks_list.user";
    private static final String CREATE_USER = "INSERT INTO tasks_list.user(user_name, user_email, " +
            "user_password) VALUES(?, ?, ?)";
    private static final String UPDATE_USER = "update tasks_list.user set user_name = ?, user_email = ?, user_password = ?," +
            " role = ?, user_subscription = ? where id_user = ?";

    private JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    @Override
    public User create(User user) {
        jdbcTemplate.update(
                CREATE_USER,
                new Object[]{user.getUserName(), user.getUserEmail(),
                        user.getPassword()});
        return user;
    }

    @Override
    public User getById(Long id) {
        User user = (User) jdbcTemplate.queryForObject("select * from tasks_list.user where id_user = ?",
                new Object[]{id}, new UserRowMapper());
        return user;
    }


    @Transactional
    @Override
    public User update(User user) {
        jdbcTemplate.update(UPDATE_USER, new Object[]{user.getUserName(), user.getUserEmail(), user.getPassword(),
                user.getRole(), user.getSubscription(), user.getUserId()});
        return user;
    }

    @Transactional
    @Override
    public Long deleteById(Long id) {
        jdbcTemplate.update("delete from tasks_list.user where id_user = ?", id);
        return id;
    }


    @Override
    public List<User> getAll() {
        List<User> users = jdbcTemplate.query(GET_ALL_USERS, new UserRowMapper());
        return users;
    }


}
