package com.epam.springtask;


import com.epam.IncorrectRoleException;

public class RoleChecker {
    public RoleChecker() {
    }

    public boolean checkRole(Object currentRole, Object targetRole) throws com.epam.IncorrectRoleException {
        if (currentRole.equals(targetRole)) {
            return true;
        } else {
            throw new IncorrectRoleException("Role by user not correct");
        }
    }
}
