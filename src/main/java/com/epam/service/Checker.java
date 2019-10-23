package com.epam.service;


import com.epam.entity.User;
import com.epam.service.exception.SubscriptionException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

@Aspect
@Component
public class Checker {

    TaskService taskService;

    @Autowired
    public Checker(TaskService taskService){
        this.taskService = taskService;
    }

    @Pointcut("execution (* com.epam.service.TaskServiceImpl.createTask(..))")
    public void handle() {
    }

    @Around("handle()")
    public void checkSubscribe(ProceedingJoinPoint joinPoint) throws Throwable {
        //System.out.println("hello");
        Object[] args = joinPoint.getArgs();
        User user = (User)args[1];
        if(!user.getSubscription().equals(DigestUtils.md5DigestAsHex(("secret".getBytes())))) {
            if (taskService.findTasksByUser(user).size() > 9) {
                throw new SubscriptionException("User does't have subscription");
            }
            else{
                Object result = joinPoint.proceed();
            }
        }
        else{
            Object result = joinPoint.proceed();
        }
    }


}
