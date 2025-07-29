package com.malek.tasks.mappers;

import com.malek.tasks.domain.dto.TaskDto;
import com.malek.tasks.domain.entities.Task;

public interface TaskMapper {

    Task fromDto(TaskDto taskDto);

    TaskDto toDto(Task task);
}
