package com.epam.legacy.service;

import com.epam.legacy.entity.Priority;
import com.epam.legacy.entity.Task;
import com.epam.legacy.entity.User;

import java.util.List;

public interface TaskService {
    List<Task> findTasksByUser(User user);

    Task createTask(Task task, User user);

    Long deleteTask(Task task);

    Boolean markTaskAsCompleted(Task task);

    Boolean markTaskAsUncompleted(Task task);

    Task updateTask(Task task);

    Task getById(Long idTask);

    Task setTaskPriority(Priority priority, Task task);
}
