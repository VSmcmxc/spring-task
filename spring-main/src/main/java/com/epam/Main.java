package com.epam;

import com.epam.configuration.ApplicationConfig;
import com.epam.configuration.DBConfig;
import com.epam.controller.TaskController;
import com.epam.controller.UserController;
import com.epam.entity.Role;
import com.epam.entity.Task;
import com.epam.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {


    public static void main(String[] args) {


        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ApplicationConfig.class);
        ctx.register(DBConfig.class);
        ctx.refresh();


        UserController userController = ctx.getBean(UserController.class);
        TaskController taskController = ctx.getBean(TaskController.class);
        System.out.println(taskController.getTask(1l));
        /*System.out.println(taskController.findTasksByUser(userController.getUserById(1l)));

        System.out.println("+++++++++++++++++++++++++++++++++++");

        System.out.println(taskController.markTaskAsComplete(taskController.getTaskById(1l)));

        System.out.println(taskController.findTasksByUser(userController.getUserById(1l)));

        System.out.println("+++++++++++++++++++++++++++++++++++");


        User user = userController.getUserById(3l);
        userController.signIn(user);
        System.out.println(userController.getAllUsers());


        taskController.createTask(new Task(4l, "Hi", false, userController.getUserById(1l)), userController.getUserById(1l));
        System.out.println(taskController.findTasksByUser(userController.getUserById(1l)));
        taskController.createTask(new Task(5l, "Hi", false, userController.getUserById(1l)), userController.getUserById(1l));
        //userController.buySubscribe(userController.getUserById(1l));
        taskController.createTask(new Task(6l, "Hi", false, userController.getUserById(1l)), userController.getUserById(1l));
        taskController.createTask(new Task(7l, "Hi", false, userController.getUserById(1l)), userController.getUserById(1l));
        taskController.createTask(new Task(8l, "Hi", false, userController.getUserById(1l)), userController.getUserById(1l));
        taskController.createTask(new Task(9l, "Hi", false, userController.getUserById(1l)), userController.getUserById(1l));
        taskController.createTask(new Task(10l, "Hi", false, userController.getUserById(1l)), userController.getUserById(1l));
        taskController.createTask(new Task(11l, "Hi", false, userController.getUserById(1l)), userController.getUserById(1l));
        taskController.createTask(new Task(12l, "Hi", false, userController.getUserById(1l)), userController.getUserById(1l));
        taskController.createTask(new Task(13l, "Hi", false, userController.getUserById(1l)), userController.getUserById(1l));
        taskController.createTask(new Task(14l, "Hi", false, userController.getUserById(1l)), userController.getUserById(1l));
        //System.out.println(taskController.setTaskPriority(Priority.IMPORTANT, taskController.getTaskById(1l)));*/


    }
}
