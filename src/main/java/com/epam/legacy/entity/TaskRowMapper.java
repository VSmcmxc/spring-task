package com.epam.legacy.entity;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskRowMapper implements RowMapper<Task> {

    private JdbcTemplate jdbcTemplate;

    public TaskRowMapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Task mapRow(ResultSet resultSet, int i) throws SQLException {
        Task task = new Task();
        task.setTaskId(resultSet.getLong("id_task"));
        task.setDescription(resultSet.getString("task_description"));
        task.setPriority(Priority.valueOf(resultSet.getString("task_priority")));
        task.setComplete((resultSet.getInt("task_complete") == 1) ? true : false);
        Long userId = resultSet.getLong("id_user");
        task.setUser((User) jdbcTemplate.queryForObject("select * from tasks_list.user where id_user = ?",
                new Object[]{userId}, new UserRowMapper()));

        return task;

    }

}