package com.epam.springtask.controller;


import com.epam.springtask.domain.User;
import com.epam.springtask.dto.TaskDTO;
import com.epam.springtask.dto.UserDTO;
import com.epam.springtask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @ResponseBody
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskDTO getTask(@PathVariable long id) {
        return taskService.getById(id);
    }

    @GetMapping("/users/{idUser}")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskDTO> getTaskByUser(@PathVariable Long idUser) {
        return taskService.findTasksByUserId(idUser);
    }


    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDTO createTask(@RequestBody TaskDTO task, @RequestBody UserDTO user) {
        return taskService.createTask(task, user);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        return taskService.deleteTaskById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public TaskDTO createTask(@PathVariable Long id) {
        return taskService.updateTask(taskService.getTaskById(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("markAsCompleted/{id}")
    public boolean markTaskAsComplete(@PathVariable Long id) {
        return taskService.markTaskAsCompleted(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("markAsUncompleted/{id}")
    public boolean markTaskAsUncompleted(@PathVariable Long id) {
        return taskService.markTaskAsUncompleted(id);
    }

    @PostMapping("/upload/{id}")
    public boolean upload(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        return taskService.upload(file, id);
    }

    @GetMapping("/sorted")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskDTO> getSortedTasks() {
        return taskService.findAllTaskSorted();
    }


}
