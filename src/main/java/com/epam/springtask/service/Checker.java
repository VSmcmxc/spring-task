package com.epam.springtask.service;


import com.epam.springtask.domain.User;
import com.epam.springtask.dto.TaskDTO;
import com.epam.springtask.repository.UserRepository;
import com.epam.springtask.service.exception.SubscriptionException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.lang.reflect.Method;
import java.util.List;

@Aspect
@Component
public class Checker {
    @Autowired
    private UserRepository userRepository;


    @Pointcut("execution (* com.epam.springtask.service.TaskServiceImpl.createTask(..))")
    public void handle() {
    }


    @Around("handle()")
    public void checkSubscribe(ProceedingJoinPoint joinPoint) throws Throwable {
        //Подменил кастомный exception
        Object[] args = joinPoint.getArgs();
        TaskDTO taskDTO = (TaskDTO)args[0];
        User user = userRepository.getOne(taskDTO.getId_user());

        if(!user.getSubscription().equals(DigestUtils.md5DigestAsHex(("secret".getBytes())))) {
            Method[] listMethod = joinPoint.getTarget().getClass().getDeclaredMethods();
            Method result = null;
            for (Method m: listMethod) {
                if(m.getName().equals("findTasksByUserId"))
                    result = m;
            }
            List listTask = (List) result.invoke(joinPoint.getTarget(), user.getUserId());
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
