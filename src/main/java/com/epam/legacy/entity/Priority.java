package com.epam.legacy.entity;

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
