package com.epam.springtask.repository;

import com.epam.springtask.domain.Task;
import com.epam.springtask.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllTasksByUser(User user);

    Boolean markTaskAsCompleted(Task task);

    Boolean markTaskAsUncompleted(Task task);

}
