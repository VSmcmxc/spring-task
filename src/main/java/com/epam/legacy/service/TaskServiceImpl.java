/*
package com.epam.legacy.service;

import com.epam.legacy.entity.Priority;
import com.epam.legacy.entity.Task;
import com.epam.legacy.entity.User;
import com.epam.legacy.repository.TaskRepository;
import com.epam.legacy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("taskService")
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;
    private UserRepository userRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Task setTaskPriority(Priority priority, Task task) {
        task.setPriority(priority);
        return taskRepository.update(task);
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
*/
