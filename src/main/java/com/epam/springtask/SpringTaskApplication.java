package com.epam.springtask;

import com.epam.springtask.domain.Role;
import com.epam.springtask.domain.User;
import com.epam.springtask.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class SpringTaskApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringTaskApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringTaskApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new User("Vadim", "Vadim@mail.com", "password", "1", Role.ADMIN));
			repository.save(new User("Aleksey", "Aleksey@mail.com", "password", "1", Role.ADMIN));
			repository.save(new User("Maria", "Maria@mail.com", "password", "1", Role.USER));

            // fetch all customers
            log.info("Users found with findAll():");
            log.info("-------------------------------");
            for (User user : repository.findAll()) {
                log.info(user.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Optional<User> user = repository.findById(1L);
            log.info("User found with findById(1L):");
            log.info("--------------------------------");
            log.info(user.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");


            log.info("");
        };
    }
}
