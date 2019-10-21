package com.epam;

import com.epam.configuration.ApplicationConfig;
import com.epam.controller.UserController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ApplicationConfig.class);
        ctx.refresh();

        UserController userController = ctx.getBean(UserController.class);
        System.out.println(userController.getUserById(1l));


    }
}
