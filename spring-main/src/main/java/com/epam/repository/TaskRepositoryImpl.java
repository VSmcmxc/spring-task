package com.epam.repository;

import com.epam.entity.Task;
import com.epam.entity.TaskRowMapper;
import com.epam.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepositoryImpl implements TaskRepository {


    private static final String CREATE_TASK = "INSERT INTO tasks_list.task (id_user, task_description, task_complete, task_priority) VALUES(?, ?, ?, ?)";
    private static final String GET_ALL_TASKS = "select * from tasks_list.task left join tasks_list.user on tasks_list.user.id_user=tasks_list.task.id_user";
    private static final String MARK_TASK_AS_COMPLETED = "UPDATE tasks_list.task SET task_complete = 1 WHERE id_task = ? ";
    private static final String MARK_TASK_AS_UNCOMPLETED = "UPDATE tasks_list.task SET task_complete = 0 WHERE id_task = ? ";
    private static final String GET_TASK_BY_ID = "select * from tasks_list.task left join tasks_list.user on tasks_list.user.id_user=tasks_list.task.id_user WHERE tasks_list.task.id_task = ? ";
    private static final String UPDATE_TASK = "UPDATE tasks_list.task SET task_complete = ?, task_description = ?, task_priority = ? WHERE id_task = ? ";

    private JdbcTemplate jdbcTemplate;

    private TaskRowMapper taskRowMapper;

    @Autowired
    public TaskRepositoryImpl(JdbcTemplate jdbcTemplate, TaskRowMapper taskRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.taskRowMapper = taskRowMapper;
    }

    @Override
    public List<Task> findAllTasksByUser(User user) {
        List<Task> tasks = jdbcTemplate.query("select * from tasks_list.task left join tasks_list.user on tasks_list.user.id_user=tasks_list.task.id_user where  tasks_list.task.id_user = ?",
                new Object[]{user.getUserId()}, taskRowMapper);
        return tasks;
    }

    @Override
    public Boolean markTaskAsCompleted(Task task) {
        try {
            jdbcTemplate.update(MARK_TASK_AS_COMPLETED, new Object[]{task.getTaskId()});
            return true;
        } catch (DataAccessException e) {
            return false;
        }

    }

    @Override
    public Boolean markTaskAsUncompleted(Task task) {
        try {
            jdbcTemplate.update(MARK_TASK_AS_UNCOMPLETED, new Object[]{task.getTaskId()});
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }

    @Override
    public Task create(Task task) {
        jdbcTemplate.update(CREATE_TASK, new Object[]{task.getUser().getUserId(), task.getDescription(), task.getComplete() == true ? 1 : 0, task.getPriority().toString()});
        return task;
    }

    @Override
    public Task getById(Long id) {
        Task task = jdbcTemplate.queryForObject(GET_TASK_BY_ID, new Object[]{id}, taskRowMapper);
        return task;
    }

    @Override
    public Task update(Task task) {
        jdbcTemplate.update(UPDATE_TASK, new Object[]{task.getComplete(), task.getDescription(), task.getPriority().toString(),
                task.getTaskId()});
        return task;
    }

    @Override
    public Long deleteById(Long id) {
        jdbcTemplate.update("delete from tasks_list.task where id_task = ?", id);
        return id;
    }

    @Override
    public List<Task> getAll() {
        List<Task> tasks = jdbcTemplate.query(GET_ALL_TASKS, taskRowMapper);
        return tasks;
    }
}
