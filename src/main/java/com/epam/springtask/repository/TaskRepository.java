package com.epam.springtask.repository;

import com.epam.springtask.domain.Task;
import com.epam.springtask.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllTasksByUser(User user);

    //Boolean markTaskAsCompleted(Task task);

    @Modifying
    @Query("update Task t set t.complete = true where t.id = ?1")
    Boolean markTaskAsCompleted(Long id);

    /*Boolean markTaskAsUncompleted(Task task);*/

}
