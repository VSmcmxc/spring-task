package com.epam.legacy.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getLong("id_user"));
        user.setUserName(resultSet.getString("user_name"));
        user.setUserEmail(resultSet.getString("user_email"));
        user.setPassword(resultSet.getString("user_password"));
        user.setRole(Role.valueOf(resultSet.getString("role")));
        return user;
    }

}