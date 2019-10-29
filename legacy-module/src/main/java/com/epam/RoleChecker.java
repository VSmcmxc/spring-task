package com.epam;

public class RoleChecker {


    /**
     * TODO maven jar plugin
     * @param role
     * @return
     * @throws IncorrectRoleException
     */
    public static boolean checkRole(Role role) throws IncorrectRoleException {
        if (role == Role.ADMIN) {
            return true;
        } else {
            throw new IncorrectRoleException();
        }
    }
}
