package com.epam.springtask.repository;

import com.epam.springtask.domain.Priority;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class PriorityJpaConverter implements AttributeConverter<Priority, String> {

    @Override
    public String convertToDatabaseColumn(Priority priority) {
        if (priority == null) {
            return null;
        }
        return priority.toString();
    }

    @Override
    public Priority convertToEntityAttribute(String string) {
        if (string == null) {
            return null;
        }
        try {
            return Priority.valueOf(string);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

}
