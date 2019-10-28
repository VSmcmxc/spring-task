/*
package com.epam.legacy.controller;

import com.epam.legacy.entity.Priority;
import com.epam.legacy.entity.Task;
import com.epam.legacy.entity.User;
import com.epam.legacy.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller("taskController")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    public List<Task> findTasksByUser(User user) {
        return taskService.findTasksByUser(user);
    }

    public Task createTask(Task task, User user) {
        return taskService.createTask(task, user);
    }

    public Long deleteTask(Task task) {
        return taskService.deleteTask(task);
    }

    public boolean markTaskAsComplete(Task task) {
        return taskService.markTaskAsCompleted(task);
    }

    public boolean markTaskAsUncompleted(Task task) {
        return taskService.markTaskAsUncompleted(task);
    }

    public Task setTaskPriority(Priority priority, Task task) {
        return taskService.setTaskPriority(priority, task);
    }

    public Task getTaskById(Long id) {
        return taskService.getById(id);
    }
}
*/
