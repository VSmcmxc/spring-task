package com.epam.springtask;

import com.epam.RoleChecker;
import com.epam.springtask.domain.Role;
import com.epam.springtask.domain.Task;
import com.epam.springtask.domain.User;
import com.epam.springtask.repository.TaskRepository;
import com.epam.springtask.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class SpringTaskApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringTaskApplication.class);

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringTaskApplication.class, args);
    }

    @Bean
    public RoleChecker roleChecker() {
        return new RoleChecker();
    }


    @Bean
    public CommandLineRunner users(UserRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new User("Vadim", "Vadim@mail.com", "password", "1", Role.ADMIN));
            repository.save(new User("Aleksey", "Aleksey@mail.com", "password", "1", Role.ADMIN));
            repository.save(new User("Maria", "Maria@mail.com", "password", "1", Role.USER));


        };
    }

    @Bean
    public CommandLineRunner tasks(TaskRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new Task("1", false, userRepository.getOne(1l)));
            repository.save(new Task("1", false, userRepository.getOne(2l)));
            repository.save(new Task("1", true, userRepository.getOne(1l)));


        };
    }
}
