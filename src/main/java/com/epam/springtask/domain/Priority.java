package com.epam.springtask.domain;

public enum Priority {
    IMPORTANT("IMPORTANT"),
    HIGHT("HIGHT"),
    MEDIUM("MEDIUM"),
    LOW("LOW");

    private String priority;

    Priority(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }
}
