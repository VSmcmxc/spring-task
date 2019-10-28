package com.epam.service.test;


import com.epam.entity.Task;
import com.epam.entity.User;
import com.epam.service.TaskService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class TestSpringAspect {

    private TaskService taskService;

    @Autowired
    public TestSpringAspect(TaskService taskService) {
        this.taskService = taskService;
    }

    @Pointcut("@annotation(SubscriptionChecker)")
    public void selectAllMethodsAvaliable() {

    }

    @Before(value = "selectAllMethodsAvaliable()")
    public void beforeAdvice(ProceedingJoinPoint joinPoint) {
        User user = (User) joinPoint.getArgs()[1];
        List<Task> tasks = taskService.findTasksByUser(user);
        System.out.println("Current number of tasks by user " + user.getUserName() + " is: " + tasks.size());
    }

  /*  @After("selectAllMethodsAvaliable()")
    public void afterAdvice() {
        System.out.println("Developer's profile has been initiated.");
    }

    @AfterReturning(pointcut = "selectAllMethodsAvaliable()", returning = "someValue")
    public void afterReturningAdvice(Object someValue) {
        System.out.println("Value: " + someValue.toString());
    }

    @AfterThrowing(pointcut = "selectAllMethodsAvaliable()", throwing = "e")
    public void inCaseOfExceptionThrowAdvice(ClassCastException e) {
        System.out.println("We have an exception here: " + e.toString());
    }*/

}

