package com.epam.repository;

import com.epam.entity.Task;
import com.epam.entity.User;

import java.util.List;

public interface TaskRepository extends GenericRepository<Task, Long> {

    List<Task> findAllTasksByUser(User user);

    Boolean markTaskAsCompleted(Task task);

    Boolean markTaskAsUncompleted(Task task);

}
