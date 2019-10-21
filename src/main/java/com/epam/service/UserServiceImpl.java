package com.epam.service;

import com.epam.entity.Task;
import com.epam.entity.User;
import com.epam.repository.TaskRepository;
import com.epam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {


    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public User getUserById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public Boolean signUp(User user) {
        try {
            userRepository.create(user);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Boolean signIn(User user) {
        if (userRepository.getAll().contains(user)) {
            return true;
        }
        return false;
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
    public List<User> getAllUsers() {
        return userRepository.getAll();
    }
}
