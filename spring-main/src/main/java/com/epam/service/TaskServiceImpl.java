package com.epam.service;

import com.epam.entity.Priority;
import com.epam.entity.Task;
import com.epam.entity.User;
import com.epam.repository.TaskRepository;
import com.epam.repository.UserRepository;
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
    public List<Task> findTasksByUserId(Long id) {
        List<Task> tasks = taskRepository.findAllTasksByUser(userRepository.getById(id));
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
    public Long deleteTaskById(Long id) {
        return taskRepository.deleteById(id);
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


    @Override
    public boolean checkSubscribeByUserId(Long id) {
        if (userRepository.getById(id).getSubscription() == DigestUtils.md5DigestAsHex(("secret".getBytes()))) {
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
        Task task = taskRepository.getById(id);
        if (checkSubscribeByUserId(id)) {
            task.setFile(file);
            return true;
        } else {
            return false;
        }

    }
}
