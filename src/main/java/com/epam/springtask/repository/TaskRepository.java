package com.epam.springtask.repository;

import com.epam.springtask.domain.Task;
import com.epam.springtask.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Long> {


    @Query("select t from Task t where t.user=?1")
    List<Task> findAllTasksByUser(User user);



    @Modifying
    @Query("update Task t set t.complete = true where t.id = ?1")
    Boolean markTaskAsCompleted(Long id);

    @Modifying
    @Query("update Task t set t.complete = false where t.id = ?1")
    Boolean markTaskAsUncompleted(Long id);


}
