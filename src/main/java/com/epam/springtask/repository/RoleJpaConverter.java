package com.epam.springtask.repository;

import com.epam.springtask.domain.Priority;
import com.epam.springtask.domain.Role;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class RoleJpaConverter implements AttributeConverter<Role, String> {

    @Override
    public String convertToDatabaseColumn(Role role) {
        if (role == null) {
            return null;
        }
        return role.toString();
    }

    @Override
    public Role convertToEntityAttribute(String string) {
        if (string == null) {
            return null;
        }
        try {
            return Role.valueOf(string);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

}
