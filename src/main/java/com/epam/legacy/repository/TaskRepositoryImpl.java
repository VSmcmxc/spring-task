package com.epam.legacy.repository;

import com.epam.legacy.entity.Task;
import com.epam.legacy.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {



    private JdbcTemplate jdbcTemplate;

    public TaskRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Task> findAllTasksByUser(User user) {
        return null;
    }

    @Override
    public Boolean markTaskAsCompleted(Task task) {
        return null;
    }

    @Override
    public Boolean markTaskAsUncompleted(Task task) {
        return null;
    }

    @Override
    public Task create(Task object) {
        return null;
    }

    @Override
    public Task getById(Long id) {
        return null;
    }

    @Override
    public Task update(Task object) {
        return null;
    }

    @Override
    public Long deleteById(Long id) {
        return null;
    }

    @Override
    public List<Task> getAll() {
        return null;
    }
}
