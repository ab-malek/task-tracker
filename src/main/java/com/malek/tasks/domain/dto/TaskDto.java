package com.malek.tasks.domain.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.malek.tasks.domain.entities.TaskPriority;
import com.malek.tasks.domain.entities.TaskStatus;

public record TaskDto(
    UUID id,
    String title,
    String description,
    LocalDateTime dueDate,
    TaskPriority priority,
    TaskStatus status
) {


}
