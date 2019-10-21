package com.epam.repository;

import com.epam.entity.Task;
import com.epam.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Repository("taskRepository")
public class TaskRepositoryImpl implements TaskRepository {


    private TreeMap<Long, Task> taskMap;

    @Autowired
    @Qualifier("tasks")
    public void setTaskMap(TreeMap<Long, Task> taskMap) {
        this.taskMap = taskMap;
    }

    @Override
    public List<Task> findAllTasksByUser(User user) {
        List<Task> tasks = new ArrayList<>();
        for (Map.Entry<Long, Task> entry : taskMap.entrySet()) {
            if (entry.getValue().equals(user)) {
                tasks.add(entry.getValue());
            }
        }
        return tasks;
    }

    @Override
    public Boolean markTaskAsCompleted(Task task) {
        task.setComplete(true);
        update(task);
        return true;
    }

    @Override
    public Boolean markTaskAsUncompleted(Task task) {
        task.setComplete(false);
        update(task);
        return true;
    }

    @Override
    public Task create(Task task) {
        return taskMap.put(task.getTaskId(), task);
    }

    @Override
    public Task getById(Long id) {
        return taskMap.get(id);
    }

    @Override
    public Task update(Task task) {
        return taskMap.put(task.getTaskId(), task);
    }

    @Override
    public Long deleteById(Long id) {
        taskMap.remove(id);
        return id;
    }

    @Override
    public List<Task> getAll() {
        List<Task> tasks = (List<Task>) taskMap.values();
        return tasks;
    }
}
