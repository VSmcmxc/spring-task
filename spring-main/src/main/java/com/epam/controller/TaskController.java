package com.epam.controller;

import com.epam.entity.Task;
import com.epam.entity.User;
import com.epam.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Task getTask(@PathVariable long id) {
        return taskService.getById(id);
    }

    @GetMapping("/users/{idUser}")
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getTaskByUser(@PathVariable Long idUser) {
        return taskService.findTasksByUserId(idUser);
    }


    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task, @RequestBody User user) {
        return taskService.createTask(task, user);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        return taskService.deleteTaskById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Task createTask(@PathVariable Long id) {
        return taskService.updateTask(taskService.getById(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("markAsCompleted/{id}")
    public boolean markTaskAsComplete(@PathVariable Long id) {
        return taskService.markTaskAsCompleted(taskService.getById(id));
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("markAsUncompleted/{id}")
    public boolean markTaskAsUncompleted(@PathVariable Long id) {
        return taskService.markTaskAsUncompleted(taskService.getById(id));
    }


}
