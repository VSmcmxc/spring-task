package com.epam.legacy.repository;

import com.epam.legacy.entity.Task;
import com.epam.legacy.entity.User;

import java.util.List;

public interface TaskRepository extends GenericRepository<Task, Long> {

    List<Task> findAllTasksByUser(User user);

    Boolean markTaskAsCompleted(Task task);

    Boolean markTaskAsUncompleted(Task task);

}
