package com.epam.service;

import com.epam.configuration.ApplicationConfig;
import com.epam.configuration.DBConfig;
import com.epam.entity.Priority;
import com.epam.entity.Task;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class, DBConfig.class})
public class TaskServiceImplTest {

    private Task task;

    @Autowired
    private TaskService taskService;

    @Before
    public void setup() {
        task = taskService.getById(1l);
    }

    @Test
    public void setTaskPriority() {
        taskService.setTaskPriority(Priority.HIGHT, task);
        assertTrue(task.getPriority().equals(Priority.HIGHT));
    }

    @Test
    public void findTasksByUser() {
    }

    @Test
    public void findTasksByUserId() {
    }

    @Test
    public void createTask() {
    }

    @Test
    public void deleteTask() {
    }

    @Test
    public void deleteTaskById() {
    }

    @Test
    public void markTaskAsCompleted() {
    }

    @Test
    public void markTaskAsUncompleted() {
    }

    @Test
    public void updateTask() {
    }

    @Test
    public void getById() {
    }

    @Test
    public void checkSubscribeByUserId() {
    }

    @Test
    public void upload() {
    }
}