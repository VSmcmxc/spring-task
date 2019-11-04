package com.epam.controller;

import com.epam.entity.Priority;
import com.epam.entity.Task;
import com.epam.entity.User;
import com.epam.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
/*@RequestMapping(value = "/tasks")*/
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping("/")
    @ResponseBody
    public String welcome() {
        return "Welcome to RestTemplate Example.";
    }


  /*  @RequestMapping("/tasks")
    @ResponseBody
    public Task getTask(@PathVariable long id) {
        return taskService.getById(1l);
    }
*/
  /*  @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public Task updateTask(@RequestBody Task task) {
        return taskService.updateTask(task);
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
    }*/
}
