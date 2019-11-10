package com.epam.controller;

import com.com.IncorrectRoleException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(IncorrectRoleException.class)
    public void catchException(IncorrectRoleException ex) {
        System.out.println("Incorrect role \n" + ex.getLocalizedMessage());
    }

    @ExceptionHandler(SQLException.class)
    public void catchException(SQLException ex) {
        System.out.println("Database exception \n" + ex.getLocalizedMessage());
    }

    @ExceptionHandler(Exception.class)
    public void catchException(Exception ex) {
        System.out.println("Something wrong:  \n" + ex.getLocalizedMessage());
    }
}
