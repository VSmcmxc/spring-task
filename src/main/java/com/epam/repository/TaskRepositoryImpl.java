package com.epam.repository;

import com.epam.entity.Task;
import com.epam.entity.TaskRowMapper;
import com.epam.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepositoryImpl implements TaskRepository {


    private static final String CREATE_TASK = "INSERT INTO tasks_list.task (id_user, task_description, task_complete, task_priority) VALUES(?, ?, ?, ?)";
    private static final String GET_ALL_TASKS = "select * from tasks_list.task left join tasks_list.user on tasks_list.user.id_user=tasks_list.task.id_user";

    private JdbcTemplate jdbcTemplate;

    private TaskRowMapper taskRowMapper;

    @Autowired
    public TaskRepositoryImpl(JdbcTemplate jdbcTemplate, TaskRowMapper taskRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.taskRowMapper = taskRowMapper;
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
    public Task create(Task task) {
        jdbcTemplate.update(CREATE_TASK, new Object[]{task.getUser().getUserId(), task.getDescription(), task.getComplete() == true ? 1 : 0, task.getPriority().toString()});
        return task;
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
        List<Task> tasks = jdbcTemplate.query(GET_ALL_TASKS, taskRowMapper);
        return tasks;
    }
}
