package com.epam.controller;

import com.epam.entity.Priority;
import com.epam.entity.Task;
import com.epam.entity.User;
import com.epam.service.TaskService;
import com.epam.service.TaskServiceImpl;
import com.epam.service.UserService;
import com.epam.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {TaskController.class, TaskServiceImpl.class, UserServiceImpl.class})
public class TaskControllerTest {


    private MockMvc mockMvc;

    @Autowired
    private TaskController taskController;

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(taskController).build();
    }

    @Test
    public void testCustomerActivityFindCustomerById() throws Exception {

        User user = userService.getUserById(1l);
        Task task = new Task(3l, "To do", false, user, Priority.MEDIUM);
        TaskController mock = org.mockito.Mockito.mock(TaskController.class);

        when(mock.getTask(1l)).thenReturn(task);

        this.mockMvc.perform(get("tasks/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));

        verifyNoMoreInteractions(mock);
    }
}