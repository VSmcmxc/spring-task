package com.epam;

import com.epam.configuration.ApplicationConfig;
import com.epam.controller.UserController;
import com.epam.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ApplicationConfig.class);
        ctx.refresh();

        UserController userController = ctx.getBean(UserController.class);
        System.out.println(userController.getUserById(1l));

        userController.signUp(new User(5l,"Dfcz","Dacz@mail.ru","123"));
        System.out.println(userController.getUserById(5l));

        System.out.println(userController.getAllUsers());

    }
}
