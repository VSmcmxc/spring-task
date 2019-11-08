package com.epam.controller;

import com.epam.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
/*@RequestMapping(value = "/tasks")*/
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping("/task")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
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
