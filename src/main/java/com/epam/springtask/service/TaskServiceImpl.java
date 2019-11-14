package com.epam.springtask.service;


import com.epam.springtask.domain.Priority;
import com.epam.springtask.domain.Task;
import com.epam.springtask.domain.User;
import com.epam.springtask.dto.TaskDTO;
import com.epam.springtask.dto.UserDTO;
import com.epam.springtask.repository.TaskRepository;
import com.epam.springtask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service("taskService")
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;
    private UserRepository userRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public TaskDTO setTaskPriority(Priority priority, Long id) {
        Task task = taskRepository.getOne(id);
        task.setPriority(priority);
        taskRepository.save(task);
        TaskDTO taskDTO = TaskDTO.builder()
                .complete(task.getComplete())
                .description(task.getDescription())
                .priority(task.getPriority())
                .id_user(task.getUser().getUserId())
                .build();
        return taskDTO;
    }


  /*  @Override
    public List<TaskDTO> findTasksByUser(User user) {
        List<Task> tasks = taskRepository.findAllTasksByUser(user);
        List<TaskDTO> taskDTOS = new ArrayList<>();
        for (Task task : tasks) {
            TaskDTO taskDTO = TaskDTO.builder()
                    .taskId(task.getTaskId())
                    .complete(task.getComplete())
                    .description(task.getDescription())
                    .priority(task.getPriority())
                    .user(task.getUser())
                    .build();
            taskDTOS.add(taskDTO);
        }

        return taskDTOS;
    }*/

    @Override
    public List<TaskDTO> findTasksByUserId(Long id) {
        User user = userRepository.getOne(id);
        List<Task> tasks = taskRepository.findAllTasksByUser(user);
        List<TaskDTO> taskDTOS = new ArrayList<>();
        for (Task task : tasks) {
            TaskDTO taskDTO = TaskDTO.builder()
                    .complete(task.getComplete())
                    .description(task.getDescription())
                    .priority(task.getPriority())
                    .id_user(task.getUser().getUserId())
                    .build();
            taskDTOS.add(taskDTO);
        }

        return taskDTOS;
    }

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {

        Task task = Task.builder()
                .complete(taskDTO.getComplete())
                .description(taskDTO.getDescription())
                .priority(taskDTO.getPriority())
                .user(userRepository.getOne(taskDTO.getId_user()))
                .build();

        taskRepository.save(task);
        System.out.println("taskDTO");
        return taskDTO;
    }

    @Override
    public Long deleteTask(Long id) {
        taskRepository.deleteById(id);
        return id;
    }

    @Override
    public Long deleteTaskById(Long id) {
        taskRepository.deleteById(id);
        return id;
    }

    @Override
    public Boolean markTaskAsCompleted(Long id) {
        taskRepository.markTaskAsCompleted(id);
        return true;
    }

    @Override
    public Boolean markTaskAsUncompleted(Long id) {
        taskRepository.markTaskAsUncompleted(id);
        return true;
    }

    @Override
    public TaskDTO updateTask(Task task) {
        taskRepository.save(task);
        TaskDTO taskDTO = TaskDTO.builder()
                .complete(task.getComplete())
                .description(task.getDescription())
                .priority(task.getPriority())
                .id_user(task.getUser().getUserId())
                .build();
        return taskDTO;
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.getOne(id);
    }

    @Override
    public TaskDTO getById(Long idTask) {
        Task task = taskRepository.getOne(idTask);
        TaskDTO taskDTO = TaskDTO.builder()
                .complete(task.getComplete())
                .description(task.getDescription())
                .priority(task.getPriority())
                .id_user(task.getUser().getUserId())
                .build();
        return taskDTO;
    }


    @Override
    public boolean checkSubscribeByUserId(Long id) {
        if (userRepository.getOne(id).getSubscription() == DigestUtils.md5DigestAsHex(("secret".getBytes()))) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Just put file in task object
     *
     * @param file
     * @param id
     * @return
     */
    @Override
    public Boolean upload(MultipartFile file, Long id) {
        Task task = taskRepository.getOne(id);
        if (checkSubscribeByUserId(id)) {
            task.setFileName(file.getName());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<TaskDTO> findAllTaskSorted() {
        List<Task> tasks = taskRepository.findAll();
        List<TaskDTO> taskDTOS = new ArrayList<>();
        for (Task task : tasks) {
            TaskDTO taskDTO = TaskDTO.builder()
                    .complete(task.getComplete())
                    .description(task.getDescription())
                    .priority(task.getPriority())
                    .id_user(task.getUser().getUserId())
                    .build();
            taskDTOS.add(taskDTO);
        }
        Comparator<TaskDTO> comparator = Comparator.comparing(obj -> obj.getPriority());
        Collections.sort(taskDTOS, comparator);
        return taskDTOS;
    }
}
