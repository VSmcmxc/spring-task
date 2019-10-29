package com.epam;

public class IncorrectRoleException extends Exception {

    public IncorrectRoleException() {
    }

    public IncorrectRoleException(String message) {
        super(message);
    }

    public IncorrectRoleException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectRoleException(Throwable cause) {
        super(cause);
    }
}
