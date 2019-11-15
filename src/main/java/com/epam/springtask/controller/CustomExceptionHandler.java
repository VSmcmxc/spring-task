package com.epam.springtask.controller;


import com.epam.springtask.IncorrectRoleException;
import com.epam.springtask.service.exception.SubscriptionException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.RollbackException;
import java.sql.SQLException;

@ControllerAdvice
@ResponseBody
public class CustomExceptionHandler {

    /**
     * @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Data integrity violation")
     * @ExceptionHandler(DataIntegrityViolationException.class)
     * public void handleConflict() {
     * }
     * @param ex
     */

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Validation not correct")
    @ExceptionHandler(RollbackException.class)
    public void catchException(RollbackException ex) {
        System.out.println("Validation not correct \n" + ex.getLocalizedMessage());
        String bodyOfResponse = "Validation not correct \n" + ex.getLocalizedMessage();

    }
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Validation not correct")
    @ExceptionHandler(IncorrectRoleException.class)
    public void catchException(IncorrectRoleException ex) {
        System.out.println("Incorrect role \n" + ex.getLocalizedMessage());
    }


    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "User does't have subscription")
    @ExceptionHandler(SubscriptionException.class)
    public void catchException(SubscriptionException ex) {
        System.out.println(ex.getLocalizedMessage());
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Database exception")
    @ExceptionHandler(SQLException.class)
    public void catchException(SQLException ex) {
        System.out.println("Database exception \n" + ex.getLocalizedMessage());
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error, see in logs!!!")
    @ExceptionHandler(Exception.class)
    public void catchException(Exception ex) {
        System.out.println("Something wrong:  \n" + ex.getLocalizedMessage());
    }
}
