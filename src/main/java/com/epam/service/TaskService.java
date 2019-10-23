package com.epam.service;

import com.epam.entity.Task;
import com.epam.entity.User;

import java.util.List;

public interface TaskService {
    List<Task> findTasksByUser(User user);

    Task createTask(Task task, User user);

    Long deleteTask(Task task);

    Boolean markTaskAsCompleted(Task task);

    Boolean markTaskAsUncompleted(Task task);

    Task updateTask (Task task);

    Task getById (Long idTask);
}
