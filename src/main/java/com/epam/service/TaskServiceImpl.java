package com.epam.service;

import com.epam.entity.Task;
import com.epam.entity.User;
import com.epam.repository.TaskRepository;
import com.epam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;
    private UserRepository userRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Task> findTasksByUser(User user) {
        List<Task> tasks = taskRepository.findAllTasksByUser(user);
        return tasks;
    }

    @Override
    public Task createTask(Task task, User user) {
        task.setUser(user);
        return taskRepository.create(task);

    }

    @Override
    public Long deleteTask(Task task) {
        return taskRepository.deleteById(task.getTaskId());
    }

    @Override
    public Boolean markTaskAsCompleted(Task task) {
        taskRepository.markTaskAsCompleted(task);
        return true;
    }

    @Override
    public Boolean markTaskAsUncompleted(Task task) {
        taskRepository.markTaskAsUncompleted(task);
        return true;
    }

    @Override
    public Task updateTask(Task task) {
        return taskRepository.update(task);
    }

    @Override
    public Task getById(Long idTask) {
        return taskRepository.getById(idTask);
    }
}
