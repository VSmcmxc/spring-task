package com.epam.springtask.domain;

public enum Priority {
    LOW("LOW"), MEDIUM("MEDIUM"), HIGHT("HIGHT"), IMPORTANT("IMPORTANT");

    private String priority;

    Priority(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }
}
