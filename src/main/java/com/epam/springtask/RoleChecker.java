package com.epam.springtask;




public class RoleChecker {
    public RoleChecker() {
    }

    public boolean checkRole(Object currentRole, Object targetRole) throws IncorrectRoleException {
        if (currentRole.equals(targetRole)) {
            return true;
        } else {
            throw new IncorrectRoleException("Role by user not correct");
        }
    }
}
