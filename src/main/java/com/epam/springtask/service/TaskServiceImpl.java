package com.epam.springtask.service;


import com.epam.springtask.domain.Priority;
import com.epam.springtask.domain.Task;
import com.epam.springtask.domain.User;
import com.epam.springtask.repository.TaskRepository;
import com.epam.springtask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

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
    public Task setTaskPriority(Priority priority, Long id) {
        Task task = taskRepository.getOne(id);
        task.setPriority(priority);
        return taskRepository.save(task);
    }


    @Override
    public List<Task> findTasksByUser(User user) {
        List<Task> tasks = taskRepository.findAllTasksByUser(user);
        return tasks;
    }

    @Override
    public List<Task> findTasksByUserId(Long id) {
        List<Task> tasks = taskRepository.findAllTasksByUser(userRepository.getOne(id));
        return tasks;
    }

    @Override
    public Task createTask(Task task, User user) {
        task.setUser(user);
        return taskRepository.save(task);

    }

    @Override
    public Long deleteTask(Long id) {
        taskRepository.deleteById(id);
        return id;
    }

    @Override
    public Long deleteTaskById(Long id) {
        taskRepository.deleteById(id);
        return id;
    }

    @Override
    public Boolean markTaskAsCompleted(Long id) {
        taskRepository.markTaskAsCompleted(id);
        return true;
    }

    @Override
    public Boolean markTaskAsUncompleted(Long id) {
        taskRepository.markTaskAsUncompleted(id);
        return true;
    }

    @Override
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task getById(Long idTask) {
        return taskRepository.getOne(idTask);
    }


    @Override
    public boolean checkSubscribeByUserId(Long id) {
        if (userRepository.getOne(id).getSubscription() == DigestUtils.md5DigestAsHex(("secret".getBytes()))) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Just put file in task object
     *
     * @param file
     * @param id
     * @return
     */
    @Override
    public Boolean upload(MultipartFile file, Long id) {
        Task task = taskRepository.getOne(id);
        if (checkSubscribeByUserId(id)) {
            task.setFileName(file.getName());
            return true;
        } else {
            return false;
        }

    }
}
