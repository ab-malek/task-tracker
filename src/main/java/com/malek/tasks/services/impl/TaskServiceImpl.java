package com.malek.tasks.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.malek.tasks.domain.entities.Task;
import com.malek.tasks.domain.entities.TaskList;
import com.malek.tasks.domain.entities.TaskPriority;
import com.malek.tasks.domain.entities.TaskStatus;
import com.malek.tasks.repositories.TaskListRepository;
import com.malek.tasks.repositories.TaskRepository;
import com.malek.tasks.services.TaskService;


@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskListRepository taskListRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
        this.taskListRepository = null;
    }

    @Override
    public List<Task> listTasks(UUID taskListId) {
        return taskRepository.findByTaskListId(taskListId);    
    }

    @Override
    public Task createTask(UUID taskListId, Task task) {
        if(null == task.getId()){
            throw new IllegalArgumentException("Task has already an ID");
        }

        if(null == task.getTitle() || task.getTitle().isBlank()){
            throw new IllegalArgumentException("Title should be present");
        }

        TaskPriority taskPriority = Optional.ofNullable(task.getPriority())
            .orElse(TaskPriority.MEDIUM);

        TaskStatus taskStatus = TaskStatus.OPEN;

        LocalDateTime now = LocalDateTime.now();
        TaskList taskList = taskListRepository.findById(taskListId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid task list ID"));

        Task newTask = new Task(
            null,
            task.getTitle(),
            task.getDescription(),
            task.getDueDate(),
            taskStatus,
            taskPriority,
            taskList,
            now,
            now
            );

        return taskRepository.save(newTask);
    }

}
