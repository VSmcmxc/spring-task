package com.epam.service;


import com.epam.entity.Task;
import com.epam.entity.User;
import com.epam.service.exception.SubscriptionException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class Checker {


    @Pointcut("execution (* com.epam.service.TaskServiceImpl.createTask(..))")
    public void handle() {
    }


    @Around("handle()")
    public void checkSubscribe(ProceedingJoinPoint joinPoint) throws Throwable {
        //Подменил кастомный exception
        Object[] args = joinPoint.getArgs();
        User user = (User)args[1];
        /* Вызов метода рефлексивно
        joinPoint.getTarget().getClass().getMethod("findTasksByUser").invoke(user).size();
        taskService.findTasksByUser(user).size(); -более ранняя версия с @Autowired
         */
        if(!user.getSubscription().equals(DigestUtils.md5DigestAsHex(("secret".getBytes())))) {
            Method[] listMethod = joinPoint.getTarget().getClass().getDeclaredMethods();
            Method result = null;
            for (Method m: listMethod) {
                if(m.getName().equals("findTasksByUser"))
                    result = m;
            }
            List listTask = (List) result.invoke(joinPoint.getTarget(), user);
            if ( listTask.size() > 9) {
                throw new SubscriptionException("User does't have subscription");
            }
            else{
                joinPoint.proceed();
            }
        }
        else{
            joinPoint.proceed();
        }
    }


}
