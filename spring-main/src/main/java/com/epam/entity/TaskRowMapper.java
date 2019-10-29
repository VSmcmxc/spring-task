package com.epam.entity;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TaskRowMapper implements RowMapper<Task> {


    @Override
    public Task mapRow(ResultSet resultSet, int i) throws SQLException {
        Task task = new Task();

        task.setTaskId(resultSet.getLong("id_task"));
        task.setDescription(resultSet.getString("task_description"));
        String priority = resultSet.getString("task_priority").trim().toUpperCase();
        Priority newPriority = Priority.valueOf(Priority.class, priority);
        task.setPriority(newPriority);
        task.setComplete((resultSet.getInt("task_complete") == 1) ? true : false);
        User user = new User();
        user.setUserId(resultSet.getLong("id_user"));
        user.setUserName(resultSet.getString("user_name"));
        user.setUserEmail(resultSet.getString("user_email"));
        user.setPassword(resultSet.getString("user_password"));
        user.setRole(Role.valueOf(resultSet.getString("role")));
        task.setUser(user);
        return task;

    }

}

