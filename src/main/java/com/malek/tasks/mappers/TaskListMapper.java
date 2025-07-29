package com.malek.tasks.mappers;

import com.malek.tasks.domain.dto.TaskListDto;
import com.malek.tasks.domain.entities.TaskList;

public interface TaskListMapper {
    
    TaskList fromDto(TaskListDto taskListDto);

    TaskListDto toDto(TaskList taskList);
}
