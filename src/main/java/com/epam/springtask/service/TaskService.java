package com.epam.springtask.service;

import com.epam.springtask.domain.Priority;
import com.epam.springtask.domain.Task;
import com.epam.springtask.domain.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TaskService {
    List<Task> findTasksByUser(User user);

    List<Task> findTasksByUserId(Long id);

    Task createTask(Task task, User user);

    Long deleteTask(Long id);

    Boolean markTaskAsCompleted(Task task);

    Boolean markTaskAsUncompleted(Task task);

    Task updateTask(Task task);

    Task getById(Long idTask);

    Task setTaskPriority(Priority priority, Task task);

    public Long deleteTaskById(Long id);

    public Boolean upload(MultipartFile file, Long id);

    public boolean checkSubscribeByUserId(Long id);
}
