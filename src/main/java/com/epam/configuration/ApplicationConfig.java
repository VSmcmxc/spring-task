package com.epam.configuration;


import com.epam.entity.Task;
import com.epam.entity.User;
import org.springframework.context.annotation.*;

import java.util.TreeMap;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = { "com.epam.service","com.epam.controller","com.epam.repository"})
public class ApplicationConfig {

    @Bean(name = "users")
    TreeMap<Long, User> getUsers() {
        TreeMap<Long, User> map = new TreeMap<>();
        map.put(1l, new User(1l, "Vadim", "Vadim@email.com", "password"));
        map.put(2l, new User(2l, "Aleksey", "Aleksey@email.com", "password"));
        map.put(3l, new User(3l, "Mary", "Mary@email.com", "password"));
        return map;
    }


    @Bean(name = "tasks")
    TreeMap<Long, Task> getTasks() {
        TreeMap<Long, Task> map = new TreeMap<>();
        map.put(1l, new Task(1l, "Task1", false, getUsers().get(1l)));
        map.put(2l, new Task(2l, "Task2", true, getUsers().get(1l)));
        map.put(3l, new Task(3l, "Task1", false, getUsers().get(2l)));
        return map;
    }



}
