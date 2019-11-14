package com.epam.springtask.service;

import com.epam.springtask.domain.Priority;
import com.epam.springtask.domain.Task;
import com.epam.springtask.domain.User;
import com.epam.springtask.dto.TaskDTO;
import com.epam.springtask.dto.UserDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TaskService {
    // List<TaskDTO> findTasksByUser(User user);

    List<TaskDTO> findTasksByUserId(Long id);

    TaskDTO createTask(TaskDTO task, UserDTO user);

    Long deleteTask(Long id);

    Boolean markTaskAsCompleted(Long id);

    Boolean markTaskAsUncompleted(Long id);

    TaskDTO updateTask(Task task);

    TaskDTO getById(Long idTask);

    Task getTaskById(Long id);

    TaskDTO setTaskPriority(Priority priority, Long id);

    public Long deleteTaskById(Long id);

    public Boolean upload(MultipartFile file, Long id);

    public boolean checkSubscribeByUserId(Long id);

    List<TaskDTO> findAllTaskSorted();
}
