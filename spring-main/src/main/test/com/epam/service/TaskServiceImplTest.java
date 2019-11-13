package com.epam.service;

import com.epam.configuration.ApplicationConfig;
import com.epam.configuration.DBConfig;
import com.epam.entity.Priority;
import com.epam.entity.Task;
import com.epam.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration()
@ContextConfiguration(classes = {ApplicationConfig.class, DBConfig.class})
public class TaskServiceImplTest {

    private Task task;
    private User user;

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @Before
    public void setup() {
        task = taskService.getById(1l);
        user = userService.getUserById(1l);
    }

    @Test
    public void setTaskPriority() {
        taskService.setTaskPriority(Priority.HIGHT, task);
        assertTrue(task.getPriority().equals(Priority.HIGHT));
    }


    @Test
    public void findTasksByUserId() {
        assertNotNull(taskService.findTasksByUserId(1l));
    }

 @Test
    public void createTask() {
        assertNotNull(taskService.createTask(new Task("To do", true, user), user));
    }



    @Test
    public void deleteTaskById() {
        assertTrue(taskService.deleteTaskById(3l) == 3l);
    }

    @Test
    public void markTaskAsCompleted() {
        assertTrue(taskService.markTaskAsCompleted(task));
        assertTrue(taskService.getById(1l).getComplete());
    }


    @Test
    public void updateTask() {
        task.setDescription("test");
        taskService.updateTask(task);
        assertTrue(taskService.getById(1l).getDescription().equals("test"));
    }


}
